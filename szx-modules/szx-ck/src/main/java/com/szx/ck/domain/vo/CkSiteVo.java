package com.szx.ck.domain.vo;

import com.szx.ck.domain.CkSite;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.szx.common.excel.annotation.ExcelDictFormat;
import com.szx.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * 网点信息视图对象 ck_site
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = CkSite.class)
public class CkSiteVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 网点类型
     */
    @ExcelProperty(value = "网点类型")
    private String siteType;

    /**
     * 用户类型
     */
    @ExcelProperty(value = "用户类型")
    private String userType;

    /**
     * 所属区域(省市区三级联动数组)
     */
    @ExcelProperty(value = "所属区域")
    private List<String> region;

    /**
     * 详细地址
     */
    @ExcelProperty(value = "详细地址")
    private String address;

    /**
     * 联系人
     */
    @ExcelProperty(value = "联系人", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "linkman_type")
    private String contactPerson;

    /**
     * 联系电话
     */
    @ExcelProperty(value = "联系电话")
    private String contactPhone;


}
