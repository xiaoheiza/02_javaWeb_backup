package forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 请求转发
 *   1、请求转发时，请求和响应对象会继续传递给下一个资源
 *   2、请求的参数可以继续向下传递
 *   3、请求转发是服务器内部的行为，客户端不知道
 *   4、客户端只发送了一次请求。客户端的地址栏不变
 *   5、通过HttpServletRequest.getRequestDispatcher()实现
 *   6、目标资源可以html静态资源
 *   7、请求转发可以是WEB-INF下的资源，也是访问WEB-INF下面资源的唯一方式
 *   8、不可以去访问外部的资源
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletA 执行了");
        String money = req.getParameter("money");
        System.out.println(money);
        // 转发给servletB
        // 获取请求转发器
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("servletB");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("a.html");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/b.html");
        // 做出forward动作
        requestDispatcher.forward(req, resp);
    }
}
