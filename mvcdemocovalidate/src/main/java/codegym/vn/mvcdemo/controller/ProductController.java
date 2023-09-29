package codegym.vn.mvcdemo.controller;

import codegym.vn.mvcdemo.model.Category;
import codegym.vn.mvcdemo.model.Product;
import codegym.vn.mvcdemo.service.CategoryService;
import codegym.vn.mvcdemo.service.CategoryServiceImpl;
import codegym.vn.mvcdemo.service.ProductService;
import codegym.vn.mvcdemo.service.ProductServiceImpl;
import codegym.vn.mvcdemo.validate.ProductValidate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/product")
public class ProductController extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();
    private ProductValidate validate = new ProductValidate();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                viewList(req, resp);
                break;
            case "detail":
                viewDetail(req, resp);
                break;
            case "create":
                viewCreate(req, resp);
                break;
            case "createMulti":
                viewCreateMulti(req, resp);
                break;
            case "search":
                doSearch(req, resp);
                break;
            default:

        }
    }

    private void doSearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("productName");
        List<Product> products = productService.searchByName(name);
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/views/product/list.jsp")
                .forward(req, resp);
    }

    private void viewCreateMulti(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/WEB-INF/views/product/createMultiple.jsp")
                .forward(req, resp);
    }

    private void viewCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/WEB-INF/views/product/create.jsp")
                .forward(req, resp);
    }

    private void viewDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/WEB-INF/views/product/detail.jsp")
                .forward(req, resp);
    }

    private void viewList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageAsString = req.getParameter("page");
        int page = pageAsString == null ? 1 : Integer.parseInt(pageAsString);
        int record = 5;

        List<Product> products = productService.findAllWithPaging(page, record);
        int totalRecord = productService.countAllProduct();
        int totalPages = totalRecord % record == 0? totalRecord/record : totalRecord/record + 1;
        int[] pages = new int[totalPages];
        for (int i = 1; i <= totalPages; i++) {
            pages[i-1] = i;
        }

        req.setAttribute("pages", pages);
        req.setAttribute("currentPage", page);
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/views/product/list.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            resp.sendRedirect("/product?action=list");
            return;
        }

        switch (action) {
            case "create":
                doCreate(req, resp);
                break;
            case "createMulti":
                doCreateMulti(req, resp);
                break;
            case "deleteAll":
                doDeleteAll(req, resp);
                break;
            default:
        }
    }

    private void doDeleteAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] ids = req.getParameterValues("ids");
        productService.deleteAllByIds(ids);
        resp.sendRedirect("/product?action=list");
    }

    private void doCreateMulti(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Product> products = new ArrayList<>();
        List<Category> categories = categoryService.findAll();
        for (int i = 1; i <= 3; i++) {
            int id = Integer.parseInt(req.getParameter("id" + i));
            String name = req.getParameter("name" + i);
            int quantity = Integer.parseInt(req.getParameter("quantity" + i));
            int price = Integer.parseInt(req.getParameter("price" + i));
            String date = req.getParameter("dateRelease" + i);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dateRelease = null;
            try {
                dateRelease = format.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            int categoryId = Integer.parseInt(req.getParameter("categoryId" + i));
            Category category = categories.stream().filter(c -> c.getId() == categoryId).findAny().orElse(null);
            Product product = new Product(id, name, quantity, price, dateRelease, category);
            products.add(product);
        }

        productService.addList(products);
        resp.sendRedirect("/product?action=list");
    }

    private void doCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        boolean isValid = true;
        // Get and validate ID
        String idAsString = req.getParameter("id");
        String errorId = validate.validateId(idAsString);
        int id = 0;
        if (errorId != null) {
            isValid = false;
            req.setAttribute("errorId", errorId);
        } else {
            id = Integer.parseInt(idAsString);
        }
        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int price = Integer.parseInt(req.getParameter("price"));
        String date = req.getParameter("dateRelease");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        Date dateRelease = null;
        try {
            dateRelease = format.parse(date);
        } catch (ParseException e) {
            isValid = false;
            req.setAttribute("errorDateRelease", "Sai định dạng ngày hoặc ngày không tồn tại");
        }
        if (isValid) {
            int categoryId = Integer.parseInt(req.getParameter("categoryId"));
            Category category = categoryService.findById(categoryId);
            Product product = new Product(id, name, quantity, price, dateRelease, category);
            productService.add(product);
            resp.sendRedirect("/product?action=list");
        } else {
            List<Category> categories = categoryService.findAll();
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("/WEB-INF/views/product/create.jsp")
                    .forward(req, resp);
        }
    }
}
