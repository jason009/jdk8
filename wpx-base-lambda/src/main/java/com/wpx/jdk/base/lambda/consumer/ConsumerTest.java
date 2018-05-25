package com.wpx.jdk.base.lambda.consumer;

import java.util.function.Consumer;

/**
 * @ClassName:
 * @Description: 如果需要的行為是接受一個引數，然後處理後不傳回值，就可以使用Consumer介面
 * 接受Consumer的實際例子就是Iterable上的forEach方法。既然接受了引數但沒有傳回值，這行為就像純綷消耗了引數，
 * 也就是命名為Consumer的原因，如果產出，就是以副作用（Side effect）形式呈現，像是改變某物件狀態，
 * 或者是進行了輸入輸出，例如，使用System.out的println()進行輸出：
 * Consumer介面主要是接受單一物件實例作為引數，對於基本型態int、long、double，
 * 另外有IntConsumer、LongConsumer、DoubleConsumer三個函式介面；
 * 另外還有ObjIntConsumer、ObjLongConsumer、ObjDoubleConsumer，
 * 這三個函式介面第一個參數接受物件實例，第二個參數接受的基本型態則對應至類別名稱
 *
 * @author: 慎独
 * @date: 2018/5/23
 * @mail: wangpeixuaninfo@jd.com
 * @version: v1.0
 * @since: JDK 1.7
 */
public class ConsumerTest {
    public static void validInput(String name, Consumer<String> function) {
        function.accept(name);
    }

    public static void main(String[] args) throws InterruptedException {
        String name = "";
        String name1 = "12345";

        validInput(name, inputStr ->
                System.out.println(inputStr.isEmpty() ? "名字不能为空" : "名字正常"));
        validInput(name1, inputStr ->
                System.out.println(inputStr.isEmpty() ? "名字不能为空" : "名字正常"));

    }
}
