package tomcat;

/**
 * @description:
 * @author：xiaozheng
 * @date: 20
 */
public class Introduce {
    /*
     * tomcat相当于一个专门运行web的应用软件，tomcat10的包名换了，所以8和9上的代码不能再10上跑
     * startup.bat是启动文件，后面是在idea中启动
     * 将logging.properties中的配置修改为java.util.logging.ConsoleHandler.encoding = GBK可以解决手动启动时日志打印的乱码问题
     *自己的项目放在webapps中，tomcat启动后用localhost:8080/项目名/路径  来访问
     * 项目的上下文路径，项目的访问路径为地址栏中端口号后面的东西。可以和项目的名称不一样
     * 在项目中可以放：
     * static(img、css、js)
     * WEB-INF 该目录下的资源是受保护的资源，是不可以通过浏览器直接访问的资源（classes存放字节码文件、lib项目第三方的包、web.xml项目的配置文件）
     * page (html)
     *
     * 三种部署app的方式
     *      1、放到webapps目录中
     *      2、如果要自定义项目目录，需要在Catalina/localhost中准备一个（项目名）.xml文件，在里面指定目录文件
     *          <Context path="端口号后面的url路径(必须和xml文件的名称相同)" docBase="项目真实路径" />
     *          在server.xml中可以配置<role>标签来登录tomcat中的manager/host-manager网页管理软件，里面可以看到所有的项目。
     *
     * */
}
