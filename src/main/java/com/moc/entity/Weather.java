package com.moc.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description: TODO
 * @author: huangW
 * @createDate: 2020/2/9 22:18
 * @version: 1.0
 */
@Data
public class Weather implements Serializable {
    private static final long serialVersionUID = 1L;

    private String city;
    private String wendu;
    private String ganmao;
    private String citys;
    private String prompt;

}
