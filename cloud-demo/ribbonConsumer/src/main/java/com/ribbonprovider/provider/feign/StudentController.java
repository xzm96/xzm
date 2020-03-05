package com.ribbonprovider.provider.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2020/3/5
 * Create By 肖章明
 */
@RestController
public class StudentController implements StudentService {

    @Autowired
    private StudentService studentService;

    @Override
    public String getAllStudent() {
        return studentService.getAllStudent();
    }

    @Override
    public String saveStudent(Student student) {
        return studentService.saveStudent(student);
    }
}
