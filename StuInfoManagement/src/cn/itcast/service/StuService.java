package cn.itcast.service;

import cn.itcast.utils.Dom4jUtils;
import cn.itcast.vo.Student;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import java.util.List;


public class StuService {
    /**
     * 添加一条学生信息
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
    /**
     * 删除一条学生信息
     * * 1、创建解析器
     * * 2、得到document
     * * 3、获取到所有id
     * *    使用xpath //id 返回List<Node>集合
     * * 4、遍历集合List 进行id比较
     * * 5、删除找到的id值
     * *
     * * 6、回写xml
     *
     * @param id 根据id进行删除
     */
    public static void delStu(String id){
        int count = 0;
        //1 2
        Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //3
        List<Node> list_id = document.selectNodes("//id");
        //4
        for (Node node : list_id) {
            //5
            if (id.equals(node.getText())) {
                //得到id的父节点stu
                Element stu = node.getParent();
                //得到student节点
                Element student =stu.getParent();
                student.remove(stu);
                count++;
                //只删除找到的第一条匹配信息
                break;
            }
        }
        //不为0则找到id
        if (count!=0){
            //6
            Dom4jUtils.xmlWriters(document,Dom4jUtils.PATH);
            System.out.println("共删除"+count+"条id为"+id+"的数据");
        }else {
            System.out.println("未找到符合信息");
        }
    }
    /**
     * 1、创建解析器
     * 2、得到document
     * 3、获取到所有id
     *     使用xpath //id 返回List<Node>集合
     * 4、遍历集合List 进行id比较
     * 5、分别设置 id name age 属性值
     * @param id 根据id查询学生信息
     * @return  返回查询到的student信息
     */
    public static Student getStu(String id){
        Student student = null;
        //1 2
        Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //3
        List<Node> list_id = document.selectNodes("//id");
        //4
        for (Node node : list_id) {
            if (id.equals(node.getText())) {
                //得到stu节点
                Element stu = node.getParent();
                Element stu_id = stu.element("id");
                Element stu_name = stu.element("name");
                Element stu_age = stu.element("age");
                //5
                student = new Student();
                student.setId(stu_id.getText());
                student.setName(stu_name.getText());
                student.setAge(stu_age.getText());
            }
        }
        return student;
    }
}
