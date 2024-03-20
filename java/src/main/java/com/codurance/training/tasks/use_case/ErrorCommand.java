package com.codurance.training.tasks.use_case;

import com.codurance.training.tasks.io.Output;

public class ErrorCommand {

    public void error(String command) {
        Output out = Output.getInstance();
        out.outputPrint("I don't know what the command \"%s\" is.");
        out.outputPrint(command);
        out.outputPrintLn();
    }
}