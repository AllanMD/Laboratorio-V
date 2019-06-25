package com.labv.parcial1Allan.config;

import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@org.springframework.context.annotation.Configuration
@EnableAsync
public class AsyncConfiguration {

    //@Value("${executor.maxPoolSize: 50}")  // busca el valor en el properties
    //---> si no encuentra nada en el properties, el valor va a ser 50
    private  Integer MAX_POOL_SIZE = 50;

    //@Value("${executor.queueCapacity: 100}")
    private  Integer QUEUE_CAPACITY = 100;

    @Bean("Executor")
    public Executor getAsyncExecutor (){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        executor.initialize();
        return executor;
    }
}
