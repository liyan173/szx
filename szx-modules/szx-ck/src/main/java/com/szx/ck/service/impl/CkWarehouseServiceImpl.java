package com.szx.ck.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szx.ck.domain.CkWarehouse;
import com.szx.ck.domain.bo.CkWarehouseBo;
import com.szx.ck.domain.vo.CkWarehouseVo;
import com.szx.ck.mapper.CkWarehouseMapper;
import com.szx.ck.service.ICkWarehouseService;
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
 * 仓库基础数据录入Service业务层处理
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CkWarehouseServiceImpl implements ICkWarehouseService {

    private final CkWarehouseMapper baseMapper;

    /**
     * 查询仓库基础数据录入
     *
     * @param id 主键
     * @return 仓库基础数据录入
     */
    @Override
    public CkWarehouseVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询仓库基础数据录入列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 仓库基础数据录入分页列表
     */
    @Override
    public TableDataInfo<CkWarehouseVo> queryPageList(CkWarehouseBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<CkWarehouse> lqw = buildQueryWrapper(bo);
        Page<CkWarehouseVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的仓库基础数据录入列表
     *
     * @param bo 查询条件
     * @return 仓库基础数据录入列表
     */
    @Override
    public List<CkWarehouseVo> queryList(CkWarehouseBo bo) {
        LambdaQueryWrapper<CkWarehouse> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<CkWarehouse> buildQueryWrapper(CkWarehouseBo bo) {

        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<CkWarehouse> lqw = Wrappers.lambdaQuery();

        // 时间区间查询（推荐写法）
        Object beginTime = params.get("beginTime");
        Object endTime = params.get("endTime");
        if (beginTime != null && endTime != null) {
            lqw.between(CkWarehouse::getCreateTime, beginTime, endTime);
        }

        // 精准匹配
        lqw.eq(StringUtils.isNotBlank(bo.getManageType()), CkWarehouse::getManageType, bo.getManageType());
        lqw.eq(StringUtils.isNotBlank(bo.getRegion()), CkWarehouse::getRegion, bo.getRegion());
        lqw.eq(StringUtils.isNotBlank(bo.getAddress()), CkWarehouse::getAddress, bo.getAddress());
        lqw.eq(StringUtils.isNotBlank(bo.getMainCategory()), CkWarehouse::getMainCategory, bo.getMainCategory());
        lqw.eq(StringUtils.isNotBlank(bo.getFireLevel()), CkWarehouse::getFireLevel, bo.getFireLevel());
        lqw.eq(bo.getUseYears() != null, CkWarehouse::getUseYears, bo.getUseYears());
        lqw.eq(bo.getAreaMu() != null, CkWarehouse::getAreaMu, bo.getAreaMu());
        lqw.eq(bo.getBuildingCount() != null, CkWarehouse::getBuildingCount, bo.getBuildingCount());
        lqw.eq(bo.getVolumeRatio() != null, CkWarehouse::getVolumeRatio, bo.getVolumeRatio());
        lqw.eq(bo.getFloorHeight() != null, CkWarehouse::getFloorHeight, bo.getFloorHeight());
        lqw.eq(bo.getTotalArea() != null, CkWarehouse::getTotalArea, bo.getTotalArea());
        lqw.eq(bo.getAuthenticationState() != null, CkWarehouse::getAuthenticationState, bo.getAuthenticationState());
        lqw.eq(bo.getFireExpireDate() != null, CkWarehouse::getFireExpireDate, bo.getFireExpireDate());

        // 模糊查询（名称）
        lqw.like(StringUtils.isNotBlank(bo.getWarehouseName()), CkWarehouse::getWarehouseName, bo.getWarehouseName());

        // 多选字段（text 类型适合用 like）
        lqw.like(StringUtils.isNotBlank(bo.getInnerFacilities()), CkWarehouse::getInnerFacilities, bo.getInnerFacilities());
        lqw.like(StringUtils.isNotBlank(bo.getOuterFacilities()), CkWarehouse::getOuterFacilities, bo.getOuterFacilities());
        lqw.like(StringUtils.isNotBlank(bo.getSecurityInfo()), CkWarehouse::getSecurityInfo, bo.getSecurityInfo());
        lqw.like(StringUtils.isNotBlank(bo.getAdvantage()), CkWarehouse::getAdvantage, bo.getAdvantage());
        lqw.like(StringUtils.isNotBlank(bo.getFunctionInfo()), CkWarehouse::getFunctionInfo, bo.getFunctionInfo());
        lqw.like(StringUtils.isNotBlank(bo.getGallery()), CkWarehouse::getGallery, bo.getGallery());
        lqw.like(StringUtils.isNotBlank(bo.getWarehouseAreaInfo()), CkWarehouse::getWarehouseAreaInfo, bo.getWarehouseAreaInfo());

        // 排序
        //lqw.orderByAsc(CkWarehouse::getId);

        return lqw;
    }

    /**
     * 新增仓库基础数据录入
     *
     * @param bo 仓库基础数据录入
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(CkWarehouseBo bo) {

        bo.setAuthenticationState(4);

        CkWarehouse add = MapstructUtils.convert(bo, CkWarehouse.class);

        validEntityBeforeSave(add);

        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改仓库基础数据录入
     *
     * @param bo 仓库基础数据录入
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(CkWarehouseBo bo) {
        CkWarehouse update = MapstructUtils.convert(bo, CkWarehouse.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(CkWarehouse entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除仓库基础数据录入信息
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
