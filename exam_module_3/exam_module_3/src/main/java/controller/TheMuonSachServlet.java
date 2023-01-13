package controller;

import model.HocSinh;
import model.Sach;
import model.TheMuonSach;
import service.IHocSinhService;
import service.ISachService;
import service.ITheMuonSachService;
import service.iplm.HocSinhService;
import service.iplm.SachService;
import service.iplm.TheMuonSachService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TheMuonSachServlet", value = "/theMuonSach")
public class TheMuonSachServlet extends HttpServlet {
    ITheMuonSachService theMuonSachService=new TheMuonSachService();
    IHocSinhService hocSinhService=new HocSinhService();
    ISachService sachService=new SachService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "add":
                break;
            default:
                showList(request,response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<TheMuonSach> theMuonSachList=theMuonSachService.findAll();
        List<Sach>sachList=sachService.findAll();
        List<HocSinh>hocSinhList=hocSinhService.findAll();
        request.setAttribute("sachList",sachList);
        request.setAttribute("theMuonSachList",theMuonSachList);
        request.setAttribute("hocSinhList",hocSinhList);
        try {
            request.getRequestDispatcher("view/the_muon_sach/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
