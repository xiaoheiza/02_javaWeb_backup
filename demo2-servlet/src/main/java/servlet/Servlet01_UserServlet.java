package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * servlet 开发流程
 *  1、创建web项目，同时将tomcat添加到项目依赖
 *  2、重写service方法 service(HttpServletRequest req, HttpServletResponse resp)
 *  3、在service方法中，定义业务处理代码
 *  4、在web.xml中配置servlet对应的请求映射路径
 *
 * servlet-api.jar导入问题
 *  1、按道理来说应该在maven中导入，但是我们通过project structure添加了的tomcat，其中携带了servlet-api.jar
 *  2、tomcat中servlet-api.jar在所有的项目中是共用的，范围为provided（编码时需要，构建的时候不需要）
 * content-type响应头的问题
 *  MIME类型响应头   媒体类型、文件类型、响应的数据类型
 *  MIME类型用于告诉客户端响应的数据是什么类型的数据，客户端根据此类型决定以什么方式来解析数据，默认为html类型
 *  在tomcat中的conf/web.xml中记录了几乎所有文件类型的MIME类型，会根据文件的拓展名来进行设置返回的content-type
 *  由于java文件没有响应的拓展名的mapping，因此如果不自己设置，默认会为content-type，并且返回的HttpServletResponse中没有content-type字段
 *
 *
 */

public class Servlet01_UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 从request对象中获取请求中的任何信息（username参数）
        String username = req.getParameter("username"); // 根据参数名获取参数值，无论是在url中还是在请求体中

        // 2 处理业务代码

        String info = "<h1>YES</h1>";
        if ("atguigu".equals(username)) {
            info = "<h1>NO</h1>";
        }
        // 3 将要响应的数据放入response
        // 应该设置content-type响应头，由于太重要因此单独有一个方法
        //resp.setHeader("Content-Type", "text/javascript");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();  // 该方法返回的是一个向响应体中打印字符串的 打印流
        writer.write(info);
    }
}
