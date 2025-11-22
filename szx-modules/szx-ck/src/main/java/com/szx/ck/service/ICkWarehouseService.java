package com.szx.ck.service;

import com.szx.ck.domain.vo.CkWarehouseVo;
import com.szx.ck.domain.bo.CkWarehouseBo;
import com.szx.common.mybatis.core.page.TableDataInfo;
import com.szx.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 仓库基础数据录入Service接口
 *
 * @author Lion Li
 * @date 2025-11-22
 */
public interface ICkWarehouseService {

    /**
     * 查询仓库基础数据录入
     *
     * @param id 主键
     * @return 仓库基础数据录入
     */
    CkWarehouseVo queryById(Long id);

    /**
     * 分页查询仓库基础数据录入列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 仓库基础数据录入分页列表
     */
    TableDataInfo<CkWarehouseVo> queryPageList(CkWarehouseBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的仓库基础数据录入列表
     *
     * @param bo 查询条件
     * @return 仓库基础数据录入列表
     */
    List<CkWarehouseVo> queryList(CkWarehouseBo bo);

    /**
     * 新增仓库基础数据录入
     *
     * @param bo 仓库基础数据录入
     * @return 是否新增成功
     */
    Boolean insertByBo(CkWarehouseBo bo);

    /**
     * 修改仓库基础数据录入
     *
     * @param bo 仓库基础数据录入
     * @return 是否修改成功
     */
    Boolean updateByBo(CkWarehouseBo bo);

    /**
     * 校验并批量删除仓库基础数据录入信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
