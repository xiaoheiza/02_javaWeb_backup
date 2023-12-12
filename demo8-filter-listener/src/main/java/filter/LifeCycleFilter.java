package filter;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * 生命周期
 *      1、构造        构造器       项目启动（只能饿汉式，无法改为懒汉式）
 *      2、初始化       init        构造完毕
 *      3、过滤        doFilter    每次请求
 *      4、销毁        destroy     服务关闭
 */
public class LifeCycleFilter implements Filter {

    public LifeCycleFilter() {
        System.out.println("构造");
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
        System.out.println(filterConfig.getInitParameter("dataTimePattern"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤方法");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法");
    }
}
