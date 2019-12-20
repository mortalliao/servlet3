package com.jimliao.servlet3;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "filter1", // 指定过滤器name属性, 等价与<filter-name>
		urlPatterns = "/*", // 等价value, 过滤器URL匹配模式, 等价于<url-pattern>
		dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD }, // 过滤器的转发模式
		initParams = { @WebInitParam(name = "account", value = "1234"), @WebInitParam(name = "hotusm", value = "1234") }
// 过滤器初始化参数, 等价于<init-param>
)
public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String account = filterConfig.getInitParameter("account");
		String hotusm = filterConfig.getInitParameter("hotusm");

		System.out.println("account:" + account + " hotusm:" + hotusm);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
