package com.still_a_long_way25.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.GzipResourceResolver;

/**
 * WebConfigクラス
 * Created by y-ok on 2017/04/26.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 静的リソースに対する定義をします
     *
     * @param registry {@link ResourceHandlerRegistry}
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // webjars の定義
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/")
                .resourceChain(false)        // 自動でWebJarsResourceResolverが有効化される
                .addResolver(new GzipResourceResolver());  // gzファイルへのアクセス有効化
    }
}
