package gdut.QG.QGFish.servlet;

import gdut.QG.QGFish.domain.Good;
import gdut.QG.QGFish.domain.User;
import gdut.QG.QGFish.service.GoodService;
import gdut.QG.QGFish.service.UserService;
import gdut.QG.QGFish.service.impl.GoodServiceImpl;
import gdut.QG.QGFish.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/homeSelectServlet")
public class HomeSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        GoodService goodService = new GoodServiceImpl();

        Map<String, String[]> condition = request.getParameterMap();
        if (condition.get("name") == null) {
            Map<String, String[]> map = new HashMap<String, String[]>();
            map.put("name",new String[]{""});
            map.put("order",new String[]{"price"});
            map.put("orderValue",new String[]{"desc"});
            condition = map;
        }
        List<Good> goods = goodService.findByConditionMap(condition,false);

        response.setCharacterEncoding("utf-8");
        request.setAttribute("goods",goods);
        request.setAttribute("condition",condition);
        request.getRequestDispatcher("/home.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
