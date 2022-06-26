package com.jovan.job.service;

/**
 * @author yw
 */
public interface TaskService {
    Boolean run(Long id);

    Boolean start(Long id);

    Boolean stop(Long id);
}
