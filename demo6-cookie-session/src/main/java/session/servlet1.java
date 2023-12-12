package session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * httpsession是一种将更多信息保留在服务端的技术，为每一个客户端开辟一个内存空间，客户端使用自己的session
 *      用户第一次请求没有cookie，服务器会创建一个session对象，并将sessionID存放到cookie中并返回给客户端。再次请求的时候就可以通过sessionID来判断是否使用同一个session对象
 *      session对象的默认存放时间为30分钟，只要重新使用则充值时间，
 *          1)在web-xml中设置session-config => session-timeout
 *          2)在api中设置session.setMaxInactiveInterval()
 */
@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接受请求中username对象
        String username = req.getParameter("username");
        // 获得session对象
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(120);        // 设置session的存活时间
        // 判断请求中有没有一个特殊的cookie JSSESSIONID 值 *** （不需要我们操作 getSession方法自动执行下面的操作）
            // 有
                // 根据JESSIONID找对应的session对象
                    // 找到了返回之前的session
                    // 没有就创建
            // 没有
                // 创建一个新的session返回，并且向response对象中存放一个JESSIONID 的cookie
        System.out.println(session.getId());
        System.out.println(session.isNew());
        // 将username存入session
        session.setAttribute("username", username);
        // 客户端相应信息
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("成功");
    }
}
