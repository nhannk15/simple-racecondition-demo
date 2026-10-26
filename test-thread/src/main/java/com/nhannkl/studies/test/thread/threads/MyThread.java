/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhannkl.studies.test.thread.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhann
 */
public class MyThread extends Thread {

    public static long countThread = 0;

    @Override
    public void run() {
        try {
//            System.out.println("Inside each thread...");
            Thread.sleep(100);
            countThread++;
            System.out.println("Set count to: " + countThread);

        } catch (InterruptedException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
