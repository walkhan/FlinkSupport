package com.weiwan.support.launcher.submit;

/**
 * @Author: xiaozhennan
 * @Date: 2020/11/2 15:28
 * @Package: com.weiwan.support.launcher.submit.JobSubmiter
 * @ClassName: JobSubmiter
 * @Description:
 **/
public interface JobSubmiter {

    Object submitJob(JobSubmitInfo jobInfo) throws Exception;

    Object stopJob(JobSubmitInfo jobInfo);

    Object getClusterClientForAppId(JobSubmitInfo jobInfo);

}
