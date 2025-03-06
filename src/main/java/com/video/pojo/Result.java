package com.video.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/3/6
 * 时间：20:19
 */
@Data
@AllArgsConstructor
public class Result {
    private Integer code;
    private String message;
    private Object data;

    public static Result success() {
        return new Result(1, "success", null);
    }
    public static Result success(Object data) {
        return new Result(1, "success", data);
    }
}
