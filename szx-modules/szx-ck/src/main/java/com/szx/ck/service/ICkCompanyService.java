package com.szx.ck.service;

import com.szx.ck.domain.vo.CkCompanyVo;
import com.szx.ck.domain.bo.CkCompanyBo;
import com.szx.common.mybatis.core.page.TableDataInfo;
import com.szx.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 企业信息Service接口
 *
 * @author Lion Li
 * @date 2025-11-22
 */
public interface ICkCompanyService {

    /**
     * 查询企业信息
     *
     * @param id 主键
     * @return 企业信息
     */
    CkCompanyVo queryById(Long id);

    /**
     * 分页查询企业信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 企业信息分页列表
     */
    TableDataInfo<CkCompanyVo> queryPageList(CkCompanyBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的企业信息列表
     *
     * @param bo 查询条件
     * @return 企业信息列表
     */
    List<CkCompanyVo> queryList(CkCompanyBo bo);

    /**
     * 新增企业信息
     *
     * @param bo 企业信息
     * @return 是否新增成功
     */
    Boolean insertByBo(CkCompanyBo bo);

    /**
     * 修改企业信息
     *
     * @param bo 企业信息
     * @return 是否修改成功
     */
    Boolean updateByBo(CkCompanyBo bo);

    /**
     * 校验并批量删除企业信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
