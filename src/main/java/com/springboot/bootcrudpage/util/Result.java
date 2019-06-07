package com.springboot.bootcrudpage.util;

import com.springboot.bootcrudpage.enums.UserEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : 石建雷
 * @date :2019/6/4
 */
@Setter
@Getter
public class Result {
    private int code;
    private String msg;


    public Result(UserEnum userEnum) {
        this.code = userEnum.getCode();
        this.msg = userEnum.getMsg();
    }


    public static  Result success(UserEnum userEnum) {
        return new Result(userEnum);
    }

    public static Result error(UserEnum userEnum) {
        return new Result(userEnum);
    }
}
