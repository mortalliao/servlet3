package com.jimliao.servlet3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "servlet1", // 指定servlet的name属性, 等价于<servlet-name>. 如果没有显示指定, 则为类的全限定名
		urlPatterns = { "/url1", "/url2" }, // URL匹配模式, 等价于<ul-pattern>标签
		loadOnStartup = 1, // 指定servlet的价值顺序, 等价于<load-on-startup>标签
		initParams = { @WebInitParam(name = "name", value = "hotusm") } //初始化参数, <init-param>
)
public class MyServlet extends HttpServlet {

	private String name;

	public MyServlet() {
		System.out.println("load on startup");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		name = this.getInitParameter("name");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		System.out.println(session);
		System.out.println("name:" + name);
	}

}
