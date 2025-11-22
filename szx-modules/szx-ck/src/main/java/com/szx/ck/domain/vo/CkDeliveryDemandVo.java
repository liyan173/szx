package com.szx.ck.domain.vo;

import com.szx.ck.domain.CkDeliveryDemand;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.szx.common.excel.annotation.ExcelDictFormat;
import com.szx.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 货物配送需求视图对象 ck_delivery_demand
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = CkDeliveryDemand.class)
public class CkDeliveryDemandVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 专人服务(元/人/次)
     */
    @ExcelProperty(value = "专人服务(元/人/次)")
    private Long personalServiceFee;

    /**
     * 送货上楼(元/人/次)
     */
    @ExcelProperty(value = "送货上楼(元/人/次)")
    private Long upstairsFee;

    /**
     * 贴标(是/否)
     */
    @ExcelProperty(value = "贴标(是/否)")
    private String labeling;

    /**
     * 卸货(是/否)
     */
    @ExcelProperty(value = "卸货(是/否)")
    private String unloading;

    /**
     * 拆箱/换拖(是/否)
     */
    @ExcelProperty(value = "拆箱/换拖(是/否)")
    private String unpacking;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
