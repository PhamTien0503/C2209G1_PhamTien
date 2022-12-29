package com.example.product_discount_calculator;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Calculator", value = "/display-discount")
public class ProductDiscountCalculator extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
      String description=request.getParameter("description");
      int price = Integer.parseInt(request.getParameter("price"));
      int discountPercent=Integer.parseInt(request.getParameter("discount"));
      float discount= (float) (price*discountPercent*0.01);
      float total=price-discount;
      PrintWriter printWriter=response.getWriter();
      printWriter.println("<html>");
      printWriter.println("<h4>Description : </h4>" +description);
      printWriter.println("<h4>Discount Amount: </h4>" +discount);
      printWriter.println("<h4>Discount Price: </h4>" +total);
      printWriter.println("</html>");
    }
}