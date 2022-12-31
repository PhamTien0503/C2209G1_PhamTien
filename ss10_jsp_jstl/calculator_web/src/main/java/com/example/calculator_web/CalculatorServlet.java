package com.example.calculator_web;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "calculator servlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    float result;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int first_operand=Integer.parseInt(request.getParameter("first operand"));
        String operator=request.getParameter("Operator");
        int second_operand=Integer.parseInt(request.getParameter("second operand"));

        try {
            float result=Calculator.calculate(first_operand,second_operand,operator);
            PrintWriter printWriter= response.getWriter();
            printWriter.println("<html>");
            printWriter.println("<h1> Result: <h1>");
            printWriter.println("<h1><h1>" +result);
            printWriter.println("</html>");
        }
        catch (ArithmeticException e) {
            PrintWriter printWriter= response.getWriter();
            printWriter.println("<html>");
            printWriter.println("<h1> Result: <h1>");
            printWriter.println("<h1><h1>" +e.getMessage() + " Please input second operand again");
            printWriter.println("</html>");
        }

    }
}