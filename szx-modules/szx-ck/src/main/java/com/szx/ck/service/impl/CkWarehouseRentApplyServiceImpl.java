package com.szx.ck.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szx.ck.domain.CkWarehouseRentApply;
import com.szx.ck.domain.bo.CkWarehouseRentApplyBo;
import com.szx.ck.domain.vo.CkWarehouseRentApplyVo;
import com.szx.ck.mapper.CkWarehouseRentApplyMapper;
import com.szx.ck.service.ICkWarehouseRentApplyService;
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
 * 仓库出租服务申请Service业务层处理
 *
 * @author Lion Li
 * @date 2025-11-27
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CkWarehouseRentApplyServiceImpl implements ICkWarehouseRentApplyService {

    private final CkWarehouseRentApplyMapper baseMapper;

    /**
     * 查询仓库出租服务申请
     *
     * @param id 主键
     * @return 仓库出租服务申请
     */
    @Override
    public CkWarehouseRentApplyVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询仓库出租服务申请列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 仓库出租服务申请分页列表
     */
    @Override
    public TableDataInfo<CkWarehouseRentApplyVo> queryPageList(CkWarehouseRentApplyBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<CkWarehouseRentApply> lqw = buildQueryWrapper(bo);
        Page<CkWarehouseRentApplyVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的仓库出租服务申请列表
     *
     * @param bo 查询条件
     * @return 仓库出租服务申请列表
     */
    @Override
    public List<CkWarehouseRentApplyVo> queryList(CkWarehouseRentApplyBo bo) {
        LambdaQueryWrapper<CkWarehouseRentApply> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<CkWarehouseRentApply> buildQueryWrapper(CkWarehouseRentApplyBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<CkWarehouseRentApply> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(CkWarehouseRentApply::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getTitle()), CkWarehouseRentApply::getTitle, bo.getTitle());
        lqw.like(StringUtils.isNotBlank(bo.getCompanyName()), CkWarehouseRentApply::getCompanyName, bo.getCompanyName());
        lqw.eq(bo.getRentableArea() != null, CkWarehouseRentApply::getRentableArea, bo.getRentableArea());
        lqw.eq(bo.getMinRentArea() != null, CkWarehouseRentApply::getMinRentArea, bo.getMinRentArea());
        lqw.eq(bo.getPrice() != null, CkWarehouseRentApply::getPrice, bo.getPrice());
        lqw.eq(bo.getPropertyPrice() != null, CkWarehouseRentApply::getPropertyPrice, bo.getPropertyPrice());
        lqw.eq(bo.getAutoOffDate() != null, CkWarehouseRentApply::getAutoOffDate, bo.getAutoOffDate());
        lqw.eq(StringUtils.isNotBlank(bo.getContactPerson()), CkWarehouseRentApply::getContactPerson, bo.getContactPerson());
        lqw.eq(StringUtils.isNotBlank(bo.getContactPhone()), CkWarehouseRentApply::getContactPhone, bo.getContactPhone());
        lqw.eq(StringUtils.isNotBlank(bo.getInfoDesc()), CkWarehouseRentApply::getInfoDesc, bo.getInfoDesc());
        lqw.eq(bo.getCompanyId() != null, CkWarehouseRentApply::getCompanyId, bo.getCompanyId());
        lqw.eq(StringUtils.isNotBlank(bo.getAuthenticationState()), CkWarehouseRentApply::getAuthenticationState, bo.getAuthenticationState());
        return lqw;
    }

    /**
     * 新增仓库出租服务申请
     *
     * @param bo 仓库出租服务申请
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(CkWarehouseRentApplyBo bo) {
        CkWarehouseRentApply add = MapstructUtils.convert(bo, CkWarehouseRentApply.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改仓库出租服务申请
     *
     * @param bo 仓库出租服务申请
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(CkWarehouseRentApplyBo bo) {
        CkWarehouseRentApply update = MapstructUtils.convert(bo, CkWarehouseRentApply.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(CkWarehouseRentApply entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除仓库出租服务申请信息
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
