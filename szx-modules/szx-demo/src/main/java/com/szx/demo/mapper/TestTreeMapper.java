package com.szx.demo.mapper;

import com.szx.common.mybatis.annotation.DataColumn;
import com.szx.common.mybatis.annotation.DataPermission;
import com.szx.common.mybatis.core.mapper.BaseMapperPlus;
import com.szx.demo.domain.TestTree;
import com.szx.demo.domain.vo.TestTreeVo;

/**
 * 测试树表Mapper接口
 *
 * @author Lion Li
 * @date 2021-07-26
 */
@DataPermission({
    @DataColumn(key = "deptName", value = "dept_id"),
    @DataColumn(key = "userName", value = "user_id")
})
public interface TestTreeMapper extends BaseMapperPlus<TestTree, TestTreeVo> {

}
