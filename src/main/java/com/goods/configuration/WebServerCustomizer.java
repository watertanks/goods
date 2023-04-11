package com.goods.configuration;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class WebServerCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>{
	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		
		// 페이지 생성
		ErrorPage errorPage404 = new ErrorPage(HttpStatus.BAD_REQUEST, "/error");
		ErrorPage errorPage400 = new ErrorPage(HttpStatus.NOT_FOUND, "/error");
		ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error");
		
		// 페이지 등록
		factory.addErrorPages(errorPage404);
		factory.addErrorPages(errorPage400);
		factory.addErrorPages(errorPage500);
	}
}
