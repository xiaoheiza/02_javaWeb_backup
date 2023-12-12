package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @description:
 * @author：xiaozheng
 * @date: 20
 */
@WebFilter("/servletA")
public class Filter3 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter3 before dolFilter invoked");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter3 after dolFilter invoked");

    }
}
