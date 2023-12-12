package servletContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 *  获得请求体中的非键值对数据？ JSON串、文件
 *      // 获取一个从请求体中读取字符的字符输入流
 *      BufferedReader reader = req.getReader();  // JSON串
 *      // 获取一个从请求体中读取二进制的字节输入流
 *      ServletInputStream inputStream = req.getInputStream();  // 文件
 */
@WebServlet("/servlet05")
public class Servlet05_HttpServletRequest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取请求参数
        // 根据参数名获取单个参数值
        String username = req.getParameter("username");
        System.out.println(username);
        System.out.println(req.getParameter("userPwd"));
        // 根据参数名获得多个值
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));

        // 获取所有的参数名
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String pname = parameterNames.nextElement();
            // 统一当成多个值
            String[] parameterValues = req.getParameterValues(pname);
            for (String parameterValue : parameterValues) {
                System.out.println(pname + ": " + parameterValue);
            }
        }

        // 返回所有参数的map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            if (value.length == 1) {
                System.out.println(key + "=" + value[0]);
            } else {
                System.out.println(key + "=" + Arrays.toString(value));
            }
        }

        // 获取一个从请求体中读取字符的字符输入流
        BufferedReader reader = req.getReader();  // JSON串
        // 获取一个从请求体中读取二进制的字节输入流
        ServletInputStream inputStream = req.getInputStream();  // 文件

        System.out.println(req.getServletPath());   // 请求路径
    }
}
