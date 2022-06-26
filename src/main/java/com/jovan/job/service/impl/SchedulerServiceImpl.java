package com.jovan.job.service.impl;

import com.jovan.job.service.SchedulerService;
import com.jovan.job.vo.req.ExecutorReq;
import com.jovan.job.vo.res.ExecutorResp;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yw
 */
@Service
public class SchedulerServiceImpl implements SchedulerService {
    @Override
    public Boolean createExecutor(ExecutorReq req) {
        return null;
    }

    @Override
    public ExecutorResp getExecutorInfo(Long id) {
        return null;
    }

    @Override
    public Boolean updateExecutor(Long id, ExecutorReq req) {
        return null;
    }

    @Override
    public Boolean deleteExecutor(Long id) {
        return null;
    }

    @Override
    public List<ExecutorResp> getAllExecutors() {
        return null;
    }
}
