package com.szx.ck.domain.bo;

import com.szx.ck.domain.CkCompany;
import com.szx.common.mybatis.core.domain.BaseEntity;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 企业信息业务对象 ck_company
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = CkCompany.class, reverseConvertGenerate = false)
public class CkCompanyBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 企业名称
     */
    @NotBlank(message = "企业名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String companyName;

    /**
     * 注册地址
     */
    @NotBlank(message = "注册地址不能为空", groups = { AddGroup.class, EditGroup.class })
    private String registerAddress;

    /**
     * 企业性质
     */
    @NotBlank(message = "企业性质不能为空", groups = { AddGroup.class, EditGroup.class })
    private String companyType;

    /**
     * 企业规模
     */
    @NotBlank(message = "企业规模不能为空", groups = { AddGroup.class, EditGroup.class })
    private String companyScale;

    /**
     * 企业简介
     */
    @NotBlank(message = "企业简介不能为空", groups = { AddGroup.class, EditGroup.class })
    private String companyIntro;

    /**
     * 车辆信息
     */
    @NotBlank(message = "车辆信息不能为空", groups = { AddGroup.class, EditGroup.class })
    private String vehicleInfo;

    /**
     * 统一社会信用代码
     */
    private String creditCode;

    /**
     * 详细地址
     */
    @NotBlank(message = "详细地址不能为空", groups = { AddGroup.class, EditGroup.class })
    private String address;

    /**
     * 业务类型
     */
    @NotBlank(message = "业务类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private String businessType;

    /**
     * 主要配送品类
     */
    @NotBlank(message = "主要配送品类不能为空", groups = { AddGroup.class, EditGroup.class })
    private String mainCategory;

    /**
     * 主要配送区域
     */
    private String deliveryArea;

    /**
     * 配送中心信息
     */
    @NotBlank(message = "配送中心信息不能为空", groups = { AddGroup.class, EditGroup.class })
    private String deliveryCenterInfo;


}
