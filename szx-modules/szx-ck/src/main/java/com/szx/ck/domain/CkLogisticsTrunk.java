package com.szx.ck.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.szx.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 物流干线配送服务对象 ck_logistics_trunk
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ck_logistics_trunk")
public class CkLogisticsTrunk extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 始发地
     */
    private String origin;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 最低收费(元)
     */
    private Long minFee;

    /**
     * 单价(元/KG)
     */
    private Long pricePerKg;

    /**
     * 备注信息
     */
    private String remark;


}
