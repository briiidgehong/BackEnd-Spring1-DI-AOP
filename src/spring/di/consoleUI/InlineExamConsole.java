package spring.di.consoleUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring.di.entity.Exam;


// or @Component("console")
public class InlineExamConsole implements ExamConsole {

    @Autowired(required = false)
    // required option: 꼭 bean 이 생성 안되어 있어도 됨
    // 생성되어있으면 DI / 없으면 DI 안함

    // @Qualifier("exam1")
    // 기본생성자에서 바인딩
    private Exam exam;

    public InlineExamConsole() {
        System.out.println("기본생성자 바인딩");
    }

    // @Autowired
    // @Qualifier("exam1")
    // 오버로딩 생성자에서 바인딩
    // public InlineExamConsole(@Qualifier("exam1")Exam exam) {
    public InlineExamConsole(Exam exam) {
        System.out.println("오버로딩생성자 바인딩");
        this.exam = exam;
    }


    // setter 에서 바인딩
    // @Autowired
    //@Qualifier("exam")
    @Override
    public void setExam(Exam exam) {
        System.out.println("setter 바인딩");
        this.exam = exam;
    }

    @Override
    public void print() {
        if(exam==null)
        {
            System.out.printf("total is %d avg is %f\n",0,0);
        }

        System.out.printf("total is %d avg is %f\n",exam.total(),exam.avg());
    }
}
