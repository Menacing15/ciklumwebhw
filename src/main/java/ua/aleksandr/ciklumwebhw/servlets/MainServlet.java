package ua.aleksandr.ciklumwebhw.servlets;

import ua.aleksandr.ciklumwebhw.dao.DataBaseManager;
import ua.aleksandr.ciklumwebhw.dao.JDBCManager;
import ua.aleksandr.ciklumwebhw.service.Service;
import ua.aleksandr.ciklumwebhw.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    private Service service;

    @Override
    public void init() throws ServletException {
        DataBaseManager manager = new JDBCManager();
        service = new ServiceImpl(manager);
        service.connect();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("service", service);
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service.insert(req.getParameter("action"), req.getParameter("input"));
        resp.sendRedirect("/ciklum/hub");
    }
}
