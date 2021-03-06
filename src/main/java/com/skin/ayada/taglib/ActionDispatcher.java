/*
 * $RCSfile: ActionDispatcher.java,v $
 * $Revision: 1.1 $
 * $Date: 2011-12-09 $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 */
package com.skin.ayada.taglib;

import java.lang.reflect.Method;
import java.util.Map;

import com.skin.ayada.PageContext;
import com.skin.ayada.util.Reflect;

/**
 * <p>Title: ActionDispatcher</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author xuesong.net
 * @version 1.0
 */
public class ActionDispatcher {
    private static final Class<?>[] PARAMETERTYPES = new Class[]{PageContext.class, Parameters.class};

    /**
     * @param pageContext
     * @param parameters
     * @param className
     * @param methodName
     * @return Map<String, Object>
     * @throws Exception
     */
    public static Map<String, Object> dispatch(PageContext pageContext, Parameters parameters, String className, String methodName) throws Exception {
        if(methodName != null) {
            return execute(pageContext, parameters, className, methodName);
        }
        else {
            return execute(pageContext, parameters, className, "execute");
        }
    }

    /**
     * @param pageContext
     * @param parameters
     * @param className
     * @param methodName
     * @return Map<String, Object>
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> execute(PageContext pageContext, Parameters parameters, String className, String methodName) throws Exception {
        Class<?> type = Reflect.getClass(className);
        Method method = Reflect.getMethod(type, methodName, PARAMETERTYPES);

        Object instance = type.newInstance();
        Object context = method.invoke(instance, new Object[]{pageContext, parameters});

        if(context instanceof Map) {
            return (Map<String, Object>)context;
        }
        return null;
    }
}
