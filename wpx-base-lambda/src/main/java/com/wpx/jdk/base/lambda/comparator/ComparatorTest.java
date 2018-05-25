package com.wpx.jdk.base.lambda.comparator;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * @ClassName:
 * @Description:
 * @author: 慎独
 * @date: 2018/5/24
 * @mail: wangpeixuaninfo@jd.com
 * @version: v1.0
 * @since: JDK 1.7
 */
public class ComparatorTest {
    /**
     * 提取Comparator进行排序
     */
    public static void userSort() {
        List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));
        Collections.sort(humans, Comparator.comparing(Human::getName));
        humans.forEach(e -> System.out.println(e.getName()));
    }

    /**
     * 反转排序
     */
    public static void reverseComparator() {
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 10), new Human("Jack", 12));
        Comparator<Human> comparator = (h1, h2) -> h1.getName().compareTo(h2.getName());
        humans.sort(comparator.reversed());
        humans.forEach(e -> System.out.println(e.getName()));
    }

    /**
     * 多条件排序
     */
    public static void compareByMultiConditional() {
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 12), new Human("Sarah", 10), new Human("Zack", 12));
        humans.sort((lhs, rhs) -> {
            if (lhs.getName().equals(rhs.getName())) {
                return lhs.getAge() - rhs.getAge();
            } else {
                return lhs.getName().compareTo(rhs.getName());
            }
        });
        humans.forEach(e -> System.out.println(e.getName()));
    }

    /**
     * 多条件组合排序
     */
    public static void compareByMultiCombinationConditional() {
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 12), new Human("Sarah", 10), new Human("Zack", 12));
        humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
        humans.forEach(e -> System.out.println(e.getName()));
    }

    public static void main(String[] args) {
        //userSort();
        //reverseComparator();
        // compareByMultiConditional();
        compareByMultiCombinationConditional();
    }

}
