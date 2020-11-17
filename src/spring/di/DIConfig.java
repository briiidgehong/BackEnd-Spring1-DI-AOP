package spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import spring.di.consoleUI.ExamConsole;
import spring.di.consoleUI.InlineExamConsole;
import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;

@ComponentScan({"spring.di.entity", "spring.di.consoleUI"})
@Configuration
public class DIConfig {

    @Bean
    public Exam exam(){
        return new NewlecExam();
    }

    @Bean
    public ExamConsole examConsole(){
        return new InlineExamConsole(exam());
    }

}
