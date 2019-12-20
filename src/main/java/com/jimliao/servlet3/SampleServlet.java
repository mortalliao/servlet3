package com.jimliao.servlet3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "sample", urlPatterns = { "/sample" }, asyncSupported = true)
@SuppressWarnings("serial")
public class SampleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hello world");
	}
}
