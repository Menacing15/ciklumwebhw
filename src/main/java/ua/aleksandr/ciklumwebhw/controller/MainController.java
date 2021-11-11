package ua.aleksandr.ciklumwebhw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.aleksandr.ciklumwebhw.service.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    Service service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(HttpServletRequest request) {
        request.getSession().setAttribute("service", service);
        service.connect();
        return "welcome";
    }

    @RequestMapping(value = "/hub", method = RequestMethod.GET)
    public String get(HttpServletRequest req) {
        setTable(req);
        return "hub";
    }

    @RequestMapping(value = "/hub", method = RequestMethod.POST)
    public String post(HttpServletRequest req) {
        service.insert(req.getParameter("action"), req.getParameter("input"));
        setTable(req);
        return "hub";
    }

    private void setTable(HttpServletRequest req) {
        List<List<String>> table = service.getTableData();
        if (table.get(0).isEmpty()) {
            req.setAttribute("table", null);
        } else {
            req.setAttribute("table", table);
        }
    }

}
