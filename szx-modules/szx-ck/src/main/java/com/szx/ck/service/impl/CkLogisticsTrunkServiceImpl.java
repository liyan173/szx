package com.szx.ck.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szx.ck.domain.CkLogisticsTrunk;
import com.szx.ck.domain.bo.CkLogisticsTrunkBo;
import com.szx.ck.domain.vo.CkLogisticsTrunkVo;
import com.szx.ck.mapper.CkLogisticsTrunkMapper;
import com.szx.ck.service.ICkLogisticsTrunkService;
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
 * 物流干线配送服务Service业务层处理
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CkLogisticsTrunkServiceImpl implements ICkLogisticsTrunkService {

    private final CkLogisticsTrunkMapper baseMapper;

    /**
     * 查询物流干线配送服务
     *
     * @param id 主键
     * @return 物流干线配送服务
     */
    @Override
    public CkLogisticsTrunkVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询物流干线配送服务列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 物流干线配送服务分页列表
     */
    @Override
    public TableDataInfo<CkLogisticsTrunkVo> queryPageList(CkLogisticsTrunkBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<CkLogisticsTrunk> lqw = buildQueryWrapper(bo);
        Page<CkLogisticsTrunkVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的物流干线配送服务列表
     *
     * @param bo 查询条件
     * @return 物流干线配送服务列表
     */
    @Override
    public List<CkLogisticsTrunkVo> queryList(CkLogisticsTrunkBo bo) {
        LambdaQueryWrapper<CkLogisticsTrunk> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<CkLogisticsTrunk> buildQueryWrapper(CkLogisticsTrunkBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<CkLogisticsTrunk> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(CkLogisticsTrunk::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getOrigin()), CkLogisticsTrunk::getOrigin, bo.getOrigin());
        lqw.eq(StringUtils.isNotBlank(bo.getDestination()), CkLogisticsTrunk::getDestination, bo.getDestination());
        lqw.eq(bo.getMinFee() != null, CkLogisticsTrunk::getMinFee, bo.getMinFee());
        lqw.eq(bo.getPricePerKg() != null, CkLogisticsTrunk::getPricePerKg, bo.getPricePerKg());
        return lqw;
    }

    /**
     * 新增物流干线配送服务
     *
     * @param bo 物流干线配送服务
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(CkLogisticsTrunkBo bo) {
        CkLogisticsTrunk add = MapstructUtils.convert(bo, CkLogisticsTrunk.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改物流干线配送服务
     *
     * @param bo 物流干线配送服务
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(CkLogisticsTrunkBo bo) {
        CkLogisticsTrunk update = MapstructUtils.convert(bo, CkLogisticsTrunk.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(CkLogisticsTrunk entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除物流干线配送服务信息
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
