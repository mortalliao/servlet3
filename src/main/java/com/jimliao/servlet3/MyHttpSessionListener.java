package com.jimliao.servlet3;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("创建session");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("销毁session");
	}

}
