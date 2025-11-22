package com.szx.ck.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szx.ck.domain.CkSite;
import com.szx.ck.domain.bo.CkSiteBo;
import com.szx.ck.domain.vo.CkSiteVo;
import com.szx.ck.mapper.CkSiteMapper;
import com.szx.ck.service.ICkSiteService;
import com.szx.common.core.utils.MapstructUtils;
import com.szx.common.core.utils.StringUtils;
import com.szx.common.mybatis.core.page.PageQuery;
import com.szx.common.mybatis.core.page.TableDataInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 网点信息Service业务层处理
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CkSiteServiceImpl implements ICkSiteService {

    private final CkSiteMapper baseMapper;

    /**
     * 查询网点信息
     *
     * @param id 主键
     * @return 网点信息
     */
    @Override
    public CkSiteVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询网点信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 网点信息分页列表
     */
    @Override
    public TableDataInfo<CkSiteVo> queryPageList(CkSiteBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<CkSite> lqw = buildQueryWrapper(bo);
        Page<CkSiteVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的网点信息列表
     *
     * @param bo 查询条件
     * @return 网点信息列表
     */
    @Override
    public List<CkSiteVo> queryList(CkSiteBo bo) {
        LambdaQueryWrapper<CkSite> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<CkSite> buildQueryWrapper(CkSiteBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<CkSite> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(CkSite::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getSiteType()), CkSite::getSiteType, bo.getSiteType());
        lqw.eq(StringUtils.isNotBlank(bo.getUserType()), CkSite::getUserType, bo.getUserType());
        lqw.eq(StringUtils.isNotBlank(bo.getRegion()), CkSite::getRegion, bo.getRegion());
        lqw.eq(StringUtils.isNotBlank(bo.getAddress()), CkSite::getAddress, bo.getAddress());
        lqw.eq(StringUtils.isNotBlank(bo.getContactPerson()), CkSite::getContactPerson, bo.getContactPerson());
        lqw.eq(StringUtils.isNotBlank(bo.getContactPhone()), CkSite::getContactPhone, bo.getContactPhone());
        return lqw;
    }

    /**
     * 新增网点信息
     *
     * @param bo 网点信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(CkSiteBo bo) {
        CkSite add = MapstructUtils.convert(bo, CkSite.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改网点信息
     *
     * @param bo 网点信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(CkSiteBo bo) {
        CkSite update = MapstructUtils.convert(bo, CkSite.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(CkSite entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除网点信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteByIds(ids) > 0;
    }
}
