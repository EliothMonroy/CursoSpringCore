package org.certificatic.spring.aop.practica23.aspectjconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAspectJAutoProxy
@ImportResource(locations = {
		"classpath:/spring/practica23/mago-aop-application-context.xml" })
public class SpringAspectJAopConfig {

}
