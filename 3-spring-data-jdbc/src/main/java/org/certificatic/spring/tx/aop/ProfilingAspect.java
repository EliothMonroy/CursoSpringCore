package org.certificatic.spring.tx.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.certificatic.spring.tx.util.Color;
import org.certificatic.spring.tx.util.bean.api.IColorWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component("profilingAspect")
@Slf4j
public class ProfilingAspect implements Ordered {

	private @Getter int order = 101;

	@Autowired
	private IColorWriter colorWriter;

	@Pointcut("within(org.certificatic.spring.tx.pratica26.springtx.service..*) && "
			+ "@annotation(org.springframework.transaction.annotation.Transactional)")
	public void transactionalMethod() {
	}

	@Pointcut("within(org.certificatic.spring.tx.pratica26.springtx.service..*) && "
			+ "@target(org.springframework.transaction.annotation.Transactional)")
	public void transactionalClass() {
	}

	@Around(value = "transactionalMethod() || transactionalClass()")
	public Object beforeAccountMethodExecutionAccount(ProceedingJoinPoint pjp)
			throws Throwable {

		log.info("{}",
				colorWriter.getColoredMessage(Color.GREEN,
						"initializing profiling of: " + pjp.getClass().getSimpleName()));

		StopWatch stopWatch = new StopWatch();
		stopWatch.start(pjp.toShortString());

		boolean isExceptionThrown = false;

		try {
			return pjp.proceed();
		} catch (RuntimeException e) {
			isExceptionThrown = true;
			throw e;
		} finally {
			stopWatch.stop();
			TaskInfo taskInfo = stopWatch.getLastTaskInfo();

			String profileMessage = taskInfo.getTaskName() + ": " + taskInfo.getTimeMillis() + " ms" +
					(isExceptionThrown ? " (thrown Exception)" : "");

			log.info("{}", colorWriter.getColoredMessage(Color.GREEN, "object intercepted: " + profileMessage));
		}
	}
}
