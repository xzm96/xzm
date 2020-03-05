package com.ribbonprovider.provider;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

/**
 * 2020/3/3
 * Create By 肖章明
 */
public class HelloCommand extends HystrixCommand<String> {

    private final String url;

    private final RestTemplate restTemplate;

    /**
     * 构造函数  -- 必须
     * @return
     * @throws Exception
     */
    public HelloCommand(HystrixCommandGroupKey group, int executionIsolationThreadTimeoutInMilliseconds, String url, RestTemplate restTemplate){
        super(group,executionIsolationThreadTimeoutInMilliseconds);
        this.url=url;
        this.restTemplate=restTemplate;
    }


    /**
     * 执行请求操作
     * @return
     * @throws Exception
     */
    @Override
    protected String run() throws Exception {
        return restTemplate.getForEntity(url,String.class).getBody();
    }

    /**
     * 执行回调方法
     */
    @Override
    protected String getFallback(){
       return "HelloWorldCommand time is out 100ms";
    }
}
