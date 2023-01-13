package controller;

import model.Employee;
import service.IEmployeeService;
import service.IPositionService;
import service.iplm.EmployeeService;
import service.iplm.PositionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService employeeService=new EmployeeService();
    IPositionService positionService=new PositionService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null) {
            action="";
        }
        switch (action){
            case "search":
                search(request,response);
                break;
            case "create":
                showFormCreate(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        Map<Integer,String> positionMap=positionService.findAll();
        Set<Integer> positionIdSet=positionMap.keySet();
        request.setAttribute("positionIdSet",positionIdSet);
        request.setAttribute("positionMap",positionMap);
        try {
            request.getRequestDispatcher("/view/employee/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String id=request.getParameter("positionId");
        List<Employee>employeeList=employeeService.search(name,id);
        request.setAttribute("employeeList",employeeList);
        Map<Integer, String>positionMap=positionService.findAll();
        Set<Integer> positionIdSet=positionMap.keySet();
        request.setAttribute("positionMap",positionMap);
        request.setAttribute("positionIdSet",positionIdSet);
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee>employeeList=employeeService.findAll();
        Map<Integer,String> positionMap=positionService.findAll();
        Set<Integer> positionIdSet=positionMap.keySet();
        request.setAttribute("positionIdSet",positionIdSet);
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("positionMap",positionMap);
        try {
            request.getRequestDispatcher("/view/employee/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                delete(request, response);
                break;
            case "save":
                save(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String dateOfBirth=request.getParameter("dateOfBirth");
        boolean gender=Boolean.parseBoolean(request.getParameter("gender"));
        int positionId=Integer.parseInt(request.getParameter("positionId"));
        Employee employee=new Employee(name,dateOfBirth,gender,positionId);
        boolean check= employeeService.save(employee);
        String mess="save success !!!";
        if (!check){
            mess="save failed";
        }
        request.setAttribute("mess",mess);
        showList(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
            int id=Integer.parseInt(request.getParameter("id"));
            boolean check=employeeService.delete(id);
            String mess="delete success !!!";
            if (!check){
                mess="delete failed";
            }
            request.setAttribute("mess",mess);
            showList(request,response);
        }
}

