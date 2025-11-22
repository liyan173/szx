package com.szx.ck.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szx.ck.domain.CkCompany;
import com.szx.ck.domain.bo.CkCompanyBo;
import com.szx.ck.domain.vo.CkCompanyVo;
import com.szx.ck.mapper.CkCompanyMapper;
import com.szx.ck.service.ICkCompanyService;
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
 * 企业信息Service业务层处理
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CkCompanyServiceImpl implements ICkCompanyService {

    private final CkCompanyMapper baseMapper;

    /**
     * 查询企业信息
     *
     * @param id 主键
     * @return 企业信息
     */
    @Override
    public CkCompanyVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询企业信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 企业信息分页列表
     */
    @Override
    public TableDataInfo<CkCompanyVo> queryPageList(CkCompanyBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<CkCompany> lqw = buildQueryWrapper(bo);
        Page<CkCompanyVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的企业信息列表
     *
     * @param bo 查询条件
     * @return 企业信息列表
     */
    @Override
    public List<CkCompanyVo> queryList(CkCompanyBo bo) {
        LambdaQueryWrapper<CkCompany> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<CkCompany> buildQueryWrapper(CkCompanyBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<CkCompany> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(CkCompany::getId);
        lqw.like(StringUtils.isNotBlank(bo.getCompanyName()), CkCompany::getCompanyName, bo.getCompanyName());
        lqw.eq(StringUtils.isNotBlank(bo.getRegisterAddress()), CkCompany::getRegisterAddress, bo.getRegisterAddress());
        lqw.eq(StringUtils.isNotBlank(bo.getCompanyType()), CkCompany::getCompanyType, bo.getCompanyType());
        lqw.eq(StringUtils.isNotBlank(bo.getCompanyScale()), CkCompany::getCompanyScale, bo.getCompanyScale());
        lqw.eq(StringUtils.isNotBlank(bo.getCompanyIntro()), CkCompany::getCompanyIntro, bo.getCompanyIntro());
        lqw.eq(StringUtils.isNotBlank(bo.getVehicleInfo()), CkCompany::getVehicleInfo, bo.getVehicleInfo());
        lqw.eq(StringUtils.isNotBlank(bo.getCreditCode()), CkCompany::getCreditCode, bo.getCreditCode());
        lqw.eq(StringUtils.isNotBlank(bo.getAddress()), CkCompany::getAddress, bo.getAddress());
        lqw.eq(StringUtils.isNotBlank(bo.getBusinessType()), CkCompany::getBusinessType, bo.getBusinessType());
        lqw.eq(StringUtils.isNotBlank(bo.getMainCategory()), CkCompany::getMainCategory, bo.getMainCategory());
        lqw.eq(StringUtils.isNotBlank(bo.getDeliveryArea()), CkCompany::getDeliveryArea, bo.getDeliveryArea());
        lqw.eq(StringUtils.isNotBlank(bo.getDeliveryCenterInfo()), CkCompany::getDeliveryCenterInfo, bo.getDeliveryCenterInfo());
        return lqw;
    }

    /**
     * 新增企业信息
     *
     * @param bo 企业信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(CkCompanyBo bo) {
        CkCompany add = MapstructUtils.convert(bo, CkCompany.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改企业信息
     *
     * @param bo 企业信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(CkCompanyBo bo) {
        CkCompany update = MapstructUtils.convert(bo, CkCompany.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(CkCompany entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除企业信息信息
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
