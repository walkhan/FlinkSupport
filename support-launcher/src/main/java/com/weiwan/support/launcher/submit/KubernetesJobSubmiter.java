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
package com.weiwan.support.launcher.submit;

/**
 * @Author: xiaozhennan
 * @Date: 2020/11/2 15:23
 * @Package: com.weiwan.support.launcher.submit.KubernetesJobSubmiter
 * @ClassName: KubernetesJobSubmiter
 * @Description:
 **/
public class KubernetesJobSubmiter implements JobSubmiter {
    @Override
    public Object submitJob(JobSubmitInfo jobSubmitInfo) {

        return null;
    }

    @Override
    public Object stopJob(JobSubmitInfo jobInfo) {
        return null;
    }

    @Override
    public Object getClusterClientForAppId(JobSubmitInfo jobInfo) {
        return null;
    }
}
