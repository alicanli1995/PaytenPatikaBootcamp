package com.example.bootcampweekone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class BootCampWeekOneApplicationTests {

    BootCampWeekOneApplication test = new BootCampWeekOneApplication();

    @Test
    public void flatMap(){
        List<String> flatterMap = test.flatMap(Arrays.asList("two birds", "three green peas"));
        Assertions.assertEquals(Arrays.asList("two", "birdsthree", "green", "peas"), flatterMap);
    }

    @Test
    public void flatten() {
        List<Object> list = BootCampWeekOneApplication.flatten(Arrays.asList(1, 3, 5, Arrays.asList(6, 7), 8, 9, 10, Arrays.asList(11, 13, 15, Arrays.asList(16, 17, Arrays.asList(18, 19))), 20));
        Assertions.assertEquals(Arrays.asList(1, 3, 5, 6, 7, 8, 9, 10, 11, 13, 15, 16, 17, 18, 19, 20), list);
    }

    @Test
    public void groupBy(){
        List<String> finalList = test.groupBy(Arrays.asList("Ali", "Veli", "Patika", "Dev"));
        Assertions.assertEquals(Arrays.asList("Ali","Veli", "Patika", "Dev"), finalList);
    }

    @Test
    public void union() {
        List<Integer> set = test.union(Arrays.asList(1,2,3,4,5),Arrays.asList(1,3,4,8,6,6,7,8,8,9,2));
        Assertions.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), set);
    }

    @Test
    public void intersection(){
        List<Integer> results = test.intersection(Arrays.asList(1,2,3,3,4,5),Arrays.asList(3,4));
        Assertions.assertEquals(Arrays.asList(3,3,4), results);
    }

    @Test
    public void sort(){
        List<Integer> finalSorted = test.sort(Arrays.asList(1, 3, 4, 8, 6, 6, 7, 8, 8, 9, 2));
        Assertions.assertEquals(Arrays.asList(1, 2, 3, 4, 6, 6, 7, 8, 8, 8, 9), finalSorted);
    }

    @Test
    public void reduce(){
        String finalStr = test.reduce(Arrays.asList("A","l","i"," ","C","A","N","L","I"));
        Assertions.assertEquals("Ali CANLI", finalStr);
    }

    @Test
    public void filter(){
        List<Integer> finalFilterList = test.filter(Arrays.asList(9, 10, 11, 12));
        Assertions.assertEquals(Arrays.asList(10,12), finalFilterList);
    }

    @Test
    public void slice(){
        List<Integer> finalList = test.slice(Arrays.asList(1, 3, 4, 8, 6, 6, 7, 8, 8, 9, 2),3,6);
        Assertions.assertEquals(Arrays.asList(8, 6, 6), finalList);
    }

    @Test
    public void distinct(){
        List<Integer> x = test.distinct(Arrays.asList(1,3,4,8,6,6,7,8,8,9,2));
        Assertions.assertEquals(Arrays.asList(1, 3, 4, 8, 6, 7, 9, 2), x);
    }

    @Test
    public void mapping(){
        List<Integer> finalList = test.mapping(Arrays.asList(1,2,3,4,5));
        Assertions.assertEquals(Arrays.asList(1, 8, 27, 64, 125), finalList);
    }

    @Test
    public void concatenate(){
        List<Integer> finalList = test.concatenate(Arrays.asList(1, 2, 3, 4, 5),Arrays.asList(9,10,11,12));
        Assertions.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 9, 10, 11, 12), finalList);
    }

    @Test
    public void difference(){
        List<Integer> finalList = test.difference(Arrays.asList(1, 2, 3, 4, 5),Arrays.asList(2,3));
        Assertions.assertEquals(Arrays.asList(1, 4, 5), finalList);
    }




}
