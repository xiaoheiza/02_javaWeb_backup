package garbledCode;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * tomcat10中响应体默认编码字符集默认为UTF-8，而浏览器如果不设置则默认采用系统编码方式，windows中默认为GBK
 *      1、设置响应体编码方式resp.setCharacterEncoding("GBK")   （不推荐，后端适应前端不行）
 *      2、告诉客户端使用指定字符集进行编码 resp.setContentType("text/html;charset=UTF-8");
 *          需要明确响应体的编码，然后再设置Content-Type
 *      推荐两个同时进行设置，保证在不同版本的tomcat中不出现乱码
 */
@WebServlet("/servletC")
public class ResponseGarbled extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应体使用UTF-8编码
        resp.setCharacterEncoding("UTF-8");
        // 设置Content-Type响应头，告诉客户端用UTF-8解码
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("你好，hello");
    }
}
