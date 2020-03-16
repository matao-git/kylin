package com.matao.pervue.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsVo extends  Goods{
    //省
    private String provinceName;
    //市里
    private String cityName;
    //区
    private  String districtName;

    //扩展角色表的数据
    private String tids;
    private String tnames;
    private String tinfos;

    //最小价格
    private BigDecimal priceSmall;

    private BigDecimal priceBig;
}
