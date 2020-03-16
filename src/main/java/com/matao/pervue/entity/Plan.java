package com.matao.pervue.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author matao
 * @since 2020-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("plan")
public class Plan implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private BigDecimal amount;

    private String manger;

    private String content;
    @TableField("deptId")
    private Integer deptId;

    @TableField(exist = false)
    private String dnames;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setManger(String manger) {
        this.manger = manger;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getManger() {
        return manger;
    }

    public String getContent() {
        return content;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDnames(String dnames) {
        this.dnames = dnames;
    }

    public String getDnames() {
        return dnames;
    }
}
