package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @description:
 * @author：xiaozheng
 * @date: 2023/12/7
 */
/*
* 注解方式配置了，就不要用xml方式配置了。
* 如果开始忘了加/，会报启动子级出错
* */
@WebServlet("/s1")
public class Servlet02_Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet1执行了");
    }
}
