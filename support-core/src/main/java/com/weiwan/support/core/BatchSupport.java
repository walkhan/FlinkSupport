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
package com.weiwan.support.core;

import com.weiwan.support.api.FlinkSupport;
import com.weiwan.support.api.config.SupportContext;
import com.weiwan.support.api.options.RunOptions;
import com.weiwan.support.core.start.TaskResult;
import org.apache.flink.api.java.ExecutionEnvironment;

/**
 * @Author: xiaozhennan
 * @Date: 2020/9/28 16:25
 * @Package: com.weiwan.support.core.BatchSupport
 * @ClassName: BatchSupport
 * @Description:
 **/
public class BatchSupport<IN, OIN> implements FlinkSupport<ExecutionEnvironment> {


    private ExecutionEnvironment internalEnv;
    private SupportContext internalContext;

    public BatchSupport(ExecutionEnvironment environment, SupportContext context) {
        this.internalEnv = environment;
        this.internalContext = context;
    }

    @Override
    public void initEnv(ExecutionEnvironment env, SupportContext context, RunOptions options) {
        this.internalEnv = env;
        this.internalContext = context;
    }

    @Override
    public ExecutionEnvironment getEnv() {
        return this.internalEnv;
    }

    @Override
    public SupportContext getContext() {
        return this.internalContext;
    }

    @Override
    public void setContext(SupportContext context) {
        this.internalContext = context;
    }

    @Override
    public TaskResult executeTask() throws Exception {
        return null;
    }

    private TaskResult submit() {
        return null;
    }
}
