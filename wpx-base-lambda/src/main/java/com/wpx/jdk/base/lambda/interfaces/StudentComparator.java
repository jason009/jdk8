package com.wpx.jdk.base.lambda.interfaces;

/**
 * Created by wpx on 2018/4/15.
 *
 */
public class StudentComparator {
    public int compareStudentByScore(Student student1,Student student2){
        return student2.getScore() - student1.getScore();
    }

}
