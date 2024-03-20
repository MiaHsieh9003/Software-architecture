package com.codurance.training.tasks.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Input {
    private static BufferedReader in;
    private static Input _instance;

    public static Input getInstance(){
        if(_instance == null){
            in = new BufferedReader(new InputStreamReader(System.in));
            _instance = new Input();
        }
        return _instance;
    }
}
