package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.di.consoleUI.ExamConsole;
import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {

//일반 data type
/* To spring beans
        //Exam exam = new NewlecEcam(10,90,90,85);
        Exam exam = new NewlecExam();

        // Inline 끼웠다가 grid 끼웠다가 식으로
        // 부품 조립 가능함 -> 이 부분을 설정파일(XML, ANNOTATION) 으로 빼주는 것이 SPRING
        //ExamConsole console = new InlineExamConsole(exam);
        //ExamConsole console = new GridExamConsole(exam);

        // DI
        // 1. construnctor injection
        //ExamConsole console = new GridExamConsole(exam);

        // 2. setter injection
        ExamConsole console = new GridExamConsole();
        console.setExam(exam);
*/
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        //이름으로 bean 가져오기
        ExamConsole console = (ExamConsole)context.getBean("console");
        console.print();
/*
        //data type으로 bean 가져오기
        ExamConsole console2 = context.getBean(ExamConsole.class);
        console.print();
        NewlecExam exam = context.getBean(NewlecExam.class);
        System.out.println(exam.toString());
*/

//collections
/*      To spring beans
        ArrayList<Exam> exams = new ArrayList<>();
        exams.add(new NewlecExam(80,85,90,95));

        for(Exam e : exams)
        {
            System.out.println(e);
        }
*/

        ArrayList<Exam> exams = (ArrayList<Exam>) context.getBean("exams");
        for(Exam e : exams)
        {
            System.out.println("collection"+e);
        }
    }
}
