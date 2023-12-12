package session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @description:
 * @author：xiaozheng
 * @date: 20
 */
@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获得session对象
        HttpSession session = req.getSession();
        System.out.println(session.isNew());
        // 读取session中存储的用户名
        System.out.println(session.getAttribute("username"));
    }
}
