package servletContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 *
 */
@WebServlet("/servlet06")
public class Servlet06_HttpServletResponse extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("haha");
        // 设置相应行相关的API  HTTP/1.1(设置不了) 200 状态描述
        resp.setStatus(200);
        String info = "<h1>hello</h1>";
        // 设置响应头相关的API
        resp.setHeader("aaa", "valuea");
//        resp.setHeader("Content-Type", "text/html");
        resp.setContentType("text/html");
//        resp.setContentLength(1234);
        resp.setContentLength(info.getBytes().length);

        // 设置响应体内容API
        // 获得一个向响应体输入文本字符输出流
        PrintWriter writer = resp.getWriter();
        writer.write(info);

        // 获得一个向响应体中输入二进制信息的字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();
    }
}
