package com.github.thisguy_cinsea.utils;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IOConsole {
    public enum AnsiColor {
        AUTO("\u001B[0m"),
        BLACK("\u001B[30m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        YELLOW("\u001B[33m"),
        BLUE("\u001B[34m"),
        PURPLE("\u001B[35m"),
        CYAN("\u001B[36m"),
        WHITE("\u001B[37m");

        private final String color;

        AnsiColor(String ansiColor) {
            this.color = ansiColor;
        }

        public String getColor() {
            return color;
        }

    }

    private final Scanner input;
    private final PrintStream output;
    private final AnsiColor ansiColor;

    public IOConsole() {
        this(AnsiColor.AUTO, System.in, System.out);
    }

    public IOConsole(AnsiColor ansiColor) {
        this(ansiColor, System.in, System.out);
    }

    public IOConsole(AnsiColor ansiColor, InputStream in, PrintStream out) {
        this.ansiColor = ansiColor;
        this.input = new Scanner(in);
        this.output = out;
    }

    public void print(String val, Object... args) {
        output.format(ansiColor.getColor().concat(val), args);
    }

    public void println(String val, Object... vals) {
        print(val + "\n", vals);
    }

    public String getStringInput(String prompt, Object... args) {
        println(prompt, args);
        return input.nextLine();
    }

    public Double getDoubleInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Double doubleInput = Double.parseDouble(stringInput);
            return doubleInput;
        } catch (NumberFormatException nfe) {
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting a numeric value!");
            return getDoubleInput(prompt, args);
        }
    }

    public Long getLongInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Long longInput = Long.parseLong(stringInput);
            return longInput;
        } catch (NumberFormatException nfe) {
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting an integer value!");
            return getLongInput(prompt, args);
        }
    }

    public Integer getIntegerInput(String prompt, Object... args) {
        return getLongInput(prompt, args).intValue();
    }
}