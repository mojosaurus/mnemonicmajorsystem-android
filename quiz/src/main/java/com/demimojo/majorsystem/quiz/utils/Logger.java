package com.demimojo.majorsystem.quiz.utils;

import android.util.Log;

/**
 * Created by mojosaurus on 13/9/14.
 */
public class Logger {
    public static void i(String component, String message) {
        Log.i(component, message);
    }
    public static void d(String component, String message) {
        Log.d(component, message);
    }
    public static void e(String component, String message) {
        Log.e(component, message);
    }
}
