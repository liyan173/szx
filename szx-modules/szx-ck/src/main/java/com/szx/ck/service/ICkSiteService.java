package com.szx.ck.service;

import com.szx.ck.domain.vo.CkSiteVo;
import com.szx.ck.domain.bo.CkSiteBo;
import com.szx.common.mybatis.core.page.TableDataInfo;
import com.szx.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 网点信息Service接口
 *
 * @author Lion Li
 * @date 2025-11-22
 */
public interface ICkSiteService {

    /**
     * 查询网点信息
     *
     * @param id 主键
     * @return 网点信息
     */
    CkSiteVo queryById(Long id);

    /**
     * 分页查询网点信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 网点信息分页列表
     */
    TableDataInfo<CkSiteVo> queryPageList(CkSiteBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的网点信息列表
     *
     * @param bo 查询条件
     * @return 网点信息列表
     */
    List<CkSiteVo> queryList(CkSiteBo bo);

    /**
     * 新增网点信息
     *
     * @param bo 网点信息
     * @return 是否新增成功
     */
    Boolean insertByBo(CkSiteBo bo);

    /**
     * 修改网点信息
     *
     * @param bo 网点信息
     * @return 是否修改成功
     */
    Boolean updateByBo(CkSiteBo bo);

    /**
     * 校验并批量删除网点信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
