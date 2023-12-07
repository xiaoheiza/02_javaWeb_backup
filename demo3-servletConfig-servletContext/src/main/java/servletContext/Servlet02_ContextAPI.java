package servletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 获得一个指向项目部署位置下的某个文件/目录的磁盘真实路径的API servletContext.getRealPath
 * 获得项目部署的上下文路径，项目的访问路径 servletContext.getContextPath()  demo3
 */
@WebServlet("/servlet4")
public class Servlet02_ContextAPI extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        // 向upload目录中写入一个文件
        // 获得一个指向项目部署位置下的某个文件/目录的磁盘真实路径的API
        String path = servletContext.getRealPath("upload");
        System.out.println(path);

        //获得项目部署的上下文路径，项目的访问路径
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
    }
}
