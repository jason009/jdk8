package com.wpx.jdk.base.lambda.collections;

        import java.util.Arrays;
        import java.util.Map;
        import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wpx on 2018/4/7.
 */
public class CollectionTest {
    public static void main(String[] args) {
        // Arrays.asList( "a", "b", "d" ).forEach(e -> System.out.println( e ) );
        Map<String, String> map = new ConcurrentHashMap<>();
        Arrays.asList("a", "b", "d").forEach(e -> {
            map.put(e, e);
            System.out.println(e);
        });

        map.forEach((k,v)->{
            System.out.println("map key: " + k + " value : " + v);
            if("b".equals(k)){
                System.out.println("Hello b");
            }
        });
    }
}
