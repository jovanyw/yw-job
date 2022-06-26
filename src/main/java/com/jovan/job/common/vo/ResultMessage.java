package com.jovan.job.common.vo;

import lombok.Data;

/**
 * @author yw
 */
@Data
public class ResultMessage<E> {
    private int code;
    private String msg;
    private E data;

    public ResultMessage() {
        this.code = 200;
        this.msg = "成功";
    }

    private ResultMessage(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ResultMessage(int code, String msg, E data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <E> ResultMessage<E> success() {
        return new ResultMessage<>();
    }

    public static <E> ResultMessage<E> success(String msg) {
        return new ResultMessage<>(200, msg);
    }

    public static <E> ResultMessage<E> success(E data) {
        return new ResultMessage<>(200, "成功", data);
    }

    public static <E> ResultMessage<E> failure() {
        return new ResultMessage<>(500, "服务不可用");
    }

    public static <E> ResultMessage<E> failure(int code, String msg) {
        return new ResultMessage<>(code, msg);
    }
}
