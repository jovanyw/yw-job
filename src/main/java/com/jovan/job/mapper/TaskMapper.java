package com.jovan.job.mapper;

import com.jovan.job.entity.Task;
import com.jovan.job.vo.res.TaskResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yw
 */
@Mapper
public interface TaskMapper {
    Task getTaskById(@Param("id") Long id);

    Boolean updateTask(Task task);

    Boolean addTask(Task task);

    Task getTaskByExecutorAndId(Long executorId, Long id);

    Boolean deleteTask(Long executorId, Long id);
}
