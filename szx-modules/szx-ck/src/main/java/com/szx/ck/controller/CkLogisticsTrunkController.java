package com.szx.ck.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.szx.ck.domain.bo.CkLogisticsTrunkBo;
import com.szx.ck.domain.vo.CkLogisticsTrunkVo;
import com.szx.ck.service.ICkLogisticsTrunkService;
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
 * 物流干线配送服务
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/ck/logisticsTrunk")
public class CkLogisticsTrunkController extends BaseController {

    private final ICkLogisticsTrunkService ckLogisticsTrunkService;

    /**
     * 查询物流干线配送服务列表
     */
    @SaCheckPermission("ck:logisticsTrunk:list")
    @GetMapping("/list")
    public TableDataInfo<CkLogisticsTrunkVo> list(CkLogisticsTrunkBo bo, PageQuery pageQuery) {
        return ckLogisticsTrunkService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出物流干线配送服务列表
     */
    @SaCheckPermission("ck:logisticsTrunk:export")
    @Log(title = "物流干线配送服务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(CkLogisticsTrunkBo bo, HttpServletResponse response) {
        List<CkLogisticsTrunkVo> list = ckLogisticsTrunkService.queryList(bo);
        ExcelUtil.exportExcel(list, "物流干线配送服务", CkLogisticsTrunkVo.class, response);
    }

    /**
     * 获取物流干线配送服务详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("ck:logisticsTrunk:query")
    @GetMapping("/{id}")
    public R<CkLogisticsTrunkVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(ckLogisticsTrunkService.queryById(id));
    }

    /**
     * 新增物流干线配送服务
     */
    @SaCheckPermission("ck:logisticsTrunk:add")
    @Log(title = "物流干线配送服务", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody CkLogisticsTrunkBo bo) {
        return toAjax(ckLogisticsTrunkService.insertByBo(bo));
    }

    /**
     * 修改物流干线配送服务
     */
    @SaCheckPermission("ck:logisticsTrunk:edit")
    @Log(title = "物流干线配送服务", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody CkLogisticsTrunkBo bo) {
        return toAjax(ckLogisticsTrunkService.updateByBo(bo));
    }

    /**
     * 删除物流干线配送服务
     *
     * @param ids 主键串
     */
    @SaCheckPermission("ck:logisticsTrunk:remove")
    @Log(title = "物流干线配送服务", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(ckLogisticsTrunkService.deleteWithValidByIds(List.of(ids), true));
    }
}
