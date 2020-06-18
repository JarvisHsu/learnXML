package cn.itcast.service;

import cn.itcast.utils.Dom4jUtils;
import cn.itcast.vo.Student;
import org.dom4j.Document;
import org.dom4j.Element;


public class StuService {
    /**
     * * 1、创建解析器
     * * 2、得到document
     * * 3、获取root节点
     * * 4、在root上创建stu标签
     * * 5、在stu上依次添加 id name age
     * * 6、在 id name age 上面依次添加值
     * *
     * * 7、回写xml
     *
     * @param student 学生类放需要写入的信息
     */
    public static void addStu(Student student) {
        //1 2
        Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //3
        Element root = document.getRootElement();
        //4
        Element stu = root.addElement("stu");
        //5
        Element stu_id = stu.addElement("id");
        Element stu_name = stu.addElement("name");
        Element stu_age = stu.addElement("age");
        //6
        stu_id.setText(student.getId());
        stu_name.setText(student.getName());
        stu_age.setText(student.getAge());
        //7
        Dom4jUtils.xmlWriters(document, Dom4jUtils.PATH);
    }
}
