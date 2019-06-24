package com.labv.async.service;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

@org.springframework.stereotype.Service
public class Service1 {
    @Async("Executor") // --->  habilita el metodo a ser asincrono
    public CompletableFuture<Integer> metodo1 (){
        try {
            Thread.sleep(7000);
        } catch (Exception e){
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(10);
    }
    @Async("Executor")
    public CompletableFuture<Integer> metodo2 (){
        try {
            Thread.sleep(4500);
        } catch (Exception e){
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(5);
    }
	/* al tratarse de metodos asincronos, el tiempo de respuesta en el postman deberia ser
	 el del thread con mas tiempo de sleep (7000 en este caso), si el tiempo de respuesta es
	 la suma de ambos (7000 + 4500) los metodos no estan siendo asincronos */
}
