package spring.aop.advice;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.aspectj.AspectJAfterThrowingAdvice;

public class LogAfterThrowingAdvice implements ThrowsAdvice {
    //어떤 예외가 발생하냐에 따라 함수가 달라진다.
    public void afterThrowing(IllegalArgumentException e) throws Throwable{
        System.out.println("예외 발생하였습니다.:" + e.getMessage());
    }
}
