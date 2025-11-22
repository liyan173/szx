package com.szx.ck.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.szx.ck.domain.bo.CkDeliveryDemandBo;
import com.szx.ck.domain.vo.CkDeliveryDemandVo;
import com.szx.ck.service.ICkDeliveryDemandService;
import com.szx.common.core.domain.R;
import com.szx.common.core.validate.AddGroup;
import com.szx.common.core.validate.EditGroup;
import com.szx.common.excel.utils.ExcelUtil;
import com.szx.common.idempotent.annotation.RepeatSubmit;
import com.szx.common.log.annotation.Log;
import com.szx.common.log.enums.BusinessType;
import com.szx.common.mybatis.core.page.PageQuery;
import com.szx.common.mybatis.core.page.TableDataInfo;
import com.szx.common.web.core.BaseController;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 货物配送需求
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/ck/deliveryDemand")
public class CkDeliveryDemandController extends BaseController {

    private final ICkDeliveryDemandService ckDeliveryDemandService;

    /**
     * 查询货物配送需求列表
     */
    @SaCheckPermission("ck:deliveryDemand:list")
    @GetMapping("/list")
    public TableDataInfo<CkDeliveryDemandVo> list(CkDeliveryDemandBo bo, PageQuery pageQuery) {
        return ckDeliveryDemandService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出货物配送需求列表
     */
    @SaCheckPermission("ck:deliveryDemand:export")
    @Log(title = "货物配送需求", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(CkDeliveryDemandBo bo, HttpServletResponse response) {
        List<CkDeliveryDemandVo> list = ckDeliveryDemandService.queryList(bo);
        ExcelUtil.exportExcel(list, "货物配送需求", CkDeliveryDemandVo.class, response);
    }

    /**
     * 获取货物配送需求详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("ck:deliveryDemand:query")
    @GetMapping("/{id}")
    public R<CkDeliveryDemandVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(ckDeliveryDemandService.queryById(id));
    }

    /**
     * 新增货物配送需求
     */
    @SaCheckPermission("ck:deliveryDemand:add")
    @Log(title = "货物配送需求", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody CkDeliveryDemandBo bo) {
        return toAjax(ckDeliveryDemandService.insertByBo(bo));
    }

    /**
     * 修改货物配送需求
     */
    @SaCheckPermission("ck:deliveryDemand:edit")
    @Log(title = "货物配送需求", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody CkDeliveryDemandBo bo) {
        return toAjax(ckDeliveryDemandService.updateByBo(bo));
    }

    /**
     * 删除货物配送需求
     *
     * @param ids 主键串
     */
    @SaCheckPermission("ck:deliveryDemand:remove")
    @Log(title = "货物配送需求", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(ckDeliveryDemandService.deleteWithValidByIds(List.of(ids), true));
    }
}
