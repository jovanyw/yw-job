package com.jovan.job.service.impl;

import com.jovan.job.entity.Executor;
import com.jovan.job.entity.Task;
import com.jovan.job.mapper.TaskMapper;
import com.jovan.job.schedule.Schedule;
import com.jovan.job.service.ExecutorService;
import com.jovan.job.service.RemoteCallExecutorService;
import com.jovan.job.service.TaskService;
import org.springframework.http.HttpRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yw
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Resource
    private Schedule schedule;

    @Resource
    private TaskMapper taskMapper;

    @Resource
    private ExecutorService executorService;

    @Resource
    private RemoteCallExecutorService remoteCallExecutorService;

    @Override
    @Async
    public Boolean run(Long id) {
        // task id找到对应的task
        Task task = taskMapper.getTaskById(id);
        // task中executor id找到executor
        Executor executor = executorService.getExecutorById(task.getId());
        // 远程调用executor中的run
        remoteCallExecutorService.runTask(task.getJobHandler(), executor);
        return true;
    }

    @Override
    public Boolean start(Long id) {
        // 设置task的状态为start
        Task task = taskMapper.getTaskById(id);
        if (null == task || task.getStatus() == 1) {
            return false;
        }
        task.setStatus(1);
        taskMapper.updateTask(task);
        // 将任务加入队列
        schedule.addTask(task);
        return true;
    }

    @Override
    public Boolean stop(Long id) {
        // 设置task的状态为stop
        Task task = taskMapper.getTaskById(id);
        if (null == task || task.getStatus() == 3) {
            return false;
        }
        task.setStatus(3);
        taskMapper.updateTask(task);
        // 从队列中移除任务
        schedule.removeTask(task);
        return true;
    }
}
