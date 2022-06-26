package com.jovan.job.vo.res;

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
public class TaskResp {
    private Long id;

    private Long executorId;

    private String cron;

    private String desc;

    private Integer status;

    private String jobHandler;
}
