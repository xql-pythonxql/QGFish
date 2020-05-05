package gdut.QG.QGFish.servlet;

import gdut.QG.QGFish.domain.User;
import gdut.QG.QGFish.service.UserService;
import gdut.QG.QGFish.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/userServlet")
public class UserUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Map<String, String[]> map = request.getParameterMap();
        UserService userService = new UserServiceImpl();
        User user = userService.updateInfo(map);

        request.setAttribute("user",user);
        request.getRequestDispatcher("/home.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
