/*
 * $RCSfile: TemplateDispatcher.java,v $
 * $Revision: 1.1 $
 * $Date: 2013-03-10 $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 */
package com.skin.ayada.web;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skin.ayada.Template;
import com.skin.ayada.TemplateContext;
import com.skin.ayada.util.ClassUtil;
import com.skin.ayada.util.Path;

/**
 * <p>Title: TemplateDispatcher</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author xuesong.net
 * @version 1.0
 */
public class TemplateDispatcher {
    private String name;
    private String prefix;
    private String encoding;
    private String contentType;
    private ServletContext servletContext;
    private TemplateContext templateContext;
    private static final Logger logger = LoggerFactory.getLogger(TemplateDispatcher.class);

    /**
     * @param filterConfig
     * @return TemplateDispatcher
     * @throws ServletException
     */
    public static TemplateDispatcher create(FilterConfig filterConfig) throws ServletException {
        Properties properties = getProperties(filterConfig);
        ServletContext servletContext = filterConfig.getServletContext();
        return create(servletContext, properties);
    }

    /**
     * @param servletConfig
     * @return TemplateDispatcher
     * @throws ServletException
     */
    public static TemplateDispatcher create(ServletConfig servletConfig) throws ServletException {
        Properties properties = getProperties(servletConfig);
        ServletContext servletContext = servletConfig.getServletContext();
        return create(servletContext, properties);
    }

    /**
     * @param servletContext
     * @param properties
     * @return TemplateDispatcher
     * @throws ServletException
     */
    public static TemplateDispatcher create(ServletContext servletContext, Properties properties) throws ServletException {
        String name = properties.getProperty("name");
        String prefix = properties.getProperty("prefix");
        String encoding = properties.getProperty("encoding");
        String contentType = properties.getProperty("contentType");
        String sourcePattern = properties.getProperty("sourcePattern");
        String templateContextFactoryClass = properties.getProperty("templateContextFactoryClass");

        if(prefix != null) {
            prefix = Path.getStrictPath(prefix);
        }

        if(encoding == null) {
            encoding = "UTF-8";
        }

        if(contentType == null) {
            contentType = "text/html; charset=UTF-8";
        }

        if(logger.isInfoEnabled()) {
            logger.info("name: {}", name);
            logger.info("page.prefix: {}", prefix);
            logger.info("page.encoding: {}", encoding);
            logger.info("page.contentType: {}", contentType);
            logger.info("page.sourcePattern: {}", sourcePattern);
            logger.info("page.contextFactory: {}", templateContextFactoryClass);
        }

        TemplateContext templateContext = getTemplateContext(servletContext, properties);
        TemplateDispatcher templateDispatcher = new TemplateDispatcher();
        templateDispatcher.setName(name);
        templateDispatcher.setPrefix(prefix);
        templateDispatcher.setEncoding(encoding);
        templateDispatcher.setContentType(contentType);
        templateDispatcher.setServletContext(servletContext);
        templateDispatcher.setTemplateContext(templateContext);

        if(name != null) {
            servletContext.setAttribute(name, templateDispatcher);
        }
        return templateDispatcher;
    }

    /**
     * @param servletContext
     * @param properties
     * @return TemplateContext
     */
    protected static TemplateContext getTemplateContext(ServletContext servletContext, Properties properties) throws ServletException {
        String className = properties.getProperty("templateContextFactoryClass");

        if(className == null || className.trim().length() < 1) {
            return new TemplateContextFactory().create(servletContext, properties);
        }

        Method method = null;
        Object factory = null;

        try {
            factory = ClassUtil.getInstance(className);
        }
        catch (Exception e) {
            throw new ServletException("class '" + className + "' not found.", e);
        }

        try {
            method = factory.getClass().getMethod("create", new Class[]{ServletContext.class, Properties.class});
            return (TemplateContext)(method.invoke(factory, new Object[]{servletContext, properties}));
        }
        catch(Exception e) {
        }

        try {
            method = factory.getClass().getMethod("create", new Class[0]);
            return (TemplateContext)(method.invoke(factory, new Object[0]));
        }
        catch(Exception e) {
            throw new ServletException("method 'create' not found.", e);
        }
    }

