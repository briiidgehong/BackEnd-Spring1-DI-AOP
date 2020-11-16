package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.di.consoleUI.ExamConsole;
import spring.di.consoleUI.GridExamConsole;
import spring.di.consoleUI.InlineExamConsole;
import spring.di.entity.Exam;
import spring.di.entity.NewlecEcam;

public class Program {
    public static void main(String[] args) {

/* To spring beans
        //Exam exam = new NewlecEcam(10,90,90,85);
        Exam exam = new NewlecEcam();

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
        ExamConsole console = (ExamConsole)context.getBean("console");
        console.print();

        ExamConsole console2 = context.getBean(ExamConsole.class);
        console.print();
    }
}
