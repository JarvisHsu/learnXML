package Class01.cn.itcast.dom4jtest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class TestDom4j {
    private static final String URL = "learnXML1.0/src/Class01/MY XML/Pro 16/test.xml";

    public static void main(String[] args) throws Exception {
        selectName();
    }
    //查询xml中所有name元素的值
    private static void selectName() throws Exception {
        /*
          1、创建解析器
          2、得到document
          3、得到根节点 getRootElement()
          4、得到所有p1标签
                  *element(qname)
                       **表示获取标签下面的第一个子标签
                       **qname：标签名称
                  *elements(qname)
                       **表示获取标签下面是这个名称的所有子标签
                       **qname：标签名称
                  *elements()
                       **获取标签下面的所有一层子标签
          5、得到name
          6、得到name里面的值
         */
        //1
        SAXReader saxReader = new SAXReader();
        //2
        Document document = saxReader.read(URL);
        //3
        Element root = document.getRootElement();
        //4
        List<Element> list= root.elements("p1");
        //5
        for (Element element : list) {
            //element是每一个p1元素
            //得到p1下面的name元素
            Element name1 = element.element("name");
            //得到name里面的值
            System.out.println(name1.getText());
        }
    }

}
