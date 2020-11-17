package spring.di.consoleUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import spring.di.entity.Exam;

public class InlineExamConsole implements ExamConsole {

    public InlineExamConsole() {
    }

    private Exam exam;
    public InlineExamConsole(Exam exam) {
        this.exam = exam;
    }

    @Autowired
    @Qualifier("exam1")
    @Override
    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @Override
    public void print() {
        System.out.printf("total is %d avg is %f\n",exam.total(),exam.avg());
    }
}
