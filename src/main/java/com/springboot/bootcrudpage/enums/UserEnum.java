package com.springboot.bootcrudpage.enums;

import lombok.Getter;

/**
 * @author : 石建雷
 * @date :2019/6/4
 */
@Getter
public enum UserEnum {
    /**
     * 枚举
     */
    SUCCESS(0, "用户添加成功"),
    UPDATE_USER_SUCCESS(1, "用户更新成功"),
    UPDATE_USER_FAIL(2, "用户更新失败"),
    DELETE_SUCCESS(3, "删除用户成功"),
    DELETE_FAIL(4, "删除用户失败"),
    SEARCH_SUCCESS(5, "查询成功"),
    USER_LOGIN_FAIL(6, "登录失败"),
    USER_LOGIN_SUCCESS(7, "登录成功"),
    SERVER_ERROR(500, "服务端异常"),
    ADD_USER_ERROR(501, "用户添加失败"),
    USER_MSG_NULL(502, "用户信息不能为空"),


    ;

    private int code;
    private String msg;

    UserEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static UserEnum stateOf(int value) {
        for (UserEnum stateEnum :
                values()) {

            if (stateEnum.getCode() == value) {
                return stateEnum;
            }

        }
        return null;
    }
}
