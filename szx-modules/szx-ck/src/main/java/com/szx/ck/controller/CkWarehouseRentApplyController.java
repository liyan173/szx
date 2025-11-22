package com.szx.ck.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.szx.ck.domain.bo.CkWarehouseRentApplyBo;
import com.szx.ck.domain.vo.CkWarehouseRentApplyVo;
import com.szx.ck.service.ICkWarehouseRentApplyService;
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
 * 仓库出租服务申请
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/ck/warehouseRentApply")
public class CkWarehouseRentApplyController extends BaseController {

    private final ICkWarehouseRentApplyService ckWarehouseRentApplyService;

    /**
     * 查询仓库出租服务申请列表
     */
    @SaCheckPermission("ck:warehouseRentApply:list")
    @GetMapping("/list")
    public TableDataInfo<CkWarehouseRentApplyVo> list(CkWarehouseRentApplyBo bo, PageQuery pageQuery) {
        return ckWarehouseRentApplyService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出仓库出租服务申请列表
     */
    @SaCheckPermission("ck:warehouseRentApply:export")
    @Log(title = "仓库出租服务申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(CkWarehouseRentApplyBo bo, HttpServletResponse response) {
        List<CkWarehouseRentApplyVo> list = ckWarehouseRentApplyService.queryList(bo);
        ExcelUtil.exportExcel(list, "仓库出租服务申请", CkWarehouseRentApplyVo.class, response);
    }

    /**
     * 获取仓库出租服务申请详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("ck:warehouseRentApply:query")
    @GetMapping("/{id}")
    public R<CkWarehouseRentApplyVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(ckWarehouseRentApplyService.queryById(id));
    }

    /**
     * 新增仓库出租服务申请
     */
    @SaCheckPermission("ck:warehouseRentApply:add")
    @Log(title = "仓库出租服务申请", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody CkWarehouseRentApplyBo bo) {
        return toAjax(ckWarehouseRentApplyService.insertByBo(bo));
    }

    /**
     * 修改仓库出租服务申请
     */
    @SaCheckPermission("ck:warehouseRentApply:edit")
    @Log(title = "仓库出租服务申请", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody CkWarehouseRentApplyBo bo) {
        return toAjax(ckWarehouseRentApplyService.updateByBo(bo));
    }

    /**
     * 删除仓库出租服务申请
     *
     * @param ids 主键串
     */
    @SaCheckPermission("ck:warehouseRentApply:remove")
    @Log(title = "仓库出租服务申请", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(ckWarehouseRentApplyService.deleteWithValidByIds(List.of(ids), true));
    }
}
