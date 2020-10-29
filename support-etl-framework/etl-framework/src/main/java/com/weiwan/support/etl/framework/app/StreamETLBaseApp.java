package com.weiwan.support.etl.framework.app;

import com.weiwan.support.core.StreamAppSupport;
import com.weiwan.support.core.SupportAppContext;
import com.weiwan.support.core.pojo.DataRecord;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSink;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @Author: xiaozhennan
 * @Date: 2020/9/29 14:54
 * @Package: com.weiwan.support.etl.framework.app.StreamETLBaseAPP
 * @ClassName: StreamETLBaseAPP
 * @Description:
 **/
public class StreamETLBaseApp extends StreamAppSupport<DataRecord, DataRecord> {

    public StreamETLBaseApp(StreamExecutionEnvironment environment, SupportAppContext appContext) {
        super(environment, appContext);
    }

    @Override
    public DataStream<DataRecord> streamOpen(StreamExecutionEnvironment environment, SupportAppContext appContext) {
        SupportAppContext context = getContext();
        StreamExecutionEnvironment env = getEnv();

        return null;
    }


    @Override
    public DataStream<DataRecord> streamProcess(DataStream<DataRecord> inputStream) {
        return null;
    }


    @Override
    public DataStreamSink streamOutput(DataStream<DataRecord> outputStream) {
        return null;
    }
}
