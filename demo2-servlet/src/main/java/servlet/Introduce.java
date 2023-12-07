package servlet;

/**
 * @description:
 * @author：xiaozheng
 * @date: 20
 */
public class Introduce {
    /*
     * 流程
     *   1、请求的报文（请求行、请求头、请求体）：tomcat接收到请求后会转换为HttpServletRequest对象，包含了请求的所有对象
     *   2、tomcat同时创建了一个HttpServletResponse对象，该对象用于承装要相应给客户端的信息，该对象会转换为相应的报文
     *   3、用于编写程序继承Servlet接口，并重写service对象。tomcat根据请求中的资源路径找到对应的servlet，将servlet实例化，调用service方法
     *      同时将HttpServletRequest对象和HttpServletResponse对象传入
     *       1）可以从request对象中获取请求的所有信息（一般是参数）
     *       2）根据参数生成要相应给客户端的数据
     *       3）将响应的数据放入response对象
     * */
}
