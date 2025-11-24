package com.szx.ck.domain.bo;

import com.szx.ck.domain.CkSite;
import com.szx.common.core.validate.AddGroup;
import com.szx.common.core.validate.EditGroup;
import com.szx.common.mybatis.core.domain.BaseEntity;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 网点信息业务对象 ck_site
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = CkSite.class, reverseConvertGenerate = false)
public class CkSiteBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 网点类型
     */
    @NotBlank(message = "网点类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private String siteType;

    /**
     * 用户类型
     */
    @NotBlank(message = "用户类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private String userType;

    /**
     * 所属区域(省市区三级联动数组)
     */
    private List<String> region;

    /**
     * 详细地址
     */
    @NotBlank(message = "详细地址不能为空", groups = { AddGroup.class, EditGroup.class })
    private String address;

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
     * 企业id
     */
    private Long companyId;

}
