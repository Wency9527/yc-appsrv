package com.yc.common.validator;

import com.yc.common.exception.CommonException;
import org.apache.commons.lang.StringUtils;

/**
 * 断言，数据校验
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if(StringUtils.isBlank(str)) {
            throw new CommonException(message);
        }
    }

    public static void isNull(Object obj, String message) {
        if(obj == null) {
            throw new CommonException(message);
        }
    }

}
