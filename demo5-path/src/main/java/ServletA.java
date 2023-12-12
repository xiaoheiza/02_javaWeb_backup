import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 引入图片
 *     1、相对路径
 *         以当前资源的所在位置为出发点去找目标资源
 *         语法：不以/开头，
 *         问题：如果发生了请求转发，由于前端路径不变，因此会在请求的资源路径后面拼接相对路径（以客户端来判断），导致无法找到资源
 *              当前资源路径会影响访问的资源
 *     2、绝对路径
 *         始终以固定路径作为出发点寻找目标资源，和当前资源的所在路径没有关系
 *         语法：以/开头
 *              不同项目，固定的路径出发点不一致 始终以http://localhost:8080/ 触发
 *              1)html中可以通过head>base>href属性，定义相对路径公共前缀，将相对路径转换为绝对路径
 *                当前页面中，素有不加任何修饰的相对路径前，会自动补充href中的内容，将相对路径变为绝对路径，具体参见index.html(但解决方式不完美)
 *              2)直接在tomcat中去掉上下文..........
 */
@WebServlet("/x/y/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletA");
        // 重定向到servletB
        /*
        * 1、相对路径写法
        *   在当前路径后面拼接相对路径  x/y/servletA取x/y 再拼接servletB =》 x/y/servletB 导致无法找到
        * 2、绝对路径写法
        *   固定的路径出发点不一致 始终以http://localhost:8080/
        *
        * */
//        ServletContext servletContext = getServletContext();
//        String contextPath = servletContext.getContextPath();
//        resp.sendRedirect(contextPath + "/servletB");
//        resp.sendRedirect("servletB");

        // 请求转发到servletB
        /*
        * 1、相对路径写法
        *   和重定向和前端一样
        * 2、绝对路径
        *   不需要添加项目的上下文
        *   请求转发的/ 代表的是   http://localhost:8080/demo5
        * */
        req.getRequestDispatcher("/servletB").forward(req, resp);

    }
}
