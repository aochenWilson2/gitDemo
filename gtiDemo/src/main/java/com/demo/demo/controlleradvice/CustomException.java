package com.demo.demo.controlleradvice;

/**
 * 自定义异常
 * Spring 对于 RuntimeException类的异常才会进行事务回滚，所以我们一般自定义异常都继承该异常类。
 *
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2019/9/30 16:45
 */
public class CustomException extends RuntimeException {
    private long code;
    private String msg;

    public CustomException(Long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
