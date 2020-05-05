package gdut.QG.QGFish.servlet;

import gdut.QG.QGFish.domain.Good;
import gdut.QG.QGFish.service.GoodService;
import gdut.QG.QGFish.service.impl.GoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SelectPassedGoodsServlet")
public class SelectPassedGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();

        Map<String, String[]> condition = request.getParameterMap();
        if (condition.get("name") == null) {
            Map<String, String[]> map = new HashMap<String, String[]>();
            map.put("name",new String[]{""});
            map.put("choose",new String[]{"good"});
            condition = map;
        }
        GoodService goodService = new GoodServiceImpl();
        List<Good> goods = goodService.findByConditionMap(condition, true);

        request.setAttribute("goods",goods);
        request.getRequestDispatcher(uri).forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
