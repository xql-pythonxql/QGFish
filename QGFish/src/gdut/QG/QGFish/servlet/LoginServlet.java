package gdut.QG.QGFish.servlet;

import gdut.QG.QGFish.domain.Manager;
import gdut.QG.QGFish.domain.ResponseInfo;
import gdut.QG.QGFish.domain.User;
import gdut.QG.QGFish.service.ManagerService;
import gdut.QG.QGFish.service.impl.ManagerServiceImpl;
import gdut.QG.QGFish.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String method = request.getParameter("method");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        if ("user".equals(method)) {
            User user = new UserServiceImpl().login(username,password);
            if (user != null) {
                session.setAttribute("user",user);
                response.sendRedirect(request.getContextPath()+"/homeSelectServlet");
                return;
            }
        } else if ("manager".equals(method)) {
            Manager manager = (Manager) new ManagerServiceImpl().login(username, password).getData();
            if (manager != null) {
                session.setAttribute("manager",manager);
                response.sendRedirect(request.getContextPath()+"/managerServlet");
                return;
            }
        }

        //登录失败
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("<script>window.alert('账号或密码错误！');window.history.back();</script>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
