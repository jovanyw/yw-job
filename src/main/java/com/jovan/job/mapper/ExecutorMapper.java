package com.jovan.job.mapper;

import com.jovan.job.entity.Executor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExecutorMapper {
    Executor getExecutorById(Long id);
}
