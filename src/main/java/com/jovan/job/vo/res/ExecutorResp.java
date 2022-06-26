package com.jovan.job.vo.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExecutorResp {
    private Long id;

    private String appName;

    private String executorName;

    private String addressList;
}
