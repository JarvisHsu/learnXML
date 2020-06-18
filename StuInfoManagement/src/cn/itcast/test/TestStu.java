package cn.itcast.test;

import cn.itcast.service.StuService;
import cn.itcast.vo.Student;

public class TestStu {
    public static void main(String[] args) {
        testAdd();
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
}
