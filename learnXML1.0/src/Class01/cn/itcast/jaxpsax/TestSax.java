package Class01.cn.itcast.jaxpsax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class TestSax {
    private static final String URL = "learnXML1.0/src/Class01/MY XML/Pro 16/test.xml";

    public static void main(String[] args) throws Exception {
        search();
    }

    public static void search() throws Exception {
        /**
         * 1、创建解析器工厂
         * 2、创建解析器
         * 3、执行parse方法
         * 4、自己创建一个类，继承DefaultHandler
         * 5、重写类里的三个方法
         */
        //1
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        //2
        SAXParser saxParser = saxParserFactory.newSAXParser();
        //3
        saxParser.parse(URL, new MyDefault2());
    }
}

//获取任意位置name元素的值
class MyDefault2 extends DefaultHandler {
    boolean flag = false;
    int index = 1;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //判断qName是否为name元素
        if ("name".equals(qName)) {
            flag = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (flag == true && index ==1) {
            System.out.println(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("name".equals(qName)) {
            flag = false;
            index++;
        }
    }
}

class MyDefault1 extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print("<" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.print(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("<" + qName + ">");
    }


}
