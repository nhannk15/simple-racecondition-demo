/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.nhannkl.studies.test.thread;

import com.nhannkl.studies.test.thread.threads.MyOtherThread;
import com.nhannkl.studies.test.thread.threads.MyThread;
import java.time.LocalDateTime;

/**
 *
 * @author nhann
 */

public class TestThread {

    public static void pauseProgram() throws Exception {
        System.out.println("Inside main thread");
        Thread.sleep(100);
    }
    
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println(0);
        
        for (int i = 0; i < 60; i++) {
//            pauseProgram();
            Thread newThread = new MyOtherThread();
            newThread.start();
        }
        
        //--- It just pause the program for we to see...
        Thread.sleep(2_000);
        System.out.println(MyOtherThread.countThread);
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
