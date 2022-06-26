package com.jovan.job.controller;

import com.jovan.job.common.vo.ResultMessage;
import com.jovan.job.service.SchedulerService;
import com.jovan.job.vo.req.ExecutorReq;
import com.jovan.job.vo.res.ExecutorResp;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yw
 */
@RestController
public class SchedulerController {
    @Resource
    private SchedulerService schedulerService;

    @PostMapping("/executors")
    public ResultMessage<Boolean> createExecutor(@RequestBody ExecutorReq req) {
        return ResultMessage.success(schedulerService.createExecutor(req));
    }

    @GetMapping("/executors/{id}")
    public ResultMessage<ExecutorResp> getExecutorInfo(@PathVariable Long id) {
        return ResultMessage.success(schedulerService.getExecutorInfo(id));
    }

    @PostMapping("/executors/{id}")
    public ResultMessage<Boolean> updateExecutor(@PathVariable Long id,
                                                 @RequestBody ExecutorReq req) {
        return ResultMessage.success(schedulerService.updateExecutor(id, req));
    }

    @PostMapping("/executors/{id}:remove")
    public ResultMessage<Boolean> deleteExecutor(@PathVariable Long id) {
        return ResultMessage.success(schedulerService.deleteExecutor(id));
    }

    @GetMapping("/executors")
    public ResultMessage<List<ExecutorResp>> getAllExecutors() {
        return ResultMessage.success(schedulerService.getAllExecutors());
    }
}
