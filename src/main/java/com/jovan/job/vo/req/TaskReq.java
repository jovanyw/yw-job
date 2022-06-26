package com.jovan.job.vo.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yw
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskReq {
    private Long id;

    private Long executorId;

    private String cron;

    private String desc;

    private Integer status;

    private String jobHandler;
}
