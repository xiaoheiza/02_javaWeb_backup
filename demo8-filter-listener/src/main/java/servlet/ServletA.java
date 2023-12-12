package servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import listener.MyApplicationListener;
import listener.SessionBindingListener;

import java.io.IOException;

/**
 * 监听器监听的是域对象身上发生的事
 *  对象的创建
 *  对象的销毁
 *  数据的增加
 *  数据的修改
 *  数据的删除
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 应用域中放入数据
        ServletContext application = this.getServletContext();
        application.setAttribute("keya", "valuea");

        HttpSession session = req.getSession();

        SessionBindingListener sb = new SessionBindingListener();
        session.setAttribute("sb1", sb);

        MyApplicationListener myApplicationListener = new MyApplicationListener();
        session.setAttribute("lis", myApplicationListener);
        session.invalidate(); // 手动销毁session
    }
}
