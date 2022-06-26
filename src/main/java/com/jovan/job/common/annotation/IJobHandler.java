package com.jovan.job.common.annotation;

/**
 * @author yw
 */
public abstract class IJobHandler {
    public abstract void execute() throws Exception;

    public void init() throws Exception {}

    public void destroy() throws Exception {}
}
