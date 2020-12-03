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
package com.weiwan.support.core.start;

import org.apache.flink.api.common.JobID;

/**
 * @Author: xiaozhennan
 * @Date: 2020/9/28 16:12
 * @Package: com.weiwan.support.core.start.TaskResult
 * @ClassName: TaskResult
 * @Description:
 **/
public class TaskResult {

    private JobID jobID;

    public TaskResult(JobID jobID) {
        this.jobID = jobID;
    }


    public JobID getJobID() {
        return jobID;
    }

    public void setJobID(JobID jobID) {
        this.jobID = jobID;
    }
}