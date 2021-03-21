package com.atguigu.util;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    public static <T>  T copyParamToBean(Map map, T bean){
        try {
            //注入
            BeanUtils.populate(bean, map);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    public  static int parseInt(String value,int defaultValue){
        if (value!=null){
            try {
                return  Integer.parseInt(value);
            }   catch (Exception e){
                e.printStackTrace();
            }
        }
        return  defaultValue;
    }
}
