package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 1 实例化                    构造器         // 第一次请求/服务启动时       1次
 * 2 初始化                    init          // 构造完毕                  1次
 * 3 接收请求，处理请求  服务    service       // 每次请求                  多次
 * 4 销毁                      destory       // 关闭服务                  1次
 *
 * Servlet在Tomcat中是单例的，并且是懒汉式的（loadOnStartup = -1，可以改为一个正数，改为饿汉式，值越小的实例化越靠前(不建议写1-5，因为在tomcat公共的xml中已经占用了)）.
 * 所以Servlet的成员变量在多个线程栈中是共享的，不建议在service方法中修改成员变量，在并发请求时会有线程安全问题
 *
 * default-servlet：如果一个请求（包括静态资源）和所有自己写的servlet都匹配不上，那么会执行defaultServlet。
 *                  这个defaultServlet会根据路径去请求静态资源，并通过流的方式放到响应体中。
 *                  在springMVC框架中会导致defaultServlet失效，导致无法去访问静态资源，需要自己去手动的配置
 *  Servlet继承结构
 *      1、顶级的Servlet接口
 *      public interface Servlet {
 *          // 初始化方法，构造完毕后，有tomcat自动调用完成初始化功能的方法
 *          void init(ServletConfig var1) throws ServletException;
 *
 *          // 获得servletConfig对象的方法
 *          ServletConfig getServletConfig();
 *
 *          // 接收用户请求，向用户相应信息的方法
 *          void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;
 *
 *          // 返回servlet字符串形式描述信息的方法
 *          String getServletInfo();
 *
 *          // servlet在回收前，由tomcat调用的销毁方法，往往用于做资源的释放工作
 *          void destroy();
 *      }
 *
 *      2、抽象的类  GenericServlet  侧重除了service方法以外的基础处理
 *      public abstract class GenericServlet implements Servlet{
 *          private transient ServletConfig config;
 *          public void destroy() {
 *              // 将抽象方法，重写为普通方法，在方法内部没有任何实现的代码（平庸实现）
 *          }
 *
 *          // tomcat在调用init方法时，会读取配置信息进入一个ServletConfig对象，并将该对象传入init方法
 *          public void init(ServletConfig config) throws ServletException {
 *              // 将config对象存储为当前的属性
 *              this.config = config;
 *              // 调用了重载的无参的init方法
 *              this.init();
 *          }
 *          // 返回ServletConfig的方法
 *          public ServletConfig getServletConfig() {
 *              return this.config;
 *          }
 *          // 再次抽象声明service方法
 *          public abstract void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;
 *      }
 *
 *      3、抽象的类 HttpServlet  侧重service方法的处理
 *      public abstract class HttpServlet extends GenericServlet {
 *          public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
 *              // 参数的父转子
 *              HttpServletRequest request = (HttpServletRequest)req;
 *              HttpServletResponse response = (HttpServletResponse)res;
 *              // 调用重载的service方法
 *              this.service(request, response);
            }
             protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                 // 获取请求的方法
                 String method = req.getMethod();
                // 根据请求的方法，调用对应的do...方法
                 if (method.equals("GET")) {
                     this.doGet(req, resp);     // 故意响应405
                     } else if (method.equals("HEAD")) {
                         this.doHead(req, resp);
                     } else if (method.equals("POST")) {
                        this.doPost(req, resp); // // 故意响应405
                     } else if (method.equals("PUT")) {
                        this.doPut(req, resp);
                     } else if (method.equals("DELETE")) {
                        this.doDelete(req, resp);
                     } else if (method.equals("OPTIONS")) {
                        this.doOptions(req, resp);
                     } else if (method.equals("TRACE")) {
                        this.doTrace(req, resp);
                     } else {
                        String errMsg = lStrings.getString("http.method_not_implemented");
                        Object[] errArgs = new Object[]{method};
                        errMsg = MessageFormat.format(errMsg, errArgs);
                        resp.sendError(501, errMsg);
                    }
            }
             protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                 String msg = lStrings.getString("http.method_get_not_supported");
                 // 在get方式了故意响应405
                 resp.sendError(405, msg);
             }
 *      }
 *      4、自定义servlet
 *      public class Servlet03_ServletLife extends HttpServlet {
 *          重写了service方法，意思就是说如果不重写service方法，会走HttpServlet中的service方法(doGet/doPost)并且报405
 *          因此我们也可以重写doGet、doPost等方法来指定不同的请求方式
 *      }
 *      5、部分程序员推荐在servlet中重写do***方法，理由父类service中可能有一些处理，导致其中的处理失效
 *         但目前重写service没有任何问题
 *         后续使用SpringMVC框架后，我们则无需继承HttpServlet
 *      6、继承HttpServlet后，要么重写service方法， 要么重写do***方法
 */
@WebServlet(value = "/servletLifeCycle", loadOnStartup = 1)
public class Servlet03_ServletLife extends HttpServlet {

    public Servlet03_ServletLife() {
        System.out.println("构造器");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }

/*    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("服务");
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet的处理方法");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost的处理方法");
    }

    @Override
    public void destroy() {
        System.out.println("destory");
    }
}
