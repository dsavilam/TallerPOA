package com.example.aspect;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.example.service.*.*(..))")
    public void serviceMethods() {}

    @Before("serviceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Antes de ejecutar: " +
                joinPoint.getSignature().getName() +
                " con args=" + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("Método " +
                joinPoint.getSignature().getName() +
                " ejecutado con éxito");
        if (result != null) {
            System.out.println("Resultado: " + result);
        }
    }

    @AfterThrowing(pointcut = "serviceMethods()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        System.out.println("Excepción en " +
                joinPoint.getSignature().getName() +
                ": " + ex.getMessage());
    }

    @After("serviceMethods()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Después de ejecutar: " +
                joinPoint.getSignature().getName());
    }

    @Around("execution(* com.example.service.ProductoServicio.updatePrice(..))")
    public Object logAroundUpdatePrice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("=== Iniciando actualización de precio ===");
        long start = System.currentTimeMillis();
        try {
            Object ret = pjp.proceed();
            System.out.println("Precio actualizado correctamente");
            return ret;
        } catch (Throwable t) {
            System.out.println("Error al actualizar: " + t.getMessage());
            throw t;
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("Tiempo de ejecución: " + (end - start) + "ms");
            System.out.println("=== Operación finalizada ===");
        }
    }
}
