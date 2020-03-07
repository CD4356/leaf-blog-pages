package com.cd.blog.config.webmvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfiguration implements WebMvcConfigurer {

    //无逻辑页面跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /* 前台展示页面路径映射 */
        registry.addViewController("/").setViewName("front/index");
        registry.addViewController("/blog_detail").setViewName("front/blog_detail");
        registry.addViewController("/blog_type").setViewName("front/blog_type");
        registry.addViewController("/blog_tag").setViewName("front/blog_tag");
        registry.addViewController("/blog_archive").setViewName("front/blog_archive");
        registry.addViewController("/about_me").setViewName("front/about_me");

        /* 后台管理页面路径映射 */
        registry.addViewController("/admin").setViewName("admin/admin");
        registry.addViewController("/blog_publish").setViewName("admin/blog_publish");

        /* 博客引用插件页面路径映射 */
        registry.addViewController("/blog_plugin").setViewName("front/blog_plugin");


        /* 测试 */
        registry.addViewController("/blog").setViewName("md/blog");
        registry.addViewController("/demo").setViewName("md/demo");
    }

    //静态资源访问映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 配置图片虚拟路径，访问外部图片：当URL读到/upload/时，就会自动解析成/home/blog/image/upload/
         */
        registry.addResourceHandler("/upload/**").addResourceLocations("file:/home/blog/image/upload/");
    }

    /**
     * 文件上传解析器
     * @return
     */
//    @Bean("multipartResolver")
//    public CommonsMultipartResolver createMultipartResolver(){
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setDefaultEncoding("UTF-8");
//        // 1024*1024*20 = 20M
//        multipartResolver.setMaxUploadSize(1024*1024*20);
//        multipartResolver.setMaxInMemorySize(1024*1024*20);
//        return multipartResolver;
//    }
}
