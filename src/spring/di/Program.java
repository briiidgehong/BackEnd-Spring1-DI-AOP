package spring.di;

import spring.di.consoleUI.ExamConsole;
import spring.di.consoleUI.GridExamConsole;
import spring.di.consoleUI.InlineExamConsole;
import spring.di.entity.Exam;
import spring.di.entity.NewlecEcam;

public class Program {
    public static void main(String[] args) {
        //1. 데이터를 가지고 있는 엔티티로써의 클래스 추가
        //2. 엔티티를 활용해서 출력을 담당하는 함수

        Exam exam = new NewlecEcam(10,90,90,85);

        //DI : 부품 조립 가능함 -> 이 부분을 설정파일(XML, ANNOTATION) 으로 빼주는 것이 SPRING
        //ExamConsole console = new InlineExamConsole(exam); //DI
        ExamConsole console = new GridExamConsole(exam); //DI

        console.print();
    }
}
