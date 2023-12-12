package cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * cookie是一种客户端会话技术，由服务器产生，存放在客户端中的一小份数据。以后每次访问均会携带这一小部分数据
 *      会话级cookie：只要浏览器不关，就一直存在
 *      持久化cookie：服务器中设置了cookie的存在时间，那么在浏览器中cookie数据就会保存到硬盘上 cookie1.setMaxAge()单位为秒
 *  cookie的提交路径
 *      默认是所有的请求都会携带cookie，但是访问不同资源时要携带不同的cookie，可以通过cookie.setPath(String path) 来设置
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建cookie
        Cookie cookie1 = new Cookie("keya", "valuea");
        Cookie cookie2 = new Cookie("keyb", "valueb");
        // 设置cookie的持久化时间
        cookie1.setMaxAge(60 * 5);
        // 设置cookie的提交路径
        cookie1.setPath("/servletB");
        // 将cookie放入到response中
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }
}
