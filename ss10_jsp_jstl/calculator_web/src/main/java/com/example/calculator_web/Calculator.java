package com.example.calculator_web;

public class Calculator {
    public static float calculate(int a, int b, String c) {
        float result = 0;
        switch (c) {
            case "Addition":
                result = a + b;
                break;
            case "Subtraction":
                result = a - b;
                break;
            case "Multiplication":
                result = a * b;
                break;
            case "Division":
                result = a / b;
                break;
        }
        return result;
    }
}
