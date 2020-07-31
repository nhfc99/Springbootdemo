package com.nhfc99.template.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ToolUtils {
    public static void queryWrapperEQ(Object object, QueryWrapper queryWrapper) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        try {
            Map<String, String> map = BeanUtils.describe(object);

            //添加条件
            List<String> list = new ArrayList<>(map.keySet());
            for (String key :
                    list) {
                String value = map.get(key);
                if (value != null) {
                    queryWrapper.eq(key, value);
                }
            }
        } catch (Exception ex) {

        }
    }
}
