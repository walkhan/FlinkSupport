package com.weiwan.support.core.coprocessor;

import com.weiwan.support.core.SupportAppContext;
import com.weiwan.support.core.api.SupportDataFlow;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: xiaozhennan
 * @Date: 2020/11/12 9:54
 * @Package: com.weiwan.support.core.coprocessor.EnvCoprocessor
 * @ClassName: EnvCoprocessor
 * @Description:
 **/
public class FirstPreCoprocessor extends SupportCoprocessor {
    private static final Logger logger = LoggerFactory.getLogger(FirstPreCoprocessor.class);


    public FirstPreCoprocessor(SupportAppContext context) {
        super(context);
    }

    @Override
    public <E, S1, S2> Object process(E env, SupportDataFlow<E, S1, S2> dataFlow, Object obj) throws Exception {
        logger.info("env coprocessor execute");
        if (env instanceof StreamExecutionEnvironment) {

            return nextProcess(env, dataFlow, obj);
        } else if (env instanceof ExecutionEnvironment) {
            return null;
        } else {
            return null;
        }
    }
}
