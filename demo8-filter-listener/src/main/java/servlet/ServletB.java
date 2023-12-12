package servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 监听器监听的是域对象身上发生的事
 *  对象的创建
 *  对象的销毁
 *  数据的增加
 *  数据的修改
 *  数据的删除
 */
@WebServlet("/servletB")
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 修改应用域中数据
        ServletContext application = this.getServletContext();
        application.setAttribute("keya", "valuexx");
    }
}
