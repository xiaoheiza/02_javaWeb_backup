package garbledCode;

/**
 * 1、介绍
 *      大部分主流的编码方式都包括了ASCII码，ASCII码中包含了一些英文字母和常见的符号，因此一般来说英文不会乱码
 *      idea中file->setting->editor->file encodings 中写明了全局和工程以及properties配置文件的编码方式，建议都改为UTF-8
 * 2、tomcat中的输出日志乱码
 *      1）修改logging.properties对应的输出方式（推荐，让tomcat适应操作系统
 *      2）修改输出控制台的编码方式
 * 3、sout输出乱码
 *      原因：编译好的字节码文件在JVM运行中编码方式不一致
 *      解决方式：在VM options中设置-Dfile.encoding=UTF-8
 */
public class Introduce {
}
