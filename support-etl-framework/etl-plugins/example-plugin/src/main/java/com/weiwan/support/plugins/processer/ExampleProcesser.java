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
package com.weiwan.support.plugins.processer;


import com.weiwan.support.api.config.SupportContext;
import com.weiwan.support.api.pojo.DataRecord;
import com.weiwan.support.etl.framework.api.processer.BaseProcessHandler;
import com.weiwan.support.etl.framework.api.processer.BaseProcesser;

/**
 * @Author: xiaozhennan
 * @Date: 2020/11/18 17:09
 * @Package: com.weiwan.support.plugins.processer.ExampleProcesser
 * @ClassName: ExampleProcesser
 * @Description:
 **/
public class ExampleProcesser extends BaseProcesser<DataRecord<String>, DataRecord<String>> {

    @Override
    public BaseProcessHandler<DataRecord<String>, DataRecord<String>> getProcessHandler(SupportContext context) {
        ExampleProcessHandler exampleProcessHandler = new ExampleProcessHandler();
        exampleProcessHandler.setContext(context);
        return exampleProcessHandler;
    }

    @Override
    public void require(SupportContext context) {

    }
}
