package com.szx.ck.domain.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.szx.ck.domain.CkCompany;
import com.szx.common.excel.annotation.ExcelDictFormat;
import com.szx.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;


/**
 * 企业信息视图对象 ck_company
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = CkCompany.class)
public class CkCompanyVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 企业名称
     */
    @ExcelProperty(value = "企业名称")
    private String companyName;

    /**
     * 注册地址
     */
    @ExcelProperty(value = "注册地址")
    private String registerAddress;

    /**
     * 企业性质
     */
    @ExcelProperty(value = "企业性质", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "enterprise_nature_type")
    private String companyType;

    /**
     * 企业规模
     */
    @ExcelProperty(value = "企业规模", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "company_scale_type")
    private String companyScale;

    /**
     * 企业简介
     */
    @ExcelProperty(value = "企业简介")
    private String companyIntro;

    /**
     * 车辆信息
     */
    @ExcelProperty(value = "车辆信息")
    private String vehicleInfo;

    /**
     * 统一社会信用代码
     */
    @ExcelProperty(value = "统一社会信用代码")
    private String creditCode;

    /**
     * 详细地址
     */
    @ExcelProperty(value = "详细地址")
    private String address;

    /**
     * 业务类型
     */
    @ExcelProperty(value = "业务类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "business_type")
    private String businessType;

    /**
     * 主要配送品类
     */
    @ExcelProperty(value = "主要配送品类", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "main_category_type")
    private String mainCategory;

    /**
     * 主要配送区域
     */
    @ExcelProperty(value = "主要配送区域", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "delivery_area_type")
    private String deliveryArea;

    /**
     * 配送中心信息
     */
    @ExcelProperty(value = "配送中心信息")
    private String deliveryCenterInfo;

    /**
     * 业务领域
     */
    @ExcelProperty(value = "业务领域")
    private String linesOfBusiness;
    /**
     * 所属园区
     */
    @ExcelProperty(value = "所属园区")
    private String gardenArea;
    /**
     * 法定代表人
     */
    @ExcelProperty(value = "法定代表人")
    private String juridicalPerson;
    /**
     * 会员级别
     */
    @ExcelProperty(value = "会员级别")
    private String member;
    /**
     * 认证状态
     */
    @ExcelProperty(value = "认证状态")
    @ExcelDictFormat(dictType = "authentication_state_type")
    private Integer authenticationState;
    /**
     * 所属区域(省市区三级联动数组)
     */
    private List<String> region;
}
