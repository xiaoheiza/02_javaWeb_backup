package servletContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * URI：统一资源标识符 interface URI{}              资源定位的要求和规范          /demo3/servlet04
 * URL：统一资源定位符 class URL implements URI{}   具体的某个资源的具体路径      http://localhost:8080/demo3/servlet04
 */
@WebServlet("/servlet04")
public class Servlet04_HttpServletRequest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 行相关 GET/POS  uri http/1.1
        System.out.println(req.getMethod());        // 获取请求方式
        System.out.println(req.getScheme());        // 获取请求协议
        System.out.println(req.getProtocol());      // 获取请求协议及版本号
        System.out.println(req.getRequestURI());    // 获取请求的uri  项目内的资源路径
        System.out.println(req.getRequestURL());    // 获取请求的url  项目内资源的完整路径
        System.out.println(req.getLocalPort());     // 本应用容器的端口号
        System.out.println(req.getServerPort());    // 客户端发请求时使用的端口号
        System.out.println(req.getRemotePort());    // 客户端软件的端口号

        // 头相关 key:value key:value ... ...
        System.out.println("Accept" + req.getHeader("Accept"));
        // 获取所有的请求头的名字
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String nextElement = headerNames.nextElement();
            System.out.println(nextElement + ": " + req.getHeader(nextElement));
        }

        // 获取请求参数 下一节

    }
}
