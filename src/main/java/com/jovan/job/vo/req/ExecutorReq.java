package com.jovan.job.vo.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExecutorReq {
    private Long id;

    private String appName;

    private String executorName;

    private String addressList;
}
