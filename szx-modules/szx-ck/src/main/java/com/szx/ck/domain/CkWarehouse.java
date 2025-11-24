package com.szx.ck.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.szx.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 仓库基础数据录入对象 ck_warehouse
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value ="ck_warehouse" ,autoResultMap = true)
public class CkWarehouse extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 仓库名称
     */
    private String warehouseName;

    /**
     * 占地(亩)
     */
    private BigDecimal areaMu;

    /**
     * 土地属性
     */
    private String landProperty;

    /**
     * 使用年限
     */
    private Integer useYears;

    /**
     * 楼栋数量
     */
    private Integer buildingCount;

    /**
     * 容积率
     */
    private BigDecimal volumeRatio;

    /**
     * 层高
     */
    private BigDecimal floorHeight;

    /**
     * 仓库总面积（㎡）
     */
    private BigDecimal totalArea;

    /**
     * 仓库管理方式
     */
    private String manageType;

    /**
     * 所属区域(省市区三级联动数组)
     */
    @com.baomidou.mybatisplus.annotation.TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> region;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 主要品类
     */
    private String mainCategory;

    /**
     * 仓库内配套
     */
    private String innerFacilities;

    /**
     * 仓库外配套
     */
    private String outerFacilities;

    /**
     * 园区安保
     */
    private String securityInfo;

    /**
     * 仓库优势
     */
    private String advantage;

    /**
     * 仓库功能
     */
    private String functionInfo;

    /**
     * 仓库实景展示
     */
    private String gallery;

    /**
     * 消防等级证书
     */
    private String fireLevel;

    /**
     * 消防证书有效日期
     */
    private Date fireExpireDate;

    /**
     * 各类仓库面积
     */
    private String warehouseAreaInfo;
    /**
     * 认证状态
     */
    private Integer authenticationState;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 企业id
     */
    private Long companyId;

}
