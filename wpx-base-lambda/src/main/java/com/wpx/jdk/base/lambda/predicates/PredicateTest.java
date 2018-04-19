package com.wpx.jdk.base.lambda.predicates;

import com.wpx.jdk.base.lambda.bean.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @ClassName:
 * @Description:
 * @author: 慎独
 * @date: 2018/4/19
 * @mail: wangpeixuaninfo@jd.com
 * @version: v1.0
 * @since: JDK 1.7
 */
public class PredicateTest {
    /**
     * filter Predicate 结合的场景
     * @param names
     * @param condition
     */
    public static void filter(List names, Predicate condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + " ");
        });
    }
    public static void filter(List names, Predicate condition, Predicate condition2) {
        names.stream()
                .filter(condition.and(condition2))
                .forEach((n) -> System.out.println("nName, which starts with 'J' and four letter long is : " + n));
    }

    public static void main(String[] args) {
        /**
         * 一般用法
         */
        Predicate<Student> maleStudent = s -> s.age >= 20 && "male".equals(s.gender);
        Predicate<Student> femaleStudent = s -> s.age > 15 && "female".equals(s.gender);
        Function<Student, String> maleStyle = s -> "Hi, You are male and age " + s.age;
        Function<Student, String> femaleStyle = s -> "Hi, You are female and age " + s.age;
        Student s1 = new Student(21, "male");
        if (maleStudent.test(s1)) {
            System.out.println(s1.customShow(maleStyle));
        } else if (femaleStudent.test(s1)) {
            System.out.println(s1.customShow(femaleStyle));
        }

        /**
         * filter Predicate 结合的场景
         */
        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        Predicate<String> startsWithJ = (str)->str.startsWith("J") ;
        PredicateTest.filter(languages, startsWithJ);

        /**
         * java.util.function.Predicate 允许将两个或更多的 Predicate 合成一个。
         *
         * 它提供类似于逻辑操作符AND和OR的方法，名字叫做and()、or()和xor()，用于将传入 filter() 方法的条件合并起来。
         * 例如，要得到所有以J开始，长度为四个字母的语言，可以定义两个独立的 Predicate 示例分别表示每一个条件，
         * 然后用 Predicate.and() 方法将它们合并起来，如下所示：
         */
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        PredicateTest.filter(languages, startsWithJ,fourLetterLong);


    }
}
