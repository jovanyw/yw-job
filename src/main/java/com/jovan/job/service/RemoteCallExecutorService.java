package com.jovan.job.service;

import com.jovan.job.entity.Executor;

/**
 * @author yw
 */
public interface RemoteCallExecutorService {
    void runTask(String jobHandler, Executor executor);
}
