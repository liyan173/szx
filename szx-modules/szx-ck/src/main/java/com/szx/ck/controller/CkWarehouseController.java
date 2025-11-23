package com.szx.ck.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.szx.ck.domain.bo.CkWarehouseBo;
import com.szx.ck.domain.vo.CkWarehouseVo;
import com.szx.ck.service.ICkWarehouseService;
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
 * 仓库基础数据录入
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/ck/warehouse")
public class CkWarehouseController extends BaseController {

    private final ICkWarehouseService ckWarehouseService;

    /**
     * 查询仓库基础数据录入列表
     */
    @SaCheckPermission("ck:warehouse:list")
    @GetMapping("/list")
    public TableDataInfo<CkWarehouseVo> list(CkWarehouseBo bo, PageQuery pageQuery) {
        return ckWarehouseService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出仓库基础数据录入列表
     */
    @SaCheckPermission("ck:warehouse:export")
    @Log(title = "仓库基础数据录入", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(CkWarehouseBo bo, HttpServletResponse response) {
        List<CkWarehouseVo> list = ckWarehouseService.queryList(bo);
        ExcelUtil.exportExcel(list, "仓库基础数据录入", CkWarehouseVo.class, response);
    }

    /**
     * 获取仓库基础数据录入详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("ck:warehouse:query")
    @GetMapping("/{id}")
    public R<CkWarehouseVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(ckWarehouseService.queryById(id));
    }

    /**
     * 新增仓库基础数据录入
     */
    @SaCheckPermission("ck:warehouse:add")
    @Log(title = "仓库基础数据录入", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody CkWarehouseBo bo) {
        return toAjax(ckWarehouseService.insertByBo(bo));
    }

    /**
     * 修改仓库基础数据录入
     */
    @SaCheckPermission("ck:warehouse:edit")
    @Log(title = "仓库基础数据录入", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody CkWarehouseBo bo) {
        return toAjax(ckWarehouseService.updateByBo(bo));
    }

    /**
     * 删除仓库基础数据录入
     *
     * @param ids 主键串
     */
    @SaCheckPermission("ck:warehouse:remove")
    @Log(title = "仓库基础数据录入", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(ckWarehouseService.deleteWithValidByIds(List.of(ids), true));
    }
}
