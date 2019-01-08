package com.example.sleuthclient.interceptor;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.debug("This is a debug message");
		logger.info("This is an info message");

		// time
		long startTime = Instant.now().toEpochMilli();
		logger.info("Request URL::" + request.getRequestURL().toString() + ":: Start Time=" + Instant.now());
		request.setAttribute("startTime", startTime);

		try {
			MDC.put("status", "" + response.getStatus());

			MDC.put("httpreq", "" + request.getRequestURL().toString());
			MDC.put("pathinfo", "" + request.getPathInfo());
			MDC.put("appname", "" + "raiser");
		} finally {

		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.warn("This is a warn message");
		logger.error("This is an error message");

	}

}
