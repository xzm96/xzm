package com.ribbonprovider.provider.feign;

import org.springframework.stereotype.Component;

/**
 * 2020/3/5
 * Create By 肖章明
 */
@Component
public class StudentServiceFallBack implements StudentService{
    @Override
    public String getAllStudent() {
        return "getAllStudent()  超时降级处理";
    }

    @Override
    public String saveStudent(Student student) {
        return "getAllStudent()  超时降级处理";
    }
}
