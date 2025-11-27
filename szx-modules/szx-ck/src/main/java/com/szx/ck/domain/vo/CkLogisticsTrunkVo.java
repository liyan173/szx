package com.szx.ck.domain.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.szx.ck.domain.CkLogisticsTrunk;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;



/**
 * 物流干线配送服务视图对象 ck_logistics_trunk
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = CkLogisticsTrunk.class)
public class CkLogisticsTrunkVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 始发地
     */
    @ExcelProperty(value = "始发地")
    private String origin;

    /**
     * 目的地
     */
    @ExcelProperty(value = "目的地")
    private String destination;

    /**
     * 最低收费(元)
     */
    @ExcelProperty(value = "最低收费(元)")
    private Long minFee;

    /**
     * 单价(元/KG)
     */
    @ExcelProperty(value = "单价(元/KG)")
    private Long pricePerKg;

    /**
     * 备注信息
     */
    @ExcelProperty(value = "备注信息")
    private String remark;
    /**
     * 企业id
     */
    private Long companyId;

}
