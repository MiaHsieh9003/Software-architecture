package main.io;

import java.io.PrintWriter;

//singleton
public class Output {
    private static PrintWriter out;
    private static Output _instance;

    public static Output getInstance(){
        if(_instance == null){
            out = new PrintWriter(System.out);
            _instance = new Output();
        }
        return _instance;
    }
    public void outputPrint(String message){
        out.print(message);
    }
    public void outputPrintLn(){
        out.println();
    }
    public void outputPrintLn(String message){
        out.println(message);
    }
}
