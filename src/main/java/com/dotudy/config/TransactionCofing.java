package com.dotudy.config;

import javax.sql.DataSource;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Aspect
@Configuration
public class TransactionCofing {
	private static final String AOP_POINTCUT_EXPRESSION = "execution(* *..*Service.*(..))";
	private static final int NORMAL_TIMEOUT = 60;
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public TransactionManager primaryTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean
	public TransactionInterceptor transactionAdvice() {
		DefaultTransactionAttribute required = new DefaultTransactionAttribute();
		required.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		required.setTimeout(NORMAL_TIMEOUT);
		
		DefaultTransactionAttribute requiredReadOnly = new DefaultTransactionAttribute();
		requiredReadOnly.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		requiredReadOnly.setTimeout(NORMAL_TIMEOUT);
		requiredReadOnly.setReadOnly(true);
		
		DefaultTransactionAttribute requiredNew = new DefaultTransactionAttribute();
		requiredNew.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		requiredNew.setTimeout(NORMAL_TIMEOUT);
		
		NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
		source.addTransactionalMethod("delete*", required);
		source.addTransactionalMethod("update*", required);
		source.addTransactionalMethod("insert*", required);
		source.addTransactionalMethod("create*", required);
		source.addTransactionalMethod("save*", required);
		source.addTransactionalMethod("add*", required);
		
		source.addTransactionalMethod("select*", requiredReadOnly);
		source.addTransactionalMethod("get*", requiredReadOnly);
		source.addTransactionalMethod("find*", requiredReadOnly);
		source.addTransactionalMethod("search*", requiredReadOnly);
		source.addTransactionalMethod("count*", requiredReadOnly);
		source.addTransactionalMethod("is*", requiredReadOnly);
		source.addTransactionalMethod("retrieve*", requiredReadOnly);
		source.addTransactionalMethod("query*", requiredReadOnly);
		
		source.addTransactionalMethod("callNumber*", requiredNew);
		
		return new TransactionInterceptor(primaryTransactionManager(), source);
	}
	
	@Bean
	public Advisor transactionAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
		return new DefaultPointcutAdvisor(pointcut, transactionAdvice());
	}
}
