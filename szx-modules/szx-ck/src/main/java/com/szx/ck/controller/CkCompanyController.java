package com.szx.ck.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.szx.common.idempotent.annotation.RepeatSubmit;
import com.szx.common.log.annotation.Log;
import com.szx.common.web.core.BaseController;
import com.szx.common.mybatis.core.page.PageQuery;
import com.szx.common.core.domain.R;
import com.szx.common.core.validate.AddGroup;
import com.szx.common.core.validate.EditGroup;
import com.szx.common.log.enums.BusinessType;
import com.szx.common.excel.utils.ExcelUtil;
import com.szx.ck.domain.vo.CkCompanyVo;
import com.szx.ck.domain.bo.CkCompanyBo;
import com.szx.ck.service.ICkCompanyService;
import com.szx.common.mybatis.core.page.TableDataInfo;

/**
 * 企业信息
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/ck/company")
public class CkCompanyController extends BaseController {

    private final ICkCompanyService ckCompanyService;

    /**
     * 查询企业信息列表
     */
    @SaCheckPermission("ck:company:list")
    @GetMapping("/list")
    public TableDataInfo<CkCompanyVo> list(CkCompanyBo bo, PageQuery pageQuery) {
        return ckCompanyService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出企业信息列表
     */
    @SaCheckPermission("ck:company:export")
    @Log(title = "企业信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(CkCompanyBo bo, HttpServletResponse response) {
        List<CkCompanyVo> list = ckCompanyService.queryList(bo);
        ExcelUtil.exportExcel(list, "企业信息", CkCompanyVo.class, response);
    }

    /**
     * 获取企业信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("ck:company:query")
    @GetMapping("/{id}")
    public R<CkCompanyVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(ckCompanyService.queryById(id));
    }

    /**
     * 新增企业信息
     */
    @SaCheckPermission("ck:company:add")
    @Log(title = "企业信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody CkCompanyBo bo) {
        return toAjax(ckCompanyService.insertByBo(bo));
    }

    /**
     * 修改企业信息
     */
    @SaCheckPermission("ck:company:edit")
    @Log(title = "企业信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody CkCompanyBo bo) {
        return toAjax(ckCompanyService.updateByBo(bo));
    }

    /**
     * 删除企业信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("ck:company:remove")
    @Log(title = "企业信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(ckCompanyService.deleteWithValidByIds(List.of(ids), true));
    }
}
