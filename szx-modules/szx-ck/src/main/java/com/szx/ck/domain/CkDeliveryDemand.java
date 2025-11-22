package com.szx.ck.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.szx.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 货物配送需求对象 ck_delivery_demand
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ck_delivery_demand")
public class CkDeliveryDemand extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 专人服务(元/人/次)
     */
    private Long personalServiceFee;

    /**
     * 送货上楼(元/人/次)
     */
    private Long upstairsFee;

    /**
     * 贴标(是/否)
     */
    private String labeling;

    /**
     * 卸货(是/否)
     */
    private String unloading;

    /**
     * 拆箱/换拖(是/否)
     */
    private String unpacking;

    /**
     * 备注
     */
    private String remark;


}
