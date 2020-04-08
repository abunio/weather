package com.moc.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: TODO
 * @author: huangW
 * @createDate: 2020/2/9 22:20
 * @version: 1.0
 */
@Data
public class Yesterday implements Serializable {
    private static final long serialVersionUID = 1L;

    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;

}
