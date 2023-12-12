package garbledCode;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * tomcat个别版本有可能在get方式提交中文参数可能会乱码
 *  1、tomcat进行解码目前版本默认用UTF-8进行解码，修改：
 *  2、在server.xml中Connector标签中，添加URIEncoding="UTF-8"，仅设置的是请求头的解码方式
 */
@WebServlet("/user")
public class GetGarbled extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("username"));
    }
}
