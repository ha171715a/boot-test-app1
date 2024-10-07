package com.dev.fwk.common.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * [클래스 한글명]
 *
 * <pre>
 * ApplicationContext 설정
 * </pre>
 * @author "user name"
 * @history
 * "user name"   2023. 5. 9.  [변경내용상세 기술]
*/
@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext applicationContext;


    /**
     * default constructor
     * */
    public ApplicationContextProvider() {
        // default constructor
    }

    /* (non-Javadoc)
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationCtx) throws BeansException {
        ApplicationContextProvider.applicationContext = applicationCtx;
    }

    public static ApplicationContext getContext() {
        return applicationContext;
    }
}
