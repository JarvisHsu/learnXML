package cn.itcast.test;

import cn.itcast.service.StuService;
import cn.itcast.vo.Student;

public class TestStu {
    public static void main(String[] args) {
        testSel();
    }

    //测试添加方法
    private static void testAdd() {
        //设置值
        Student stu = new Student();
        stu.setId("103");
        stu.setName("wangwu");
        stu.setAge("40");
        StuService.addStu(stu);
    }
    //测试删除方法
    private static void testDel(){
        //设置值
        String id = "103";
        StuService.delStu(id);
    }
    //测试查询方法
    private static void testSel(){
        //设置值
        String id = "100";
        Student stu = StuService.getStu(id);
        System.out.println(stu);
    }
}
