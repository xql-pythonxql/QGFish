package gdut.QG.QGFish.servlet;

import gdut.QG.QGFish.domain.ResponseInfo;
import gdut.QG.QGFish.service.GoodService;
import gdut.QG.QGFish.service.impl.GoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/addGoodServlet")
public class AddGoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();

        Map<String, String[]> map = request.getParameterMap();
        GoodService goodService = new GoodServiceImpl();
        ResponseInfo responseInfo = goodService.addExceptImg(map);

        request.setAttribute("responseInfo",responseInfo);
        request.getRequestDispatcher(uri).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
