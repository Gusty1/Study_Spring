package com.gusty.spring6.iocxml.dimap;

import java.util.List;
import java.util.Map;

public class Student {
    //學生學號
    private String sid;
    //學生姓名
    private String sname;
    private Map<String,Teacher> teacherMap;

    private List<Lesson> lessonList;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public void run() {
        System.out.println("學生學號: " + sid);
        System.out.println("學生姓名: " + sname);
        System.out.println(teacherMap);
        System.out.println(lessonList);
    }
}
