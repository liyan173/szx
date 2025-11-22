package com.szx.ck.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.szx.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * 仓库出租服务申请对象 ck_warehouse_rent_apply
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ck_warehouse_rent_apply")
public class CkWarehouseRentApply extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 申请标题
     */
    private String title;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 可租面积(㎡)
     */
    private Long rentableArea;

    /**
     * 起租面积(㎡)
     */
    private Long minRentArea;

    /**
     * 价格(元/㎡·月)
     */
    private Long price;

    /**
     * 物业单价(元/㎡·月)
     */
    private Long propertyPrice;

    /**
     * 自动下架日期
     */
    private Date autoOffDate;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 信息描述
     */
    private String infoDesc;


}
