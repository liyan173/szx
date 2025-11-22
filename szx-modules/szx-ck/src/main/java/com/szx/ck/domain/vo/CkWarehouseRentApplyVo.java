package com.szx.ck.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.szx.ck.domain.CkWarehouseRentApply;
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
 * 仓库出租服务申请视图对象 ck_warehouse_rent_apply
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = CkWarehouseRentApply.class)
public class CkWarehouseRentApplyVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 申请标题
     */
    @ExcelProperty(value = "申请标题")
    private String title;

    /**
     * 企业名称
     */
    @ExcelProperty(value = "企业名称")
    private String companyName;

    /**
     * 可租面积(㎡)
     */
    @ExcelProperty(value = "可租面积(㎡)")
    private Long rentableArea;

    /**
     * 起租面积(㎡)
     */
    @ExcelProperty(value = "起租面积(㎡)")
    private Long minRentArea;

    /**
     * 价格(元/㎡·月)
     */
    @ExcelProperty(value = "价格(元/㎡·月)")
    private Long price;

    /**
     * 物业单价(元/㎡·月)
     */
    @ExcelProperty(value = "物业单价(元/㎡·月)")
    private Long propertyPrice;

    /**
     * 自动下架日期
     */
    @ExcelProperty(value = "自动下架日期")
    private Date autoOffDate;

    /**
     * 联系人
     */
    @ExcelProperty(value = "联系人")
    private String contactPerson;

    /**
     * 联系电话
     */
    @ExcelProperty(value = "联系电话")
    private String contactPhone;

    /**
     * 信息描述
     */
    @ExcelProperty(value = "信息描述")
    private String infoDesc;


}
