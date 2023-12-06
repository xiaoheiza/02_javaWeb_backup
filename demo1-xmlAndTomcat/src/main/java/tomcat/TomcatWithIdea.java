package tomcat;

/**
 * @description:
 * @author：xiaozheng
 * @date: 20
 */
public class TomcatWithIdea {
    /*
     * javaweb工程构建为APP，然后再部署到tomcat中
         * 1、建立tomcat和idea的关联
         * 2、使用idea创建一个javaWEB工程 在WEB工程中开发代码
         * 3、使用idea将功臣构建成一个可以发布的app
         * 4、使用idea将构建好的app部署到tomcat中，启动运行
     * 将项目变为javaWeb项目的方式
         * 1、在setting中的build中添加电脑对应的tomcat版本号
         * 2、在file-》 project structure中的modules中点击+号，然后在点击libraries，添加自己的tomcat
         * 3、然后再在右击项目目录add framework support添加web application（不进行前面两部会导致版本号不对）
     * idea关联tomcat中的方式
     *      1、在build中build artifacts（非必须）
     *      2、添加idea的tomcat edit configuration
     *      3、在deployment的添加artifact，并设置url中的访问路径
     * 原理
     *      idea启动tomcat其实复制了一个tomcat的副本，目的是为了不污染原本的tomcat
     *      tomcat副本仅仅存放了要部署项目的相关文件，让原本的tomcat以副本的配置文件运行
     * */

}
