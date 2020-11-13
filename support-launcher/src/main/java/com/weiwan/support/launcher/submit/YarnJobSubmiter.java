package com.weiwan.support.launcher.submit;

import com.weiwan.support.core.constant.SupportKey;
import com.weiwan.support.launcher.envs.JOBOptions;
import com.weiwan.support.launcher.envs.JVMOptions;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.client.deployment.ClusterDeploymentException;
import org.apache.flink.client.deployment.application.ApplicationConfiguration;
import org.apache.flink.client.program.ClusterClient;
import org.apache.flink.client.program.ClusterClientProvider;
import org.apache.flink.yarn.YarnClientYarnClusterInformationRetriever;
import org.apache.flink.yarn.YarnClusterDescriptor;
import org.apache.flink.yarn.YarnClusterInformationRetriever;
import org.apache.flink.yarn.configuration.YarnDeploymentTarget;
import org.apache.hadoop.yarn.api.records.ApplicationId;
import org.apache.hadoop.yarn.client.api.YarnClient;

import java.util.Map;

/**
 * @Author: xiaozhennan
 * @Date: 2020/11/2 15:23
 * @Package: com.weiwan.support.launcher.submit.YarnJobSubmiter
 * @ClassName: YarnJobSubmiter
 * @Description:
 **/
public class YarnJobSubmiter implements JobSubmiter {

    private YarnClient yarnClient;

    public YarnJobSubmiter(YarnClient yarnClient) {
        this.yarnClient = yarnClient;
    }

    @Override
    public Object submitJob(JobSubmitInfo jobInfo) {
        YarnClusterInformationRetriever informationRetriever = YarnClientYarnClusterInformationRetriever.create(yarnClient);
        org.apache.flink.configuration.Configuration flinkConfiguration = jobInfo.getFlinkConfiguration();

        //checkpoint 恢复
        if (StringUtils.isNotEmpty(jobInfo.getSavePointPath())) {
            flinkConfiguration.set(
                    JOBOptions.SAVEPOINT_PATH,
                    jobInfo.getSavePointPath());
        }

        flinkConfiguration.set(
                JOBOptions.INCREMENTAL_CHECKPOINTS,
                true);
        //核心jar包
        flinkConfiguration.set(
                JOBOptions.JARS,
                jobInfo.getUserJars());

        flinkConfiguration.set(
                JOBOptions.PROVIDED_LIB_DIRS,
                jobInfo.getUserClasspath());

        flinkConfiguration.set(
                JOBOptions.FLINK_DIST_JAR,
                jobInfo.getFlinkDistJar());
        //设置为application模式
        flinkConfiguration.set(
                JOBOptions.TARGET,
                YarnDeploymentTarget.APPLICATION.getName());
        //yarn application name
        flinkConfiguration.set(
                JOBOptions.APPLICATION_NAME,
                jobInfo.getAppName());

        flinkConfiguration.set(
                JOBOptions.APPLICATION_TYPE,
                jobInfo.getAppType());

        if (StringUtils.isNotEmpty(jobInfo.getYarnQueue())) {
            flinkConfiguration.set(
                    JOBOptions.APPLICATION_QUEUE,
                    jobInfo.getYarnQueue());
        }

        StringBuffer jmVmDynamic = new StringBuffer();
        StringBuffer tmVmDynamic = new StringBuffer();
        if (jobInfo.getDynamicParameters() != null && jobInfo.getDynamicParameters().size() > 0) {
            Map<String, String> dynamicParameters = jobInfo.getDynamicParameters();
            for (String parameterKey : dynamicParameters.keySet()) {
                String dynamicStr = "-D" + parameterKey + "=" + dynamicParameters.get(parameterKey);
                jmVmDynamic.append(" ");
                jmVmDynamic.append(dynamicStr);
                tmVmDynamic.append(" ");
                tmVmDynamic.append(dynamicStr);
                flinkConfiguration.setString(parameterKey, dynamicParameters.get(parameterKey));
            }

            jmVmDynamic.append(" -Dlog.file=/tmp/flink_support/logs/" + dynamicParameters.get(SupportKey.USER_RESOURCE_ID) + "/jobmanager.log");
            tmVmDynamic.append(" -Dlog.file=/tmp/flink_support/logs/" + dynamicParameters.get(SupportKey.USER_RESOURCE_ID) + "/taskmanager.log");
            flinkConfiguration.set(JVMOptions.FLINK_LOG_DIR, " /tmp/flink_support/logs/" + dynamicParameters.get(SupportKey.USER_RESOURCE_ID));
        }
        flinkConfiguration.set(JVMOptions.FLINK_TM_JVM_OPTIONS, tmVmDynamic.toString());
        flinkConfiguration.set(JVMOptions.FLINK_JM_JVM_OPTIONS, jmVmDynamic.toString());

        //		设置用户jar的参数和主类
        ApplicationConfiguration appConfig = new ApplicationConfiguration(jobInfo.getAppArgs(), jobInfo.getAppClassName());

        YarnClusterDescriptor yarnClusterDescriptor = new YarnClusterDescriptor(
                flinkConfiguration,
                jobInfo.getYarnConfiguration(),
                yarnClient,
                informationRetriever,
                true);
        ClusterClientProvider<ApplicationId> clusterClientProvider = null;

        try {
            clusterClientProvider = yarnClusterDescriptor.deployApplicationCluster(jobInfo.getClusterSpecification(), appConfig);
        } catch (ClusterDeploymentException e) {
            e.printStackTrace();
        }

        ClusterClient<ApplicationId> clusterClient = clusterClientProvider.getClusterClient();
        ApplicationId applicationId = clusterClient.getClusterId();
        System.out.println(applicationId);
        return applicationId;
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