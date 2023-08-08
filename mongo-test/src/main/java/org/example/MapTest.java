package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {
    public static Integer aa = 1;
    public static void main(String args[]) {
        System.out.println("Hello World");

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        Integer a = map.putIfAbsent(2,5);
        map.putIfAbsent(10,10);
        Map<Integer, Integer> newmap = new HashMap<>();
        newmap.putAll(map);
        map.remove(10);
        System.out.println(map.getOrDefault(10, 1));
        System.out.println(a);

        map.forEach((k,v) -> {
            System.out.println("k="+k+ " v= " + v);
            increaseAA();
        });

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.hashCode());
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println(" ----------");
        System.out.println(map.keySet());

        System.out.println(" ----------");
        map.keySet().forEach(key -> {
            System.out.println(key);
        });

        System.out.println(" ----------");
        System.out.println(aa);

        Map<String, String> treemap = new TreeMap<>();

        // Put elements to the map
        treemap.put("1", "Welcome");
        treemap.put("2", "to");
        treemap.put("3", "the");
        treemap.put("4", "Geeks");
        treemap.put("5", "Community");
        treemap.forEach((k,v) -> {
            System.out.println("k="+k+ " v= " + v);
        });

        List<Integer> list = Arrays.asList(5,1,2,3,4);
        List<Integer> list2 = new ArrayList<>(list);
        Collections.sort(list);
        System.out.println(list2);

    }

    private static void increaseAA() {
        aa++;
    }
}
