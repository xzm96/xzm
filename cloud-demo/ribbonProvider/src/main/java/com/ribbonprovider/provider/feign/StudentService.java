package com.ribbonprovider.provider.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 2020/3/5
 * Create By 肖章明
 */
public interface StudentService {

    /**
     * 获取所有学生列表
     */
    @GetMapping(value = "/myfeign/student")
    String getAllStudent();

    /**
     * 添加学生
     */
    @PostMapping(value = "/myfeign/student")
    String saveStudent(@RequestBody Student student);
}
