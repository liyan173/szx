package com.szx.ck.service;

import com.szx.ck.domain.vo.CkDeliveryDemandVo;
import com.szx.ck.domain.bo.CkDeliveryDemandBo;
import com.szx.common.mybatis.core.page.TableDataInfo;
import com.szx.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 货物配送需求Service接口
 *
 * @author Lion Li
 * @date 2025-11-22
 */
public interface ICkDeliveryDemandService {

    /**
     * 查询货物配送需求
     *
     * @param id 主键
     * @return 货物配送需求
     */
    CkDeliveryDemandVo queryById(Long id);

    /**
     * 分页查询货物配送需求列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 货物配送需求分页列表
     */
    TableDataInfo<CkDeliveryDemandVo> queryPageList(CkDeliveryDemandBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的货物配送需求列表
     *
     * @param bo 查询条件
     * @return 货物配送需求列表
     */
    List<CkDeliveryDemandVo> queryList(CkDeliveryDemandBo bo);

    /**
     * 新增货物配送需求
     *
     * @param bo 货物配送需求
     * @return 是否新增成功
     */
    Boolean insertByBo(CkDeliveryDemandBo bo);

    /**
     * 修改货物配送需求
     *
     * @param bo 货物配送需求
     * @return 是否修改成功
     */
    Boolean updateByBo(CkDeliveryDemandBo bo);

    /**
     * 校验并批量删除货物配送需求信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
