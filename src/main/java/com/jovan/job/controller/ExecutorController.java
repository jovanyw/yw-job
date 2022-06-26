package com.jovan.job.controller;

import com.jovan.job.common.vo.ResultMessage;
import com.jovan.job.service.ExecutorService;
import com.jovan.job.vo.req.TaskReq;
import com.jovan.job.vo.res.TaskResp;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yw
 */
@RestController
public class ExecutorController {
    @Resource
    private ExecutorService executorService;

    @PostMapping("/executors/{executorId}/tasks")
    public ResultMessage<Boolean> createTask(@PathVariable Long executorId,
                                             @RequestBody TaskReq taskReq) {
        return ResultMessage.success(executorService.createTask(executorId, taskReq));
    }

    @GetMapping("/executors/{executorId}/tasks/{id}")
    public ResultMessage<TaskResp> getTaskInfo(@PathVariable Long executorId, @PathVariable Long id) {
        return ResultMessage.success(executorService.getTaskInfo(executorId, id));
    }

    @PostMapping("/executors/{executorId}/tasks/{id}")
    public ResultMessage<Boolean> updateTask(@PathVariable Long executorId,
                                             @PathVariable Long id,
                                             @RequestBody TaskReq taskReq) {
        return ResultMessage.success(executorService.updateTask(executorId, id, taskReq));
    }

    @PostMapping("/executors/{executorId}/tasks/{id}:remove")
    public ResultMessage<Boolean> deleteTask(@PathVariable Long executorId, @PathVariable Long id) {
        return ResultMessage.success(executorService.deleteTask(executorId, id));
    }

    @GetMapping("/executors/{executorId}/tasks")
    public ResultMessage<List<TaskResp>> getAllTasks(@PathVariable Long executorId) {
        return ResultMessage.success(executorService.getAllTasks(executorId));
    }
}
