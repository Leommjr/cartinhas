package br.com.ilhadaslendas.cartinhas.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target({ ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@InterceptorBinding
public @interface Transacional {
	
}