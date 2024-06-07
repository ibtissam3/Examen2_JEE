package com.example.sprinng__crud.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class[] { MyWebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("root");
        return new Class[] { RootConfig.class , MyHibernateConfig.class};

    }
    @Override
    protected String getServletName() {
        System.out.println("ServletInitializer.getServletName");
        return "dispatcher"; // Nom du servlet Dispatcher
    }


}