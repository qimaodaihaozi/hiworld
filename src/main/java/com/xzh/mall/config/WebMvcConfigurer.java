package com.xzh.mall.config;

import com.xzh.mall.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
class WebMvcConfigurer extends WebMvcConfigurerAdapter{//配置拦截器

		@Bean
		public LoginInterceptor getLoginIntercepter()
		{
			return new LoginInterceptor();
		}

		@Override
		public void addInterceptors(InterceptorRegistry registry)
		{

			registry.addInterceptor(getLoginIntercepter())
					.addPathPatterns("/**");
		}
	}



