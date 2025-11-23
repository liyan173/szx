package com.szx.ck.domain.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.szx.ck.domain.CkWarehouse;
import com.szx.common.excel.annotation.ExcelDictFormat;
import com.szx.common.excel.convert.ExcelDictConvert;
import com.szx.common.translation.annotation.Translation;
import com.szx.common.translation.constant.TransConstant;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 仓库基础数据录入视图对象 ck_warehouse
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = CkWarehouse.class)
public class CkWarehouseVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 仓库名称
     */
    @ExcelProperty(value = "仓库名称")
    private String warehouseName;

    /**
     * 占地(亩)
     */
    @ExcelProperty(value = "占地(亩)")
    private BigDecimal areaMu;

    /**
     * 土地属性
     */
    @ExcelProperty(value = "土地属性", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "landt_ypes")
    private String landProperty;

    /**
     * 使用年限
     */
    @ExcelProperty(value = "使用年限", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "age_limit_type")
    private Integer useYears;

    /**
     * 楼栋数量
     */
    @ExcelProperty(value = "楼栋数量")
    private Integer buildingCount;

    /**
     * 容积率
     */
    @ExcelProperty(value = "容积率")
    private BigDecimal volumeRatio;

    /**
     * 层高
     */
    @ExcelProperty(value = "层高")
    private BigDecimal floorHeight;

    /**
     * 仓库总面积（㎡）
     */
    @ExcelProperty(value = "仓库总面积", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "㎡=")
    private BigDecimal totalArea;

    /**
     * 仓库管理方式
     */
    @ExcelProperty(value = "仓库管理方式", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "warehouse_method_type")
    private String manageType;

    /**
     * 所属区域
     */
    @ExcelProperty(value = "所属区域", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "area_type")
    private String region;

    /**
     * 详细地址
     */
    @ExcelProperty(value = "详细地址")
    private String address;

    /**
     * 主要品类
     */
    @ExcelProperty(value = "主要品类", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "category_type")
    private String mainCategory;

    /**
     * 仓库内配套
     */
    @ExcelProperty(value = "仓库内配套", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "integrated_facilities_type")
    private String innerFacilities;

    /**
     * 仓库外配套
     */
    @ExcelProperty(value = "仓库外配套", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "outer_facilities_type")
    private String outerFacilities;

    /**
     * 园区安保
     */
    @ExcelProperty(value = "园区安保", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "security_info_type")
    private String securityInfo;

    /**
     * 仓库优势
     */
    @ExcelProperty(value = "仓库优势", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "advantage_type")
    private String advantage;

    /**
     * 仓库功能
     */
    @ExcelProperty(value = "仓库功能", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "function_info_type")
    private String functionInfo;

    /**
     * 仓库实景展示
     */
    @ExcelProperty(value = "仓库实景展示")
    private String gallery;

    /**
     * 仓库实景展示Url
     */
    @Translation(type = TransConstant.OSS_ID_TO_URL, mapper = "gallery")
    private String galleryUrl;
    /**
     * 消防等级证书
     */
    @ExcelProperty(value = "消防等级证书")
    private String fireLevel;

    /**
     * 消防等级证书Url
     */
    @Translation(type = TransConstant.OSS_ID_TO_URL, mapper = "fireLevel")
    private String fireLevelUrl;
    /**
     * 消防证书有效日期
     */
    @ExcelProperty(value = "消防证书有效日期")
    private Date fireExpireDate;

    /**
     * 各类仓库面积
     */
    @ExcelProperty(value = "各类仓库面积")
    private String warehouseAreaInfo;

    /**
     * 认证状态
     */
    @ExcelProperty(value = "认证状态")
    @ExcelDictFormat(dictType = "authentication_state_type")
    private Integer authenticationState;
}
