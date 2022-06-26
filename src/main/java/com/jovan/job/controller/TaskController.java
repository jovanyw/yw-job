package com.jovan.job.controller;

import com.jovan.job.common.vo.ResultMessage;
import com.jovan.job.service.TaskService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yw
 */
@RestController
public class TaskController {
    @Resource
    private TaskService taskService;

    @PostMapping("/tasks/{id}:run")
    public ResultMessage<Boolean> runTask(@PathVariable Long id) {
        return ResultMessage.success(taskService.run(id));
    }

    @PostMapping("/tasks/{id}:start")
    public ResultMessage<Boolean> startTask(@PathVariable Long id) {
        return ResultMessage.success(taskService.start(id));
    }

    @PostMapping("/tasks/{id}:stop")
    public ResultMessage<Boolean> stopTask(@PathVariable Long id) {
        return ResultMessage.success(taskService.stop(id));
    }
}
