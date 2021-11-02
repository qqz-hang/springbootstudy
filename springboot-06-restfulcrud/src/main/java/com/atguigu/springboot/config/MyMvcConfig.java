package com.atguigu.springboot.config;

import com.atguigu.springboot.commpont.MyLocaleResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.embedded.jetty.ConfigurableJettyWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 自定义嵌入式的Servlet容器的定制器
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
            @Override
            public void customize(ConfigurableServletWebServerFactory factory) {
                factory.setPort(8083);
            }
        };
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 添加view-controller 进行页面跳转
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Bean
    public LocaleResolver localeResolver() {
        logger.info(" localeResolver success");
        return new MyLocaleResolver();
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor())
//                .addPathPatterns("/*")
//                .excludePathPatterns("/index.html","/user/login","/asserts/**","/");
//    }
}
