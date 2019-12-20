package com.jimliao.application;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

import com.jimliao.spi.IShout;

@HandlesTypes({ IShout.class })
public class MyWebApplicationInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> set, ServletContext ctx) throws ServletException {
		System.out.println("MyWebApplicationInitializer implements ServletContainerInitializer onStartup!");
		
		for (Class<?> clazz : set) {
			try {
				IShout iShout = (IShout) clazz.newInstance();
				iShout.shout();
			} catch (Exception e) {
				throw new ServletException("Failed to instantiate WebApplicationInitializer class", e);
			}
		}
	}
}