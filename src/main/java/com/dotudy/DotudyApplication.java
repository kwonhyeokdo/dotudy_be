package com.dotudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableTransactionManagement(proxyTargetClass = true, mode = AdviceMode.ASPECTJ)
public class DotudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DotudyApplication.class, args);
	}

}
