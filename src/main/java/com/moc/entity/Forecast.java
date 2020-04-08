package com.moc.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: TODO
 * @author: huangW
 * @createDate: 2020/2/9 22:17
 * @version: 1.0
 */
@Data
public class Forecast implements Serializable {
    private static final long serialVersionUID = 1L;

    private String date;
    private String high;
    private String low;
    private String fengli;
    private String fengxiang;
    private String type;

}
