package main.use_case;

import main.io.Output;

import java.io.PrintWriter;

public class HelpCommand {
//    private Output out;

//    public HelpCommand(PrintWriter out ){
//        this.out = out;
//    }
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
