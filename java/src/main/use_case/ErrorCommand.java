package main.use_case;

import main.io.*;

public class ErrorCommand {

    public void error(String command) {
        Output out = Output.getInstance();
        out.outputPrint("I don't know what the command \"%s\" is.");
        out.outputPrint(command);
        out.outputPrintLn();
    }
}