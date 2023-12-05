package xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @description:
 * @author：xiaozheng
 * @date: 2023/12/5
 */
public class TestDom4j {
    @Test
    public void testRead() throws DocumentException {
        // 读取jdbc.xml配置文件，获得document对象
        SAXReader saxReader = new SAXReader();
        // 通过类加载器获得指向字节码根路径下的指定文件的输入流
        InputStream resourceAsStream = TestDom4j.class.getClassLoader().getResourceAsStream("jdbc.xml");
        // 通过输入流获得配置文件，获得dom对象
        Document document = saxReader.read(resourceAsStream);
        // 从document对象上获取配置文件中的信息
        /*
        * Node节点
        *   element 元素节点
        *   attribute 属性节点
        *   test    文本节点
        * */
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());
        // 获得元素下的子元素
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            System.out.println("\t" + element.getName());
            // 从元素上获取属性
            Attribute attribute = element.attribute("id");
            System.out.println("\t\t" + attribute.getName() + "=" + attribute.getValue());
            // 继续获取其子元素
            List<Element> eles = element.elements();
            for (Element ele : eles) {
                System.out.println("\t\t" + ele.getName() + "=" + ele.getText());
            }
        }
    }
}
