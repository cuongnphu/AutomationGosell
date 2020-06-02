package com.gosell.pageobject.utils;


public class GenericUtils {

    /**
     * Thread to sleep timeout (milliseconds)
     * @param timeOut
     */
    public static void wait(int timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
