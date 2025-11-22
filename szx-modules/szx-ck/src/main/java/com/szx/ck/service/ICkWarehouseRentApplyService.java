package com.szx.ck.service;

import com.szx.ck.domain.vo.CkWarehouseRentApplyVo;
import com.szx.ck.domain.bo.CkWarehouseRentApplyBo;
import com.szx.common.mybatis.core.page.TableDataInfo;
import com.szx.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 仓库出租服务申请Service接口
 *
 * @author Lion Li
 * @date 2025-11-22
 */
public interface ICkWarehouseRentApplyService {

    /**
     * 查询仓库出租服务申请
     *
     * @param id 主键
     * @return 仓库出租服务申请
     */
    CkWarehouseRentApplyVo queryById(Long id);

    /**
     * 分页查询仓库出租服务申请列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 仓库出租服务申请分页列表
     */
    TableDataInfo<CkWarehouseRentApplyVo> queryPageList(CkWarehouseRentApplyBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的仓库出租服务申请列表
     *
     * @param bo 查询条件
     * @return 仓库出租服务申请列表
     */
    List<CkWarehouseRentApplyVo> queryList(CkWarehouseRentApplyBo bo);

    /**
     * 新增仓库出租服务申请
     *
     * @param bo 仓库出租服务申请
     * @return 是否新增成功
     */
    Boolean insertByBo(CkWarehouseRentApplyBo bo);

    /**
     * 修改仓库出租服务申请
     *
     * @param bo 仓库出租服务申请
     * @return 是否修改成功
     */
    Boolean updateByBo(CkWarehouseRentApplyBo bo);

    /**
     * 校验并批量删除仓库出租服务申请信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
