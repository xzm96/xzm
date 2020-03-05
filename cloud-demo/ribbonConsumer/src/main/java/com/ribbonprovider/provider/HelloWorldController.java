package com.ribbonprovider.provider;

import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 2020/3/2
 * Create By 肖章明
 */
@RestController
public class HelloWorldController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/helloWorld")
    public String helloWorld(){
//        return restTemplate.getForEntity("http://RIBBON-SERVICE/hello",String.class).getBody();
        return new HelloCommand(HystrixCommandGroupKey.Factory.asKey("Ribbon Client"),100,"http://RIBBON-SERVICE/hello",restTemplate).execute();
    }

    /**
     * 服务端熔断请求的方法
     */
//    @GetMapping("/helloWorld/hystrix")
//    public String hystrixHelloWorld(){
//        return restTemplate.getForEntity("http://RIBBON-SERVICE/hello/hystrix",String.class).getBody();
//    }


}
