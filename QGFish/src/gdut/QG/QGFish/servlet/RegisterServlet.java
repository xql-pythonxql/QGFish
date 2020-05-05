package gdut.QG.QGFish.servlet;

import gdut.QG.QGFish.domain.User;
import gdut.QG.QGFish.service.UserService;
import gdut.QG.QGFish.service.impl.UserServiceImpl;
import gdut.QG.QGFish.util.ObjectUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        User registerUser = ObjectUtils.userEncapsulation(parameterMap);
        UserService userService = new UserServiceImpl();
        boolean flag = userService.register(registerUser);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("utf-8");
        if (flag) {
            out.write("<script>window.history.back();window.alert('注册成功！');</script>");
            response.sendRedirect(request.getContextPath()+"/login.html");
        } else {
            out.write("<script>window.alert('账号已存在！');window.history.back();</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
