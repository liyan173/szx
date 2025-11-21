package com.szx.generator.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.szx.common.mybatis.core.mapper.BaseMapperPlus;
import com.szx.generator.domain.GenTableColumn;

/**
 * 业务字段 数据层
 *
 * @author Lion Li
 */
@InterceptorIgnore(dataPermission = "true")
public interface GenTableColumnMapper extends BaseMapperPlus<GenTableColumn, GenTableColumn> {

}
