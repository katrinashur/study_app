package tech.visdom.study_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class StudyAppApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(StudyAppApplication.class, args);
    }

}
