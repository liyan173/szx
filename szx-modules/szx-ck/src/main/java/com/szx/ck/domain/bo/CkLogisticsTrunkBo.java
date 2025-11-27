package com.szx.ck.domain.bo;

import com.szx.ck.domain.CkLogisticsTrunk;
import com.szx.common.core.validate.AddGroup;
import com.szx.common.core.validate.EditGroup;
import com.szx.common.mybatis.core.domain.BaseEntity;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 物流干线配送服务业务对象 ck_logistics_trunk
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = CkLogisticsTrunk.class, reverseConvertGenerate = false)
public class CkLogisticsTrunkBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 始发地
     */
    @NotBlank(message = "始发地不能为空", groups = { AddGroup.class, EditGroup.class })
    private String origin;

    /**
     * 目的地
     */
    @NotBlank(message = "目的地不能为空", groups = { AddGroup.class, EditGroup.class })
    private String destination;

    /**
     * 最低收费(元)
     */
    private Long minFee;

    /**
     * 单价(元/KG)
     */
    @NotNull(message = "单价(元/KG)不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long pricePerKg;

    /**
     * 备注信息
     */
    private String remark;
    /**
     * 企业id
     */
    private Long companyId;

}
