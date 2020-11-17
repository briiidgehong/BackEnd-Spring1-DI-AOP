package spring.aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;
import spring.di.DIConfig;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Program {
    public static void main(String[] args) {

        // 1. total 시작과 끝에다가 시간 측정하는 로직을 넣고싶다.
        /*public int total() {
            ***요기랑
            int result = kor+eng+math+com;
            ***요기
            return result;
        }*/

        // 2. proxy 생성
        //public static Object newProxyInstance(
        //        ClassLoader loader,
        //        @NotNull Class<?>[] interfaces,
        //        @NotNull reflect.InvocationHandler h)
/*
        Exam proxy = (Exam) Proxy.newProxyInstance(
                NewlecExam.class.getClassLoader(),
                new Class[]{Exam.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        long start = System.currentTimeMillis();

                        //실제 측정 Logic
                        Object result = method.invoke(exam,args);

                        long end = System.currentTimeMillis();
                        String message = (end - start) + "ms 시간이 소요되었습니다.";
                        System.out.println(message);
                        return result;
                    }
                });
*/
        //AroundAdvice
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/aop/spring-config.xml");
        // new ClassPathXmlApplicationContext("spring.aop.spring-config.xml");
        // new AnnotationConfigApplicationContext(DIConfig.class);
        Exam proxy = (Exam) context.getBean("proxy");

        System.out.printf("total is %d\n", proxy.total());
        System.out.printf("total is %f\n", proxy.avg());

    }
}

