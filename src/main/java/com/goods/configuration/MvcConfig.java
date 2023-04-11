package com.goods.configuration;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration	
@EnableWebMvc	// 스프링 MVC 설정을 활성화하는 애노테이션
public class MvcConfig implements WebMvcConfigurer {
	
	@Override
	public void configureDefaultServletHandling(
		DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}	// 매핑 경로를 처리하기 위한 메소드
	 
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
	// view에서 보여줄 jsp 파일에 대한 위치(접두어) 및 접미어에 대한 설정을 하는 메소드
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	// 특별한 작업없이 단순히 연결만 할 경우 컨트롤러를 따로 만드는 것이 아닌 
	// addViewControllers() 메소드를 사용하여 요청 경로와 뷰 이름을 연결
		registry.addViewController("/home").setViewName("home");
	}
	
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 정적자원의 기본경로는 'src/main/resources' 이다.
		/* '/js/**'로 호출하는 자원은 '/static/js/' 폴더 아래에서 찾는다. */ 
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/").setCachePeriod(60 * 60 * 24 * 365); 
		
        /* '/css/**'로 호출하는 자원은 '/static/css/' 폴더 아래에서 찾는다. */ 
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/").setCachePeriod(60 * 60 * 24 * 365); 
		
        /* '/img/**'로 호출하는 자원은 '/static/img/' 폴더 아래에서 찾는다. */ 
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/").setCachePeriod(60 * 60 * 24 * 365); 
		
        /* '/font/**'로 호출하는 자원은 '/static/font/' 폴더 아래에서 찾는다. */ 
        registry.addResourceHandler("/font/**").addResourceLocations("classpath:/static/font/").setCachePeriod(60 * 60 * 24 * 365); 
	}
}
