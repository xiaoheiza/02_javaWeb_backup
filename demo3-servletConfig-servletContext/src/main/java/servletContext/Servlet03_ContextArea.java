package servletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ServletContext 代表应用，也叫应用域，是webapp中最大的域，可以在本应用内实现数据的共享和传递(Webapp中有三大作用域：应用域、会话域、请求域)
 * 三大域对象都有的三个API
 *    1、void setAttribute(String key, Object value)     设置域中的数据
 *    2、Object getAttribute(String key)                 获得域中数据
 *    3、void removeAttribute(String key)                移除数据
 */
@WebServlet("/servlet5")
public class Servlet03_ContextArea extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        /*servletContext.setAttribute("ka", "va");
        servletContext.setAttribute("ka", "vaa");*/

        System.out.println(servletContext.getAttribute("ka"));
        servletContext.removeAttribute("ka");
    }
}
