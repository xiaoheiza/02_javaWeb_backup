package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojo.SysUser;

import java.io.IOException;

/**
 * @description:
 * @author：xiaozheng
 * @date: 20
 */
@WebFilter(urlPatterns = {"/showSchedule.html", "/schedule/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获得session对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        // 从session域中获得登陆的用户对象
        SysUser sysUser = (SysUser)session.getAttribute("sysUser");
        // 判断用户对象是否为空
        if (null == sysUser) {
            response.sendRedirect("/login.html");
        } else {
            filterChain.doFilter(request, response);
        }
        //
    }
}
