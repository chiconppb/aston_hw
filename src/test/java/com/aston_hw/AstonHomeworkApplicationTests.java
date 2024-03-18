package com.aston_hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AstonHomeworkApplicationTests {
    private static final CustomArrayList<Integer> ARRAY = new CustomArrayList<>();
    private static final CustomArrayList<Integer> COMPARE_LIST = new CustomArrayList<>();


    private static final Integer a = 10;
    private static final Integer b = 20;
//    private static final Integer c = 30;
//    private static final Integer d = 40;
//    private static final CustomArrayList<Integer> list1 = new CustomArrayList<>();
//    private static final CustomArrayList<Integer> list2 = new CustomArrayList<>();


    @BeforeEach
    public void init() {
        ARRAY.clear();
        COMPARE_LIST.clear();
        ARRAY.add(a);
        ARRAY.add(b);
    }

    @Test
    public void addElement() {
        COMPARE_LIST.add(a);
        COMPARE_LIST.add(b);
        Assertions.assertEquals(COMPARE_LIST.get(0), ARRAY.get(0));
        Assertions.assertEquals(COMPARE_LIST.get(1), ARRAY.get(1));
    }

    @Test
    public void addElementToIndex() {
        COMPARE_LIST.add(a);
        COMPARE_LIST.add(5, b);
        Assertions.assertEquals(COMPARE_LIST.get(5), b);
    }

    @Test
    public void checkSize() {
        COMPARE_LIST.add(a);
        COMPARE_LIST.add(b);
        Assertions.assertEquals(COMPARE_LIST.size(), ARRAY.size());
    }

    @Test
    public void addAll() {
        CustomArrayList<String> list = new CustomArrayList<>();
        List<String> newList = new ArrayList<>();
        newList.add(a.toString());
        newList.add(b.toString());
        list.addAll(newList);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals(a.toString(), list.get(0));
        Assertions.assertEquals(b.toString(), list.get(1));

    }

    @Test
    public void clear() {
        ARRAY.clear();
        Assertions.assertEquals(0, ARRAY.size());
    }

    @Test
    public void isEmpty() {
        ARRAY.remove(0);
        ARRAY.remove(1);
        Assertions.assertTrue(ARRAY.isEmpty());
    }

    @Test
    public void remove() {

    }

    @Test
    public void sort() {

    }
}
