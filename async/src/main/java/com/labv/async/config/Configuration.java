package com.labv.async.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@org.springframework.context.annotation.Configuration
@EnableAsync
public class Configuration {

    @Value("${executor.maxPoolSize: 50}")  // busca el valor en el properties
    //---> si no encuentra nada en el properties, el valor va a ser 50
    private  Integer MAX_POOL_SIZE;

    @Value("${executor.queueCapacity: 100}")
    private  Integer QUEUE_CAPACITY;

    @Bean("Executor") // http://javaparanulos.blogspot.com/2012/11/thread-pools-en-java.html
    Executor getAsyncExecutor (){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // https://unpocodejava.com/2010/03/03/implementacion-basica-de-pool-de-hilos/
        executor.setCorePoolSize(2); // para ejecutar 2 a la vez ?
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        executor.initialize();
        return executor;
    }
}
