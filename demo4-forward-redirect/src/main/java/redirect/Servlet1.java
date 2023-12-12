package redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 *  重定向
 *      1、通过HttpServletResponse对象实现
 *      2、响应重定向是在服务端提示下的。客户端的行为
 *      3、客户端的地址栏是变化的，客户端至少发送了两次请求
 *      4、请求产生了多次，后端会有多个request对象，也就是请求参数不能继续自动传递
 *      5、目标资源可以是试图资源
 *      6、目标不能是WEB-INF下面的资源
 *      7、目标可以是外部资源
 */
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet1执行了");
        // 响应重定向
        // 设置响应状态码为302  同时设置location响应头(两个同时设置才能生效
//        resp.setStatus(302);
//        resp.setHeader("location", "servlet2");
//        resp.sendRedirect("servlet2");  // 相当于上面两个
//        resp.sendRedirect("a.html");  // 相当于上面两个
        resp.sendRedirect("https://www.baidu.com");  // 相当于上面两个
    }
}
