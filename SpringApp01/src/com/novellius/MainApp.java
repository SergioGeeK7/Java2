package com.novellius;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		
		// allow you to use spring tools
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.config.xml");
		Administrador admin = (Administrador) applicationContext.getBean("admin");
		
		System.out.println(admin);
		admin.imprimirDireccion();
		((ClassPathXmlApplicationContext)applicationContext).close();
	}
}
