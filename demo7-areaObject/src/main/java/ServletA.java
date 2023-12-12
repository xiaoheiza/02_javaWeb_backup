import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * 域对象：用于存储数据和传递数据的对象，不同的域对象代表不同的域，共享数据的范围不同
 *      1）请求域对象为HttpServletRequest，传递数据的范围为一次请求之内及请求转发。注意：请求转发也可以
 *      2）会话域对象为HttpSession，传递数据的范围为一次会话之内，可以跨多个请求
 *      3）应用域对象为ServletContext，传递数据的范围为本应用之内，可以跨多个会话
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 向请求域存放数据
        req.setAttribute("request", "requestMessage");
        // 向会话域存放数据
        HttpSession session = req.getSession();
        session.setAttribute("session", "sessionMessage");
        // 向应用域存放数据
        ServletContext application = req.getServletContext();
        application.setAttribute("application", "applicationMessage");

        // 获取请求域数据
        String reqMessage = (String) req.getAttribute("request");
        System.out.println("请求域：" + reqMessage);

        req.getRequestDispatcher("servletB").forward(req, resp);
    }
}
