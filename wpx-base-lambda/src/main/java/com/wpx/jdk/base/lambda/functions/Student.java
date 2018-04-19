package com.wpx.jdk.base.lambda.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by wpx on 2018/4/15.
 *
 */
public class Student {
    private String name;
    private int score;

    public Student() {

    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int compareStudentByScore(Student student1, Student student2) {
        return student1.getScore() - student2.getScore();
    }

    /**
     * 虽然 compareStudentByScore方法在语法上没有任何问题，可以作为一个工具正常使用，但是有没有觉得其在设计上是不合适的
     * 或者是错误的。这样的方法定义放在任何一个类中都可以正常使用，而不只是从属于Student这个类，
     * 那如果要定义一个只能从属于Student类的比较方法下面这个实例方法更合适一些。
     *
     * 接收一个Student对象和当前调用该方法的Student对象的分数进行比较即可。现在我们就可以使用
     * 类名::实例方法名 这种方式的方法引用替换lambda表达式了
     * @param student
     * @return
     */
    public int compareByScore(Student student){
        return this.getScore() - student.getScore();
    }


    public static void main(String[] args) {
        /**第一种 类名::静态方法名(在Java8中，我们可以直接通过方法引用来简写lambda表达式中已经存在的方法)
         *
         * 静态方法引用比较容易理解，和静态方法调用相比，只是把 . 换为 ::
         * 在目标类型兼容的任何地方，都可以使用静态方法引用。
         * 例子：
         *　 String::valueOf   等价于lambda表达式 (s) -> String.valueOf(s)
         *　Math::pow       等价于lambda表达式  (x, y) -> Math.pow(x, y);
         */
        Student student1 = new Student("zhangsan",60);
        Student student2 = new Student("lisi",70);
        Student student3 = new Student("wangwu",80);
        Student student4 = new Student("zhaoliu",90);
        List<Student> students = Arrays.asList(student1,student2,student3,student4);
        //我们先使用lambda表达式的方式进行处理
        // students.sort((o1, o2) -> o1.getScore() - o2.getScore());
        // students.forEach(student -> System.out.println(student.getScore()));
        /**
         * sort方法接收一个Comparator函数式接口，接口中唯一的抽象方法compare接收两个参数返回一个int类型值，下方是Comparator接口定义
         *
         *Student类中定义的compareStudentByScore静态方法,同样是接收两个参数返回一个int类型值，而且是对Student对象的分数进行比较，
         * 所以我们这里就可以 使用类名::静态方法名 方法引用替换lambda表达式
         */
      //  students.sort(Student::compareStudentByScore);
      //  students.forEach(student -> System.out.println(student.getScore()));

        /**第二种 对象::实例方法名**/
       // StudentComparator studentComparator = new StudentComparator();
      //  students.sort(studentComparator::compareStudentByScore);
      //  students.forEach(student -> System.out.println(student.getScore()));

        /**第三种 类名::实例方法名**/
        /**
         * 这里非常奇怪，sort方法接收的lambda表达式不应该是两个参数么，为什么这个实例方法只有一个参数也满足了lambda表达式的定义（想想这个方法是谁来调用的）。
         * 这就是 类名::实例方法名 这种方法引用的特殊之处：当使用 类名::实例方法名 方法引用时，一定是lambda表达式所接收的第一个参数来调用实例方法，
         * 结合本例来看，最初的lambda表达式是这样的
         * students.sort((o1, o2) -> o1.getScore() - o2.getScore());
         * 那使用 类名::实例方法名 方法引用时，一定是o1来调用了compareByScore实例方法，并将o2作为参数传递进来进行比较。是不是就符合了compareByScore的方法定义。
         */
       // students.sort(Student::compareByScore);
       // students.forEach(student -> System.out.println(student.getScore()));

        /**第四种 类名::new**/

        /**
         * 也称构造方法引用，和前两种类似只要符合lambda表达式的定义即可，回想下Supplier函数式接口的get方法，不接收参数有返回值，正好符合无参构造方法的定义
         *
         * @FunctionalInterface
         *   public interface Supplier<T> {
         *    T get();
         *   }
         */
        Supplier<Student> supplier = Student::new;
        Student student = supplier.get();
        System.out.println("");

    }
}
