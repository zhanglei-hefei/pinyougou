package com.tensquare.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

@SpringBootApplication
public class BaseApplication {
    /**
     * springBoot的入口
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class,args);
    }


    /**
     * 将 IdWorker(唯一ID生成器加入spring容器中)
     * @return
     */
    @Bean
    public IdWorker getIdWorker(){
        return new IdWorker(1,1);
    }
}
