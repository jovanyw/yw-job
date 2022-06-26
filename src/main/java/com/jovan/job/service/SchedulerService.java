package com.jovan.job.service;

import com.jovan.job.common.vo.ResultMessage;
import com.jovan.job.vo.req.ExecutorReq;
import com.jovan.job.vo.res.ExecutorResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface SchedulerService {
    Boolean createExecutor(ExecutorReq req);

    ExecutorResp getExecutorInfo(Long id);

    Boolean updateExecutor(Long id, ExecutorReq req);

    Boolean deleteExecutor(Long id);

    List<ExecutorResp> getAllExecutors();
}
