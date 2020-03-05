package com.ribbonprovider.provider.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 2020/3/5
 * Create By 肖章明
 */
@RestController
public class StudentController implements StudentService {

    @Autowired
    @Qualifier("IStudentServiceImpl")
    private StudentService studentService;

    @Value("${server.port}")
    private String port;

    private static Random random = new Random();

    @Override
    public String getAllStudent() {
        long executeTime = random.nextInt(100);
        System.out.println("executeTime :" +executeTime);
        try {
            TimeUnit.MILLISECONDS.sleep(executeTime);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return studentService.getAllStudent()+"  port：  "+port;
    }

    @Override
    public String saveStudent(Student student) {
        return studentService.saveStudent(student);
    }


}
