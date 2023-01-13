package controller;

import model.Employee;
import service.IDivisionService;
import service.IEducationDegreeService;
import service.IEmployeeService;
import service.IPositionService;
import service.iplm.DivisionService;
import service.iplm.EducationDegreeService;
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
    IEmployeeService employeeService=new EmployeeService() ;
    IDivisionService divisionService=new DivisionService();
    IEducationDegreeService educationDegreeService=new EducationDegreeService();
    IPositionService positionService=new PositionService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null) {
            action="";
        }
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            case "search":
                search(request,response);
                break;
            default:
                showList(request,response);
                break;
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        Map<Integer, String> divisionMap=divisionService.findAll();
        Set<Integer> divisionIdSet=divisionMap.keySet();
        Map<Integer, String> educationDegreeMap=educationDegreeService.findAll();
        Set<Integer> educationDegreeIdSet=educationDegreeMap.keySet();
        Map<Integer, String>positionMap=positionService.findAll();
        Set<Integer> positionIdSet=positionMap.keySet();
        List<Employee> employeeList=employeeService.findAll();
        request.setAttribute("divisionMap",divisionMap);
        request.setAttribute("educationDegreeMap",educationDegreeMap);
        request.setAttribute("positionMap",positionMap);
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("divisionIdSet",divisionIdSet);
        request.setAttribute("educationDegreeIdSet",educationDegreeIdSet);
        request.setAttribute("positionIdSet",positionIdSet);
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        Map<Integer, String> divisionMap=divisionService.findAll();
        Set<Integer> divisionIdSet=divisionMap.keySet();
        Map<Integer, String> educationDegreeMap=educationDegreeService.findAll();
        Set<Integer> educationDegreeIdSet=educationDegreeMap.keySet();
        Map<Integer, String>positionMap=positionService.findAll();
        Set<Integer> positionIdSet=positionMap.keySet();
        request.setAttribute("divisionMap",divisionMap);
        request.setAttribute("educationDegreeMap",educationDegreeMap);
        request.setAttribute("positionMap",positionMap);
        request.setAttribute("divisionIdSet",divisionIdSet);
        request.setAttribute("educationDegreeIdSet",educationDegreeIdSet);
        request.setAttribute("positionIdSet",positionIdSet);
        try {
            request.getRequestDispatcher("view/employee/create.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null) {
            action="";
        }
        switch (action){
            case "delete":
                delete(request,response);
                break;
            default:
                showList(request,response);
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String id=request.getParameter("positionId");
        List<Employee>employeeList=employeeService.search(name,id);
        request.setAttribute("employeeList",employeeList);
        Map<Integer, String> divisionMap=divisionService.findAll();
        Set<Integer> divisionIdSet=divisionMap.keySet();
        Map<Integer, String> educationDegreeMap=educationDegreeService.findAll();
        Set<Integer> educationDegreeIdSet=educationDegreeMap.keySet();
        Map<Integer, String>positionMap=positionService.findAll();
        Set<Integer> positionIdSet=positionMap.keySet();
        request.setAttribute("divisionMap",divisionMap);
        request.setAttribute("educationDegreeMap",educationDegreeMap);
        request.setAttribute("positionMap",positionMap);
        request.setAttribute("divisionIdSet",divisionIdSet);
        request.setAttribute("educationDegreeIdSet",educationDegreeIdSet);
        request.setAttribute("positionIdSet",positionIdSet);
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        boolean check=employeeService.delete(id);
        String mess="xoa thanh cong !!!";
        if (!check){
            mess="xoa khong thanh cong";
        }
        request.setAttribute("mess",mess);
        showList(request,response);
    }
}
