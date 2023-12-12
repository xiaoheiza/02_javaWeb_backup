package garbledCode;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * tomcat个别版本有可能在post方式提交中文参数可能会乱码
 *  1、tomcat进行解码目前版本默认用UTF-8进行解码，修改：
 *  2、tomcat10默认以UTF-8对请求体进行解码，只能通过代码来进行修改
 */
@WebServlet("/user2")
public class PostGarbled extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");
        System.out.println(req.getParameter("username"));
    }
}