    /**
     * @param filterConfig
     * @return Properties
     */
    protected static Properties getProperties(FilterConfig filterConfig) {
        Properties properties = new Properties();
        Enumeration<?> names = filterConfig.getInitParameterNames();

        while(names.hasMoreElements()) {
            String name = (String)(names.nextElement());
            String value = filterConfig.getInitParameter(name);

            if(value != null) {
                properties.setProperty(name, value);
            }
        }
        return properties;
    }

    /**
     * @param servletConfig
     * @return Properties
     */
    protected static Properties getProperties(ServletConfig servletConfig) {
        Properties properties = new Properties();
        Enumeration<?> names = servletConfig.getInitParameterNames();
        
        while(names.hasMoreElements()) {
            String name = (String)(names.nextElement());
            String value = servletConfig.getInitParameter(name);

            if(value != null) {
                properties.setProperty(name, value);
            }
        }
        return properties;
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void dispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = Path.getStrictPath(request.getRequestURI());
        String contextPath = this.getContextPath(request);

        if(contextPath.length() > 0 && path.startsWith(contextPath)) {
            path = path.substring(contextPath.length());
        }
        this.dispatch(request, response, path);
    }

    /**
     * @param request
     * @param response
     * @param page
     * @throws ServletException
     * @throws IOException
     */
    public void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        String path = page;

        if(logger.isDebugEnabled()) {
            logger.debug("prefix: {}, page: {}", this.prefix, page);
        }

        if(this.prefix != null && this.prefix.length() > 1 && path.startsWith(this.prefix)) {
            path = path.substring(this.prefix.length());
        }

        try {
            Template template = this.templateContext.getTemplate(path, this.encoding);

            if(template == null) {
                if(logger.isDebugEnabled()) {
                    logger.debug("404: " + page);
                }
                response.sendError(404);
                return;
            }

            Request.setServletContext(request, this.servletContext);
            Map<String, Object> context = Request.getContext(this.servletContext, request, response);
            Writer writer = Request.getWriter(request, response);

            if(response.getContentType() == null && this.contentType != null) {
                response.setContentType(this.contentType);
            }
            this.templateContext.execute(template, context, writer);
        }
        catch(Exception e) {
            if(response.isCommitted()) {
                logger.error(e.getMessage(), e);
            }
            else {
                if(e instanceof RuntimeException) {
                    throw (RuntimeException)e;
                }
                else if(e instanceof ServletException) {
                    throw (ServletException)e;
                }
                else if(e instanceof IOException) {
                    throw (IOException)e;
                }
                else {
                    throw new ServletException(e);
                }
            }
        }
    }

    /**
     * @param request
     * @return String
     */
    public String getContextPath(HttpServletRequest request) {
        String contextPath = request.getContextPath();

        if(contextPath == null || contextPath.equals("/")) {
            return "";
        }
        return contextPath;
    }

    /**
     *
     */
    public void destroy() {
        this.templateContext.destory();
        this.templateContext = null;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param prefix the prefix to set
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * @return the prefix
     */
    public String getPrefix() {
        return this.prefix;
    }

    /**
     * @param encoding the encoding to set
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * @return the encoding
     */
    public String getEncoding() {
        return this.encoding;
    }

    /**
     * @param contentType the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * @return the contentType
     */
    public String getContentType() {
        return this.contentType;
    }

    /**
     * @param servletContext the servletContext to set
     */
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    /**
     * @return the servletContext
     */
    public ServletContext getServletContext() {
        return this.servletContext;
    }

    /**
     * @param templateContext the templateContext to set
     */
    public void setTemplateContext(TemplateContext templateContext) {
        this.templateContext = templateContext;
    }

    /**
     * @return the templateContext
     */
    public TemplateContext getTemplateContext() {
        return this.templateContext;
    }
}
