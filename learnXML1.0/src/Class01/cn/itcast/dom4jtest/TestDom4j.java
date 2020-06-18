package Class01.cn.itcast.dom4jtest;

import Class01.cn.itcast.utils.Dom4jUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;

public class TestDom4j {


    public static void main(String[] args) {
        getValues();
    }
    //获取第一个p1的id值
    private static void getValues(){
        /*
        1、创建解析器
          2、得到document
          3、得到根节点 getRootElement()

          4、得到第一个p1
          5、获取id值
         */
        //1 2
        Document document =Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //3
        Element root = document.getRootElement();
        //4
        Element p1 = root.element("p1");
        //5
        String p1_id_value = p1.attributeValue("ID1");
        System.out.println(p1_id_value);
    }
    //删除第一个p1下<school>cn.edu.xust</school>
    private static void removeSchool(){
        /*
        1、创建解析器
          2、得到document
          3、得到根节点 getRootElement()

          4、得到第一个p1
          5、删除school元素

          6、回写xml
         */
        //1 2
        Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //3
        Element root = document.getRootElement();
        //4
        Element p1 = root.element("p1");
        //5
        p1.remove(p1.element("school"));
        //6
        Dom4jUtils.xmlWriters(document,Dom4jUtils.PATH);

    }
    //修改第一个p1下面的age元素的值<age>30</age>
    private static void modifyAge() {
        /*
        1、创建解析器
          2、得到document
          3、得到根节点 getRootElement()

          4、得到第一个p1
          5、得到age元素
          6、修改age元素的text

          7、回写xml
         */
        //1 2
        Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //3
        Element root = document.getRootElement();
        //4
        Element p1 = root.element("p1");
        //5
        Element age = p1.element("age");
        //6
        age.setText("30");
        //7
        Dom4jUtils.xmlWriters(document,Dom4jUtils.PATH);
    }

    //在第一个p1标签age元素之前添加<school>cn.edu.xust/</school>
    private static void addSchool() {
        /*
          1、创建解析器
          2、得到document
          3、得到根节点 getRootElement()

          4、得到第一个p1
          5、在p1下面添加元素
          6、在添加完成之后的元素下面添加文本

          7、回写xml
         */
        //1 2
        Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //3
        Element root = document.getRootElement();
        //4
        Element p1 = root.element("p1");
        List<Element> list = p1.elements();
        //5
        Element school = DocumentHelper.createElement("school");
        //6
        school.addText("cn.edu.xust");
        list.add(1, school);
        //7
        Dom4jUtils.xmlWriters(document, Dom4jUtils.PATH);
    }

    //在第一个p1标签末尾加一个元素<sex>nv</sex>
    private static void addSex() {
        /*
          1、创建解析器
          2、得到document
          3、得到根节点 getRootElement()

          4、得到第一个p1
          5、在p1下面添加元素
          6、在添加完成之后的元素下面添加文本

          7、回写xml
         */
        //1 2
        Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //3
        Element root = document.getRootElement();
        //4
        Element p1 = root.element("p1");
        //5
        Element sex = p1.addElement("sex");
        sex.setText("nv");
        //6回写方法，格式化回写
        Dom4jUtils.xmlWriters(document, Dom4jUtils.PATH);
    }

    //获取第二个name元素里面的值
    private static void selectSec() {
        /*
          1、创建解析器
          2、得到document
          3、得到根节点 getRootElement()
          4、得到所有p1
          5、得到第二个p1,下标get(1)
          6、得到第二个p1下面的name
          7、得到name元素里的值
         */
        //1 2
        Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //3
        Element root = document.getRootElement();
        //4
        List<Element> list = root.elements("p1");
        //5
        Element p2 = list.get(1);
        //6
        Element name2 = p2.element("name");
        //7
        System.out.println(name2.getText());
    }

    //获取到第一个name元素里的值
    private static void selectSin() {
        /*
          1、创建解析器
          2、得到document
          3、得到根节点 getRootElement()
          4、得到第一个p1元素
          5、得到p1下面的name元素
          6、得到name元素里的值
         */
        //1 2
        Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //3
        Element root = document.getRootElement();
        //4
        Element p1 = root.element("p1");
        //5
        Element name1 = p1.element("name");
        //6
        System.out.println(name1.getText());


    }

    //查询xml中所有name元素的值
    private static void selectName() {
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
        //1 2
        Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //3
        Element root = document.getRootElement();
        //4
        List<Element> list = root.elements("p1");
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
