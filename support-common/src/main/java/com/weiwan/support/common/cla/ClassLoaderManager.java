/*
 *      Copyright [2020] [xiaozhennan1995@gmail.com]
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 *      http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.weiwan.support.common.cla;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: xiaozhennan
 * @Date: 2020/7/20 14:18
 * @Package: com.weiwan.support.core
 * @ClassName: ClassLoaderManager
 * @Description:
 **/
public class ClassLoaderManager {

    private static final Logger LOG = LoggerFactory.getLogger(ClassLoaderManager.class);

    private static Map<String, URLClassLoader> pluginClassLoader = new ConcurrentHashMap<>();
    public static <R> R newInstance(ClassLoaderSupplier<R> supplier) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return ClassLoaderSupplierCallBack.callbackAndReset(supplier, classLoader);
    }

    private static URLClassLoader retrieveClassLoad(List<URL> jarUrls) {
        jarUrls.sort(Comparator.comparing(URL::toString));
        String jarUrlkey = StringUtils.join(jarUrls, "_");
        return pluginClassLoader.computeIfAbsent(jarUrlkey, k -> {
            try {
                URL[] urls = jarUrls.toArray(new URL[0]);
                ClassLoader parentClassLoader = Thread.currentThread().getContextClassLoader();
                URLClassLoader classLoader = new URLClassLoader(urls, parentClassLoader);
                LOG.info("jarUrl:{} create ClassLoad successful...", jarUrlkey);
                return classLoader;
            } catch (Throwable e) {
                LOG.error("retrieve ClassLoad happens error:{}", e.getMessage());
                throw new RuntimeException("retrieve ClassLoad happens error");
            }
        });
    }

    public static Set<URL> getClassPath() {
        Set<URL> classPaths = new HashSet<>();
        for (Map.Entry<String, URLClassLoader> entry : pluginClassLoader.entrySet()) {
            classPaths.addAll(Arrays.asList(entry.getValue().getURLs()));
        }
        return classPaths;
    }
}
