package com.aston_hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SpringBootTest
class AstonHomeworkApplicationTests {
    private static final CustomArrayList<Integer> ARRAY = new CustomArrayList<>();
    private static final CustomArrayList<Integer> COMPARE_LIST = new CustomArrayList<>();

    private static final int a = 15;
    private static final int b = 27;
    private static final int c = 31;
    private static final int d = 49;


    @BeforeEach
    public void init() {
        ARRAY.clear();
        COMPARE_LIST.clear();
        ARRAY.add(b);
        ARRAY.add(a);
    }

    @Test
    public void addElement() {
        COMPARE_LIST.add(b);
        COMPARE_LIST.add(a);
        Assertions.assertEquals(COMPARE_LIST.get(1), ARRAY.get(1));
        Assertions.assertEquals(COMPARE_LIST.get(0), ARRAY.get(0));
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
        newList.add(((Integer) a).toString());
        newList.add(((Integer) b).toString());
        list.addAll(newList);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals(((Integer) a).toString(), list.get(0));
        Assertions.assertEquals(((Integer) b).toString(), list.get(1));

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
        ARRAY.add(c);
        ARRAY.add(d);
        ARRAY.remove(1);
        Assertions.assertEquals(3, ARRAY.size());

    }

    @Test
    public void sort() {
        ARRAY.add(d);
        ARRAY.add(c);
        for(int i=0; i<ARRAY.size(); i++){

            System.out.println(ARRAY.get(i));
        }
        ARRAY.sort(Comparator.naturalOrder());
        Assertions.assertEquals(15, ARRAY.get(0));
        Assertions.assertEquals(27, ARRAY.get(1));
        Assertions.assertEquals(31, ARRAY.get(2));
        Assertions.assertEquals(49, ARRAY.get(3));
    }
}
