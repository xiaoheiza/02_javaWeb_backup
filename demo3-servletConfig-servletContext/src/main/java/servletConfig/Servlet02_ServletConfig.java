package servletConfig;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * web.xml中的init-param会被实例化为ServletConfig对象，并传入到对应的HttpServlet对象(在GenericServlet抽象类的init方法中重写了)中
 */
public class Servlet02_ServletConfig extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        // 获取初始配置信息即可
        String keya = servletConfig.getInitParameter("keya");
        System.out.println(keya);
        // 获取所有的初始参数的名字 （早期的迭代器
        //hasMoreEleMents   判断有没有下一个参数，如果有返回true，没有返回false
        // nextElement      取出下一个元素，并移动游标
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String pname = initParameterNames.nextElement();
            System.out.println(pname + "=" + servletConfig.getInitParameter(pname));
        }
    }
}
