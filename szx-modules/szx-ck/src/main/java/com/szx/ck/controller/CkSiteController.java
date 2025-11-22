package com.szx.ck.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.szx.ck.domain.bo.CkSiteBo;
import com.szx.ck.domain.vo.CkSiteVo;
import com.szx.ck.service.ICkSiteService;
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
 * 网点信息
 *
 * @author Lion Li
 * @date 2025-11-22
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/ck/site")
public class CkSiteController extends BaseController {

    private final ICkSiteService ckSiteService;

    /**
     * 查询网点信息列表
     */
    @SaCheckPermission("ck:site:list")
    @GetMapping("/list")
    public TableDataInfo<CkSiteVo> list(CkSiteBo bo, PageQuery pageQuery) {
        return ckSiteService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出网点信息列表
     */
    @SaCheckPermission("ck:site:export")
    @Log(title = "网点信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(CkSiteBo bo, HttpServletResponse response) {
        List<CkSiteVo> list = ckSiteService.queryList(bo);
        ExcelUtil.exportExcel(list, "网点信息", CkSiteVo.class, response);
    }

    /**
     * 获取网点信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("ck:site:query")
    @GetMapping("/{id}")
    public R<CkSiteVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(ckSiteService.queryById(id));
    }

    /**
     * 新增网点信息
     */
    @SaCheckPermission("ck:site:add")
    @Log(title = "网点信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody CkSiteBo bo) {
        return toAjax(ckSiteService.insertByBo(bo));
    }

    /**
     * 修改网点信息
     */
    @SaCheckPermission("ck:site:edit")
    @Log(title = "网点信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody CkSiteBo bo) {
        return toAjax(ckSiteService.updateByBo(bo));
    }

    /**
     * 删除网点信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("ck:site:remove")
    @Log(title = "网点信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(ckSiteService.deleteWithValidByIds(List.of(ids), true));
    }
}
