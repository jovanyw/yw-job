package com.jovan.job.service.impl;

import com.jovan.job.entity.Executor;
import com.jovan.job.entity.Task;
import com.jovan.job.mapper.ExecutorMapper;
import com.jovan.job.mapper.TaskMapper;
import com.jovan.job.service.ExecutorService;
import com.jovan.job.service.TaskService;
import com.jovan.job.vo.req.TaskReq;
import com.jovan.job.vo.res.TaskResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yw
 */
@Service
public class ExecutorServiceImpl implements ExecutorService {
    @Resource
    private ExecutorMapper executorMapper;

    @Resource
    private TaskService taskService;

    @Resource
    private TaskMapper taskMapper;

    @Override
    public Boolean createTask(Long executorId, TaskReq taskReq) {
        Task task = new Task();
        BeanUtils.copyProperties(taskReq, task);
        task.setExecutorId(executorId);
        return taskMapper.addTask(task);
    }

    @Override
    public TaskResp getTaskInfo(Long executorId, Long id) {
        Task task = taskMapper.getTaskByExecutorAndId(executorId, id);
        TaskResp resp = new TaskResp();
        BeanUtils.copyProperties(task, resp);
        return resp;
    }

    @Override
    public Boolean updateTask(Long executorId, Long id, TaskReq taskReq) {
        Task task = taskMapper.getTaskByExecutorAndId(executorId, id);
        BeanUtils.copyProperties(taskReq, task);
        Boolean isStart = task.getStatus() == 1;
        if (isStart) {
            taskService.stop(id);
        }
        taskMapper.updateTask(task);
        return isStart? taskService.start(id): true;
    }

    @Override
    public Boolean deleteTask(Long executorId, Long id) {
        Task task = taskMapper.getTaskByExecutorAndId(executorId, id);
        if (task.getStatus() == 1) {
            taskService.stop(id);
        }
        return taskMapper.deleteTask(executorId, id);
    }

    @Override
    public List<TaskResp> getAllTasks(Long executorId) {
        return null;
    }

    @Override
    public Executor getExecutorById(Long id) {
        return executorMapper.getExecutorById(id);
    }
}
