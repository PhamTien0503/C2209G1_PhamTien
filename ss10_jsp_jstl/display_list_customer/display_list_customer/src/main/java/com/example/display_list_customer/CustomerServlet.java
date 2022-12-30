package com.example.display_list_customer;

import model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "customerServlet", value = "/customer")

public class CustomerServlet extends HttpServlet {
    public static List<Customer> customerList=new ArrayList<>();
    static {
        customerList.add(new Customer("sỹ","1/1/2011",  "Đà Nẵng","https://ca.slack-edge.com/TEBPXS5HQ-U04468F1WHL-91edcff6f3ba-512"));
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       request.setAttribute("customerList",customerList);
       request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}