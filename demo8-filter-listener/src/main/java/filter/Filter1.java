package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;

/**
 * 过滤器链：先进后出，和web.xml中配置<filter-mapping>的顺序有关
 * 如果是注解的方式，则根据类名的字典顺序
 */
@WebFilter(initParams = {@WebInitParam(name = "dataTimePattern", value = "yyyy-mm-dd HH:mm:ss")}, urlPatterns = {"/servlet1"}, servletNames = {"servlet1Name"})
public class Filter1 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter1 before dolFilter invoked2");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter1 after dolFilter invoked2");

    }
}
