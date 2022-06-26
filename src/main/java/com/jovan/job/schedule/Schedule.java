package com.jovan.job.schedule;

import com.jovan.job.common.utils.CronParser;
import com.jovan.job.entity.Task;
import com.jovan.job.service.SchedulerService;
import com.jovan.job.service.TaskService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author yw
 */
@Component
public class Schedule implements Runnable{
    private List<Task> taskQueue;

    @Resource
    private TaskService taskService;

    Schedule() {
        taskQueue = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskQueue.add(task);
    }

    public void removeTask(Task task) {
        taskQueue.remove(task);
    }

    @Override
    public void run() {
        while (true) {
            Date now = new Date();
            for (Task task : taskQueue) {
                if (CronParser.getNextDate(task.getCron()).getTime() <= now.getTime()
                        && now.getTime() <= (CronParser.getNextDate(task.getCron()).getTime() + 5000L)) {
                    taskService.run(task.getId());
                }
            }
        }
    }
}
