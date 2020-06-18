package Class01.cn.itcast.dom4jtest;

import Class01.cn.itcast.utils.Dom4jUtils;
import org.dom4j.Document;
import org.dom4j.Node;

import java.util.List;

public class TestDom4jXpath {
    public static void main(String[] args) {
        selectP1name();
    }
    //获取第一个p1下的name的值
    private static void selectP1name(){
        /*
        1、创建解析器
          2、得到document
          3、得到p1下的name //p1[@ID1='aaa']/name
          4、获取name值
         */
        //1 2
        Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //3
        Node name = document.selectSingleNode("//p1[@ID1='aaa']/name");
        System.out.println(name.getText());
    }
    //使用Xpath实现查询所有name元素的值
    private static void selectAllName(){
        /*
        1、创建解析器
          2、得到document
          3、得到所有的name元素"//name"
          4、获取name值
         */
        //1 2
        Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //3
        List<Node> list = document.selectNodes("//name");
        //4
        for (Node node : list) {
            System.out.println(node.getText());
        }
    }
}
