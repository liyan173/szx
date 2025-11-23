package com.szx.ck.domain.bo;

import com.szx.ck.domain.CkWarehouse;
import com.szx.common.core.validate.AddGroup;
import com.szx.common.core.validate.EditGroup;
import com.szx.common.mybatis.core.domain.BaseEntity;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 仓库基础数据录入业务对象 ck_warehouse
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = CkWarehouse.class, reverseConvertGenerate = false)
public class CkWarehouseBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 仓库名称
     */
    @NotBlank(message = "仓库名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String warehouseName;

    /**
     * 占地(亩)
     */
    @NotNull(message = "占地(亩)不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal areaMu;

    /**
     * 土地属性
     */
    @NotBlank(message = "土地属性不能为空", groups = { AddGroup.class, EditGroup.class })
    private String landProperty;

    /**
     * 使用年限
     */
    @NotNull(message = "使用年限不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer useYears;

    /**
     * 楼栋数量
     */
    @NotNull(message = "楼栋数量不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer buildingCount;

    /**
     * 容积率
     */
    @NotNull(message = "容积率不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal volumeRatio;

    /**
     * 层高
     */
    @NotNull(message = "层高不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 所属区域
     */
    @NotBlank(message = "所属区域不能为空", groups = { AddGroup.class, EditGroup.class })
    private String region;

    /**
     * 详细地址
     */
    @NotBlank(message = "详细地址不能为空", groups = { AddGroup.class, EditGroup.class })
    private String address;

    /**
     * 主要品类
     */
    @NotBlank(message = "主要品类不能为空", groups = { AddGroup.class, EditGroup.class })
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
    @NotBlank(message = "消防等级证书不能为空", groups = { AddGroup.class, EditGroup.class })
    private String fireLevel;

    /**
     * 消防证书有效日期
     */
    @NotNull(message = "消防证书有效日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date fireExpireDate;

    /**
     * 各类仓库面积
     */
    private String warehouseAreaInfo;

    /**
     * 认证状态
     */
    private Integer authenticationState;

}
