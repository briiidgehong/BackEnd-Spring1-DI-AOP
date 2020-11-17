package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.di.consoleUI.ExamConsole;
import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);
                                     new ClassPathXmlApplicationContext("spring/di/spring-config.xml");
        //data type으로 bean 가져오기
        ExamConsole console2 = context.getBean(ExamConsole.class);
        console2.print();
        NewlecExam exam = context.getBean(NewlecExam.class);
        System.out.println(exam.toString());
    }


}
