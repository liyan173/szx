package com.szx.ck.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.szx.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 企业信息对象 ck_company
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ck_company")
public class CkCompany extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 注册地址
     */
    private String registerAddress;

    /**
     * 企业性质
     */
    private String companyType;

    /**
     * 企业规模
     */
    private String companyScale;

    /**
     * 企业简介
     */
    private String companyIntro;

    /**
     * 车辆信息
     */
    private String vehicleInfo;

    /**
     * 统一社会信用代码
     */
    private String creditCode;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * 主要配送品类
     */
    private String mainCategory;

    /**
     * 主要配送区域
     */
    private String deliveryArea;

    /**
     * 配送中心信息
     */
    private String deliveryCenterInfo;


}
