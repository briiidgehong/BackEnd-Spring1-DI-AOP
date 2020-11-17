package spring.aop;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Program {
    public static void main(String[] args) {
        Exam exam = new NewlecExam(1, 2, 3, 4);

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
        Exam proxy = (Exam) Proxy.newProxyInstance(
                NewlecExam.class.getClassLoader(),
                new Class[]{Exam.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        long start = System.currentTimeMillis();

                        Object result = method.invoke(exam,args);


                        long end = System.currentTimeMillis();
                        String message = (end - start) + "ms 시간이 소요되었습니다.";
                        System.out.println(message);
                        return result;
                    }
                });

        System.out.printf("total is %d", proxy.total());
        System.out.printf("total is %d", proxy.avg());
        //System.out.printf("total is %d", exam.total());
    }
}

