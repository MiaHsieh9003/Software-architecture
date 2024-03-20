package com.codurance.training.tasks.use_case;


import com.codurance.training.tasks.io.Output;


public class HelpCommand {
    public void help() {
        Output out = Output.getInstance();
        out.outputPrintLn("Commands:");
        out.outputPrintLn("  show");
        out.outputPrintLn("  add project <project name>");
        out.outputPrintLn("  add task <project name> <task description>");
        out.outputPrintLn("  check <task ID>");
        out.outputPrintLn("  uncheck <task ID>");
        out.outputPrintLn();
    }
}
