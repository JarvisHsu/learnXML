package Class01.cn.itcast.jaxp;


import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * 实现jaxp操作xml
 *
 * @author JarvisHus
 */
public class TestJaxp {
    private static final String URL = "learnXML1.0/src/Class01/MY XML/Pro 16/test.xml";

    public static void main(String[] args) throws Exception {
        traverse();
    }

    /**
     * 遍历xml中所有节点
     * @throws Exception
     */
    public static void traverse()throws Exception{
        /**
         * 1、创建解析器工厂
         * 2、创建解析器
         * 3、解析xml
         *
         * 4、遍历
         */
        //1
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //2
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        //3
        Document document = builder.parse(URL);
        recursive(document);
    }
    private static void recursive(Node node) {
        if (node.getNodeType()==Node.ELEMENT_NODE){
            System.out.println(node.getNodeName());
        }
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node node1 = list.item(i);
            recursive(node1);
        }
    }

    /**
     * 删除第一个p1元素下的<sex></sex>元素
     *
     * @throws Exception
     */
    public static void removeSex() throws Exception {
        /**
         * 1、创建解析器工厂
         * 2、创建解析器
         * 3、解析xml
         *
         * 4、获取p1元素下的sex元素
         * 5、删除sex元素
         *
         * 6、回写
         */
        //1
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //2
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        //3
        Document document = builder.parse(URL);
        //4
        Node sex = document.getElementsByTagName("sex").item(0);
        Node p1 = sex.getParentNode();
        //5
        p1.removeChild(sex);
        //6
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(URL));
    }

    /**
     * 修改第一个p1下面的<sex></sex>标签里的内容为nan
     *
     * @throws Exception
     */
    public static void modifySex() throws Exception {
        /**
         * 1、创建解析器工厂
         * 2、根据解析器工厂创建解析器
         * 3、解析xml，返回document
         *
         * 4、获取p1元素下的sex元素
         * 5、修改nv为nan setTextContent(String textContent)方法
         * 6、回写
         */
        //创建解析器工厂
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        //解析xml
        Document document = builder.parse(URL);
        //获取第一个sex元素
        Node sex = document.getElementsByTagName("sex").item(0);
        sex.setTextContent("nan");
        //回写
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(URL));
    }

    /**
     * 在第一个p1下面添加一条<sex>nv</sex>元素
     *
     * @throws Exception
     */
    public static void addSex() throws Exception {
        /**
         * 1、创建解析器工厂
         * 2、根据解析器工厂创建解析器
         * 3、解析xml，返回document
         *
         * 4、得到第一个p1元素
         *      --先得到所有p1元素，在用item方法得到第一个p1
         * 5、创建一个sex元素，用createElement方法
         * 6、创建文本，用createTextNode
         * 7、把文本加入sex元素，appendChild方法
         * 8、把sex元素加入到p1下
         *
         * 9、回写xml（重要）
         */
        //创建解析器工厂
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        //解析xml
        Document document = builder.parse(URL);
        //获取第一个p1元素
        Node node = document.getElementsByTagName("p1").item(0);
        Element sex = document.createElement("sex");
        Text sex_text = document.createTextNode("nv");
        sex.appendChild(sex_text);
        node.appendChild(sex);
        System.out.println(node.getTextContent());
        //回写xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(URL));
    }

    /**
     * 获取第一name元素的值
     *
     * @throws Exception 问题：回写后没有格式化操作，所以文档会变乱，需要手动进行格式化
     */
    public static void selectSin() throws Exception {
        /**
         * 1、创建解析器工厂
         * 2、根据解析器工厂创建解析器
         * 3、解析xml，返回document
         * 4、得到所有name元素
         * 5、使用返回集合，里面方法item，下标获取具体的元素
         * 6、得到具体的值，使用getTextContent方法
         */
        //创建解析器工厂
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        //解析xml，返回document
        Document document = builder.parse(URL);
        //得到所有name元素
        NodeList list = document.getElementsByTagName("name");
        //下标获取具体元素
        Node node = list.item(0);
        System.out.println(node.getTextContent());
    }

    /**
     * 查询xml中所有name元素的值
     *
     * @throws Exception
     */
    public static void selectAll() throws Exception {
        //查询所有name元素的值
        /**
         * 1、创建解析器工厂
         * 2、根据解析器工厂创建解析器
         * 3、解析xml返回document
         *
         * 4、得到所有name元素
         * 5、返回集合，遍历集合得到每一个name元素
         */
        //创建解析器工厂
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        //解析xml返回document
        Document document = builder.parse(URL);
        //得到name元素
        NodeList list = document.getElementsByTagName("name");
        //遍历集合
        for (int i = 0; i < list.getLength(); i++) {
            Node name1 = list.item(i);//得到每一个name元素
            //得到name元素里面的值
            String s = name1.getTextContent();
            System.out.println(s);
        }
    }
}
