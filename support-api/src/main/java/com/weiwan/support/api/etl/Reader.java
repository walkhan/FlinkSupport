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
package com.weiwan.support.api.etl;

import com.weiwan.support.api.Support;
import com.weiwan.support.api.config.SupportContext;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.io.Serializable;

/**
 * @Author: xiaozhennan
 * @Date: 2020/9/28 15:56
 * @Package: com.weiwan.support.api.etl.Reader
 * @ClassName: Reader
 * @Description:
 **/
public interface Reader<OUT> extends Support<StreamExecutionEnvironment>, Serializable {

    public DataStream<OUT> read(StreamExecutionEnvironment env, SupportContext context);


}
