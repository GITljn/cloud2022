package com.bjpowernode.customhystrix.aspect;

import com.bjpowernode.customhystrix.model.CustomHystrix;
import com.bjpowernode.customhystrix.model.HystrixStatus;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
@Aspect
public class CustomHystrixAspect {
    private static Map<String, CustomHystrix> map = new HashMap<>();

    static {
        map.put("rent-car-service", new CustomHystrix());
    }

    @Pointcut("@annotation(com.bjpowernode.customhystrix.annotation.CustomHystrixAnno)")
    public void pt(){

    }

    @Around("pt()")
    public Object myHystrix(ProceedingJoinPoint pjp) {
        Object result = null;
        CustomHystrix customHystrix = map.get("rent-car-service");
        HystrixStatus hystrixStatus = customHystrix.getHystrixStatus();
        switch (hystrixStatus) {
            case CLOSE:
                try {
                    result = pjp.proceed();
                    return result;
                } catch (Throwable throwable) {
                    customHystrix.addFailTime();
                    return "备选方案";
                }
            case OPEN:
                return "备选方案";
            case HALF_OPEN:
                Random random = new Random();
                int i = random.nextInt(5);
                if (i == 1) {
                    try {
                        result = pjp.proceed();
                        customHystrix.setHystrixStatus(HystrixStatus.CLOSE);
                        synchronized (customHystrix.getLock()) {
                            customHystrix.getLock().notifyAll();
                        }
                        return result;
                    } catch (Throwable throwable) {
                        return "备选方案";
                    }
                }
            default:
                return "备选方案";
        }

    }
}
