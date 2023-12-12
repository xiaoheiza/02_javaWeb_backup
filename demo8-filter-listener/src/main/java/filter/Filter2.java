package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @description:
 * @author：xiaozheng
 * @date: 20
 */
//@WebFilter("/*")
public class Filter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter2 before dolFilter invoked");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter2 after dolFilter invoked");

    }
}
