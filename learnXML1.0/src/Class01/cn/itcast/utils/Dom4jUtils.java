package Class01.cn.itcast.utils;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;

public class Dom4jUtils {
    public static final String PATH = "learnXML1.0/src/Class01/MY XML/Pro 16/test.xml";

    /**
     * 得到document
     *
     * @param path xml文件路径
     * @return 返回document对象
     */
    public static Document getDocument(String path) {
        Document document = null;
        try {
            //创建解析器
            SAXReader saxReader = new SAXReader();
            //得到document
            document = saxReader.read(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }
    public static void xmlWriters(Document document,String Path){
        try{
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(Path),format);
            xmlWriter.write(document);
            xmlWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
