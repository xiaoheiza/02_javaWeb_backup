package listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

/**
 * 监听器监听的是域对象身上发生的事
 *  对象的创建
 *  对象的销毁
 *  数据的增加
 *  数据的修改
 *  数据的删除
 * 三大域对象的监听器：
 *  ServletContextListener, ServletContextAttributeListener
 *  HttpSessionListener, HttpSessionAttributeListener, HttpSessionBindingListener,HttpSessionActivationListener（钝化和活化，其实就是session的序列化和反序列化）
 *  ServletRequestListener, ServletRequestAttributeListener
 */
@WebListener
public class MyApplicationListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext applcation = sce.getServletContext();
        System.out.println(applcation.hashCode() + "应用域初始化了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext applcation = sce.getServletContext();
        System.out.println(applcation.hashCode() + "应用域销毁了");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        ServletContext applcation = scae.getServletContext();
        String key = scae.getName();
        Object value = scae.getValue();
        System.out.println(applcation.hashCode() + "应用域增加了" + key + ": " + value);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        ServletContext applcation = scae.getServletContext();
        String key = scae.getName();
        Object value = scae.getValue();
        System.out.println(applcation.hashCode() + "应用域移除了" + key + ": " + value);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        ServletContext applcation = scae.getServletContext();
        String key = scae.getName();
        Object value = scae.getValue(); // 获取的旧的值
        Object newValue = applcation.getAttribute(key);// 获取新的值
        System.out.println(applcation.hashCode() + "应用域修改了" + key + ": " + value + "为：" + newValue);
    }
}
