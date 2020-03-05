package com.ribbonprovider.provider.feign;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 2020/3/5
 * Create By 肖章明
 */
@Service("IStudentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Value("${server.port}")
    private String port;

    private static List<Student> studentList = new ArrayList<>();

    @Override
    public String getAllStudent() {
        return studentList.toString();
    }

    @Override
    public String saveStudent(Student student) {
        studentList.add(student);
        return "ok + " + port;
    }
}
