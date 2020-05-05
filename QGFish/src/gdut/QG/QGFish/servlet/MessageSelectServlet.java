package gdut.QG.QGFish.servlet;

import gdut.QG.QGFish.domain.ResponseInfo;
import gdut.QG.QGFish.service.MessageService;
import gdut.QG.QGFish.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/messageSelectServlet")
public class MessageSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();

        int id = Integer.parseInt(request.getParameter("id"));
        MessageService messageService = new MessageServiceImpl();
        ResponseInfo responseInfo = messageService.selectByUserId("to",id);

        request.setAttribute("responseInFo",responseInfo);
        request.getRequestDispatcher(uri).forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
