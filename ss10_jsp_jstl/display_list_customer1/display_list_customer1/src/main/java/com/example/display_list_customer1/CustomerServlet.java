package com.example.display_list_customer1;

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
        customerList.add(new Customer("Văn Tiến Sỹ","1/1/2011",  "Đà Nẵng","https://ca.slack-edge.com/TEBPXS5HQ-U04468F1WHL-91edcff6f3ba-512"));
        customerList.add(new Customer("Trương Thị Thanh Thâo","1/1/2011",  "Đà Nẵng","https://scontent.fsgn2-8.fna.fbcdn.net/v/t1.6435-9/166908702_4165493446904743_8628602873159873514_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=UwfSpQs5xxYAX-bdA_3&_nc_ht=scontent.fsgn2-8.fna&oh=00_AfCboWKh6HgibIq23BzussM2rU_JhNTOtbWKo3oEMF0IJw&oe=63D6327D"));
        customerList.add(new Customer("Trần Văn Anh Quan","1/1/2011",  "Đà Nẵng","https://scontent.fsgn2-6.fna.fbcdn.net/v/t39.30808-6/240978705_580770582951959_608338121210517866_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=CxJeUhg-1GkAX9PnkwM&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfAqySU-bOo7BS6L3o8kNgL3zGQPI9qneoxUzPxiJne4Bw&oe=63B34704"));
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}