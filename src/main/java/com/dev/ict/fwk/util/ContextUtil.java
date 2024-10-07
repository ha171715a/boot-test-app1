package com.dev.fwk.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import com.dev.fwk.common.context.ApplicationContextProvider;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class ContextUtil {


    /****************************************************************************************************
    *
    * Application Context에 등록된 Object 가져오는 method
    *
   ****************************************************************************************************/

    private static ApplicationContext getContext() {
        return ApplicationContextProvider.getContext();
    }


    public static <T> T getBean(Class<T> requiredType){
        if(getContext() == null) {
            return null;
        }

        try {
            return getContext().getBean(requiredType);
        } catch(BeansException e) {
            log.error("BeanUtil[getBean] Exception [{}]{}", e.getMessage(), e.toString());
            return null;
        }
    }

    public static <T> T getBean(String beanName, Class<T> requiredType) {
        if(getContext() == null) {
            return null;
        }

        try {
            return getContext().getBean(beanName, requiredType);
        } catch(BeansException e) {
            log.error("BeanUtil[getBean] Exception [{}]{}", e.getMessage(), e.toString());
            return null;
        }
    }

    public static Object getBean(String beanName) {
        if(getContext() == null) {
            return null;
        }

        try {
            return getContext().getBean(beanName);
        } catch(BeansException e) {
            log.error("BeanUtil[getBean] Exception [{}]{}", e.getMessage(), e.toString());
            return null;
        }
    }
}
