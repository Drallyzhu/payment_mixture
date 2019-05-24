package com.payment.payment_mixture;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;

@SpringBootApplication
//@ImportResource({"classpath:spring-context-dubbo.xml"})
@Controller
public class PaymentMixtureApplication extends WebMvcConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(PaymentMixtureApplication.class);

    @RequestMapping("/")
    public String greeting() {
        return "index";
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/cert/**").addResourceLocations(
                "classpath:/cert/");
//        registry.addResourceHandler("/static/css/**").addResourceLocations(
//                "classpath:/css/");
//        registry.addResourceHandler("/static/images/**").addResourceLocations(
//                "classpath:/images/");
//        registry.addResourceHandler("/static/js/**").addResourceLocations(
//                "classpath:/js/");
//        registry.addResourceHandler("/static/plugin/**").addResourceLocations(
//                "classpath:/plugin/");
        super.addResourceHandlers(registry);
        logger.info("自定义静态资源目录,这只是个Demo,生产肯定不会暴露");
    }

    public static void main(String[] args) throws InterruptedException,
            IOException {
        SpringApplication.run(PaymentMixtureApplication.class, args);
        logger.info("支付项目启动 ");
    }

}
