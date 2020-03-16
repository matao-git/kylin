package com.matao.pervue.entity;

import lombok.Data;

@Data
public class UserVo extends User{
    //省
    private String provinceName;
    //市里
    private String cityName;
    //区
    private  String districtName;

    //扩展角色表的数据
    private String rids;
    private String rnames;
    private String rnameZhs;
}
