package com.springboot.bootcrudpage.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/6/3
 */
@Setter
@Getter
public class PageBean implements Serializable {
    private long pageTotal;
    /**当前记录数*/
    private List rows;

    public PageBean(long pageTotal, List rows) {
        this.pageTotal = pageTotal;
        this.rows = rows;
    }
}
