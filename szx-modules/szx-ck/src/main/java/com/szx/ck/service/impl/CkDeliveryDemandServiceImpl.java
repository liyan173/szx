package com.szx.ck.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szx.ck.domain.CkDeliveryDemand;
import com.szx.ck.domain.bo.CkDeliveryDemandBo;
import com.szx.ck.domain.vo.CkDeliveryDemandVo;
import com.szx.ck.mapper.CkDeliveryDemandMapper;
import com.szx.ck.service.ICkDeliveryDemandService;
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
 * 货物配送需求Service业务层处理
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CkDeliveryDemandServiceImpl implements ICkDeliveryDemandService {

    private final CkDeliveryDemandMapper baseMapper;

    /**
     * 查询货物配送需求
     *
     * @param id 主键
     * @return 货物配送需求
     */
    @Override
    public CkDeliveryDemandVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询货物配送需求列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 货物配送需求分页列表
     */
    @Override
    public TableDataInfo<CkDeliveryDemandVo> queryPageList(CkDeliveryDemandBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<CkDeliveryDemand> lqw = buildQueryWrapper(bo);
        Page<CkDeliveryDemandVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的货物配送需求列表
     *
     * @param bo 查询条件
     * @return 货物配送需求列表
     */
    @Override
    public List<CkDeliveryDemandVo> queryList(CkDeliveryDemandBo bo) {
        LambdaQueryWrapper<CkDeliveryDemand> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<CkDeliveryDemand> buildQueryWrapper(CkDeliveryDemandBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<CkDeliveryDemand> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(CkDeliveryDemand::getId);
        lqw.eq(bo.getPersonalServiceFee() != null, CkDeliveryDemand::getPersonalServiceFee, bo.getPersonalServiceFee());
        lqw.eq(bo.getUpstairsFee() != null, CkDeliveryDemand::getUpstairsFee, bo.getUpstairsFee());
        lqw.eq(StringUtils.isNotBlank(bo.getLabeling()), CkDeliveryDemand::getLabeling, bo.getLabeling());
        lqw.eq(StringUtils.isNotBlank(bo.getUnloading()), CkDeliveryDemand::getUnloading, bo.getUnloading());
        lqw.eq(StringUtils.isNotBlank(bo.getUnpacking()), CkDeliveryDemand::getUnpacking, bo.getUnpacking());
        return lqw;
    }

    /**
     * 新增货物配送需求
     *
     * @param bo 货物配送需求
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(CkDeliveryDemandBo bo) {
        CkDeliveryDemand add = MapstructUtils.convert(bo, CkDeliveryDemand.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改货物配送需求
     *
     * @param bo 货物配送需求
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(CkDeliveryDemandBo bo) {
        CkDeliveryDemand update = MapstructUtils.convert(bo, CkDeliveryDemand.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(CkDeliveryDemand entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除货物配送需求信息
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
