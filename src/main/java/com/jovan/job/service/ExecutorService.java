package com.jovan.job.service;

import com.jovan.job.entity.Executor;
import com.jovan.job.vo.req.TaskReq;
import com.jovan.job.vo.res.TaskResp;

import java.util.List;

/**
 * @author yw
 */
public interface ExecutorService {
    Boolean createTask(Long executorId, TaskReq taskReq);

    TaskResp getTaskInfo(Long executorId, Long id);

    Boolean updateTask(Long executorId, Long id, TaskReq taskReq);

    Boolean deleteTask(Long executorId, Long id);

    List<TaskResp> getAllTasks(Long executorId);

    Executor getExecutorById(Long id);
}
