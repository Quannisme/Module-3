package mvc.controller;

import mvc.model.Product;
import mvc.service.ProductService;
import mvc.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet (urlPatterns = "/product")
public class ProductController  extends HttpServlet {
    private ProductService productService=new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if(action==null)
        {
            action="list";
        }
        switch (action)
        {
            case "list":
                viewList(req,resp);
                break;
            case "delete":
                viewDelete(req,resp);
                break;
            case "create":
                viewCreate(req,resp);
                break;
            case "findName":
                viewFindName(req,resp);
                break;
            case "update":
                viewUpdate(req,resp);
                break;
            case "delete2":
                viewDelete2(req,resp);
                break;
        }
    }

    private void viewDelete2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        productService.delete(name);
       viewList(req, resp);
//        req.getRequestDispatcher("/WEB-INF/view/product/List.jsp").forward(req,resp);
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/product/Update.jsp").forward(req,resp);
    }


    private void viewFindName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/product/FindName.jsp").forward(req,resp);
    }

    private void viewCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/product/Create.jsp").forward(req,resp);
    }

    private void viewDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/product/Delete.jsp").forward(req,resp);
    }

    private void viewList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product>products=productService.display();
        req.setAttribute("products",products);
        req.getRequestDispatcher("/WEB-INF/view/product/List.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =req.getParameter("action");
        if (action==null)
        {
            resp.sendRedirect("/product?action=list");
            return;
        }
        switch (action){
            case "create":
                docreate(req,resp);
                break;
            case "delete2":
                testDelete(req, resp);
            case "delete":
                dodelete(req,resp);
                break;
            case "findName":
                dofindName(req,resp);
                break;
            case "update":
                doupdate(req,resp);
                break;
        }
    }

    private void testDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        productService.delete(name);
        viewList(req, resp);
    }

    private void doupdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        int price=Integer.parseInt(req.getParameter("price"));
        String describe=req.getParameter("describe");
        String producer=req.getParameter("producer");
        Product product1=new Product(id,name,price,describe,producer);
        if (productService.edit(product1)==true)
        {
            resp.sendRedirect("/product?action=list");
        }else
        {
            resp.sendRedirect("/product?action=list");
        }

    }

    private void dofindName(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name=req.getParameter("name");
        Product product=productService.findName(name);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/WEB-INF/view/product/InforProduct.jsp").forward(req,resp);
    }

    private void dodelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name=req.getParameter("name");
        Product product= productService.findName(name);
        productService.delete(name);
        resp.sendRedirect("/product?action=list");
    }

    private void docreate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        int price=Integer.parseInt(req.getParameter("price"));
        String describe=req.getParameter("describe");
        String producer=req.getParameter("producer");
        Product product=new Product(id,name,price,describe,producer);
        productService.add(product);
        resp.sendRedirect("/product?action=list");
    }
}
