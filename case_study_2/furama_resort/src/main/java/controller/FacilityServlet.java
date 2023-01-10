package controller;

import model.Facility;
import service.IFacilityService;
import service.IFacilityTypeService;
import service.IRentTypeService;
import service.iplm.FacilityService;
import service.iplm.FacilityTypeService;
import service.iplm.RentTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.internal.objects.NativeString.search;


@WebServlet(name = "FacilityServlet", value = "/facility")
public class FacilityServlet extends HttpServlet {
    private final IFacilityService facilityService=new FacilityService();
    private final IFacilityTypeService facilityTypeService=new FacilityTypeService();
    private final IRentTypeService rentTypeService=new RentTypeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
            case "edit":
                showFormEdit(request, response);
            case "search":
                search(request, response);
            default:
                showList(request, response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Facility>facilityList=facilityService.findAll();
            Map<Integer,String> facilityTypeMap=facilityTypeService.findAll();
            Map<Integer,String>rentTypeMap=rentTypeService.findAll();
            request.setAttribute("facilityList",facilityList);
            request.setAttribute("facilityTypeMap",facilityTypeMap);
            request.setAttribute("rentTypeMap",rentTypeMap);
            request.getRequestDispatcher("view/facility/list.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
