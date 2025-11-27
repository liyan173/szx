package com.szx.ck.domain.bo;

import com.szx.ck.domain.CkWarehouseRentApply;
import com.szx.common.core.validate.AddGroup;
import com.szx.common.core.validate.EditGroup;
import com.szx.common.mybatis.core.domain.BaseEntity;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 仓库出租服务申请业务对象 ck_warehouse_rent_apply
 *
 * @author Lion Li
 * @date 2025-11-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = CkWarehouseRentApply.class, reverseConvertGenerate = false)
public class CkWarehouseRentApplyBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 申请标题
     */
    @NotBlank(message = "申请标题不能为空", groups = { AddGroup.class, EditGroup.class })
    private String title;

    /**
     * 企业名称
     */
    @NotBlank(message = "企业名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String companyName;

    /**
     * 可租面积(㎡)
     */
    @NotNull(message = "可租面积(㎡)不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long rentableArea;

    /**
     * 起租面积(㎡)
     */
    @NotNull(message = "起租面积(㎡)不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long minRentArea;

    /**
     * 价格(元/㎡·月)
     */
    @NotNull(message = "价格(元/㎡·月)不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long price;

    /**
     * 物业单价(元/㎡·月)
     */
    @NotNull(message = "物业单价(元/㎡·月)不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long propertyPrice;

    /**
     * 自动下架日期
     */
    @NotNull(message = "自动下架日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date autoOffDate;

    /**
     * 联系人
     */
    @NotBlank(message = "联系人不能为空", groups = { AddGroup.class, EditGroup.class })
    private String contactPerson;

    /**
     * 联系电话
     */
    @NotBlank(message = "联系电话不能为空", groups = { AddGroup.class, EditGroup.class })
    private String contactPhone;

    /**
     * 信息描述
     */
    @NotBlank(message = "信息描述不能为空", groups = { AddGroup.class, EditGroup.class })
    private String infoDesc;

    /**
     * 备注
     */
    private String remark;

    /**
     * 企业id
     */
    private Long companyId;

    /**
     * 认证状态
     0 通过
     1 不通过
     3 审核中
     4 待提交
     */
    private String authenticationState;


}
