package code.controller;

import code.model.BenhAn;
import code.model.BenhNhan;
import code.service.impl.BenhAnSerImpl;
import code.service.impl.BenhNhanSerImpl;
import code.service.inter.BenhAnSerInter;
import code.service.inter.BenhNhanSerInter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/benh")
public class BenhController extends HttpServlet {
    private BenhAnSerInter benhan=new BenhAnSerImpl();
    private BenhNhanSerInter benhnhan=new BenhNhanSerImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if(action==null)
        {
            action=" ";
        }
        switch (action)
        {
            case "edit":
                doeditt(req,resp);
                break;
        }
    }

    private void doeditt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String benhan2=req.getParameter("benhan");
        BenhAn benhAn2=benhan.findBenhAnById(benhan2);
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String in = req.getParameter("in");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date enterIn = null;
        try {
            enterIn =  format.parse(in);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String out = req.getParameter("in");
        SimpleDateFormat formatOut = new SimpleDateFormat("dd/MM/yyyy");
        Date outer = null;
        try {
            outer =  formatOut.parse(out);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String lydo=req.getParameter("lydo");
        BenhNhan benhNhan12=new BenhNhan(id,name,outer,outer,lydo,benhAn2);
        benhnhan.update(benhNhan12);
        listbenh(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "delete" :
                dodeletee(req,resp);
                break;
            case "doedit":
                doedit(req,resp);
                break;
            default:
                listbenh(req, resp);
                break;
        }
    }

    private void doedit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BenhAn> benhAns = benhan.findAll();
        req.setAttribute("benhAn", benhAns);
        String id = req.getParameter("id");
        BenhNhan existingbenhnhan=benhnhan.findById(id);
        req.setAttribute("benhnhan", existingbenhnhan);
        RequestDispatcher dispatcher = req.getRequestDispatcher("web/edit.jsp");
        dispatcher.forward(req, resp);
    }

    private void dodeletee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id =req.getParameter("id");
        benhnhan.delete(id);
        List<BenhNhan> benhNhans = benhnhan.FindAll();
        req.setAttribute("benh", benhNhans);
        RequestDispatcher dispatcher = req.getRequestDispatcher("web/list.jsp");
        dispatcher.forward(req, resp);
    }

    private void listbenh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BenhNhan>benhNhans=benhnhan.FindAll();
        req.setAttribute("benh",benhNhans);
        RequestDispatcher dispatcher = req.getRequestDispatcher("web/list.jsp");
        dispatcher.forward(req, resp);
    }


}
