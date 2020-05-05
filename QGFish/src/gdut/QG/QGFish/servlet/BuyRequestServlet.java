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

@WebServlet("/buyServlet")
public class BuyRequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();

        int buyerId = Integer.parseInt(request.getParameter("buyerId"));
        int goodId = Integer.parseInt(request.getParameter("goodId"));
        int count = Integer.parseInt(request.getParameter("count"));

        GoodService goodService = new GoodServiceImpl();
        ResponseInfo responseInfo = goodService.buy(buyerId, goodId, count);

        request.setAttribute("responseInFo",responseInfo);
        request.getRequestDispatcher(uri).forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
