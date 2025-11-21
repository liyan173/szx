package com.szx.common.translation.core.impl;

import lombok.AllArgsConstructor;
import com.szx.common.core.service.UserService;
import com.szx.common.translation.annotation.TranslationType;
import com.szx.common.translation.constant.TransConstant;
import com.szx.common.translation.core.TranslationInterface;

/**
 * 用户名翻译实现
 *
 * @author Lion Li
 */
@AllArgsConstructor
@TranslationType(type = TransConstant.USER_ID_TO_NAME)
public class UserNameTranslationImpl implements TranslationInterface<String> {

    private final UserService userService;

    @Override
    public String translation(Object key, String other) {
        if (key instanceof Long id) {
            return userService.selectUserNameById(id);
        }
        return null;
    }
}
