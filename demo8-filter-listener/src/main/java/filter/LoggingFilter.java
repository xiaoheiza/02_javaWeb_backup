package filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日志过滤器 记录请求的历史，将日志打印到控制台
 *  1、实现Filter接口
 *  2、重写过滤方法
 *  3、配置过滤器
 *      web.xml
 *      注解方式
 */
public class LoggingFilter implements Filter {
    /*
     过滤请求和相应的方法
        1、请求到达目标资源之前，先经过方法
        2、有能力控制是否继续访问后续资源，可以在该方法内直接向哭护短做相应处理
        3、请求到达目标资源后，相应之前，还会经过该方法！！
     */

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 参数父转子
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 请求到达目标资源之前的代码：判断是否登录、校验权限是否满足
        System.out.print("loggingFilter before filterChain.doFilter invoked： ");
        String requestURI = request.getRequestURI();
        String dateTime = dateFormat.format(new Date());
        String beforeLogging = requestURI + "在" + dateTime + "被访问了";
        System.out.println(beforeLogging);
        long p1 = System.currentTimeMillis();
        // 放行代码
        filterChain.doFilter(servletRequest, servletResponse);
        // 响应之前 HttpServletResponse 转化为响应报文之前的功能代码
        System.out.print("loggingFilter after filterChain.doFilter invoked： ");
        long p2 = System.currentTimeMillis();
        String afterLogging = requestURI + "资源在" + dateTime + "的好使请求：" + (p2 - p1) + "毫秒";
        System.out.println(afterLogging);

    }
}
