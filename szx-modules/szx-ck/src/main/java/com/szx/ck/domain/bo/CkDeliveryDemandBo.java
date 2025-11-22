package com.szx.ck.domain.bo;

import com.szx.ck.domain.CkDeliveryDemand;
import com.szx.common.core.validate.AddGroup;
import com.szx.common.core.validate.EditGroup;
import com.szx.common.mybatis.core.domain.BaseEntity;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 货物配送需求业务对象 ck_delivery_demand
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = CkDeliveryDemand.class, reverseConvertGenerate = false)
public class CkDeliveryDemandBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 专人服务(元/人/次)
     */
    private Long personalServiceFee;

    /**
     * 送货上楼(元/人/次)
     */
    @NotNull(message = "送货上楼(元/人/次)不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long upstairsFee;

    /**
     * 贴标(是/否)
     */
    @NotBlank(message = "贴标(是/否)不能为空", groups = { AddGroup.class, EditGroup.class })
    private String labeling;

    /**
     * 卸货(是/否)
     */
    @NotBlank(message = "卸货(是/否)不能为空", groups = { AddGroup.class, EditGroup.class })
    private String unloading;

    /**
     * 拆箱/换拖(是/否)
     */
    @NotBlank(message = "拆箱/换拖(是/否)不能为空", groups = { AddGroup.class, EditGroup.class })
    private String unpacking;

    /**
     * 备注
     */
    private String remark;


}
