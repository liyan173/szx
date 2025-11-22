package com.szx.ck.service;

import com.szx.ck.domain.vo.CkLogisticsTrunkVo;
import com.szx.ck.domain.bo.CkLogisticsTrunkBo;
import com.szx.common.mybatis.core.page.TableDataInfo;
import com.szx.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 物流干线配送服务Service接口
 *
 * @author Lion Li
 * @date 2025-11-22
 */
public interface ICkLogisticsTrunkService {

    /**
     * 查询物流干线配送服务
     *
     * @param id 主键
     * @return 物流干线配送服务
     */
    CkLogisticsTrunkVo queryById(Long id);

    /**
     * 分页查询物流干线配送服务列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 物流干线配送服务分页列表
     */
    TableDataInfo<CkLogisticsTrunkVo> queryPageList(CkLogisticsTrunkBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的物流干线配送服务列表
     *
     * @param bo 查询条件
     * @return 物流干线配送服务列表
     */
    List<CkLogisticsTrunkVo> queryList(CkLogisticsTrunkBo bo);

    /**
     * 新增物流干线配送服务
     *
     * @param bo 物流干线配送服务
     * @return 是否新增成功
     */
    Boolean insertByBo(CkLogisticsTrunkBo bo);

    /**
     * 修改物流干线配送服务
     *
     * @param bo 物流干线配送服务
     * @return 是否修改成功
     */
    Boolean updateByBo(CkLogisticsTrunkBo bo);

    /**
     * 校验并批量删除物流干线配送服务信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
