package com.sundy.common.net.exception;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-18 12:03
 * 描述：
 */
public class CustException extends Exception {
    public String code;
    public String message;

    public CustException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "CustException{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
