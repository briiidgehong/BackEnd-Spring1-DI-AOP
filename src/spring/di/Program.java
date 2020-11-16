package spring.di;

import spring.di.consoleUI.ExamConsole;
import spring.di.consoleUI.GridExamConsole;
import spring.di.consoleUI.InlineExamConsole;
import spring.di.entity.Exam;
import spring.di.entity.NewlecEcam;

public class Program {
    public static void main(String[] args) {

        Exam exam = new NewlecEcam(10,90,90,85);

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

        console.print();
    }
}
