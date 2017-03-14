package com.gs.reusebook.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CrossDomainFilter implements Filter{
	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		((HttpServletResponse)resp).addHeader("Access-Control-Allow-Origin", "http://localhost:8000");
		((HttpServletResponse)resp).addHeader("Access-Control-Allow-Credentials", "true");
		((HttpServletResponse)resp).addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		((HttpServletResponse)resp).addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, OPTIONS");
		
		chain.doFilter(req, resp);
		
	}

	public void destroy() {
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
