package com.example.bootcampweekone;

import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static java.util.stream.Collectors.*;

@SpringBootApplication
public class BootCampWeekOneApplication {

    public static void main(String[] args) {

        BootCampWeekOneApplication caseMap = new BootCampWeekOneApplication();

        List<Integer> sampleListFirst  = Arrays.asList(1,2,3,4,5);
        List<Integer> sampleListSecond = Arrays.asList(9,10,11,12);
        List<Integer> sampleListThird  = Arrays.asList(2,3);
        List<Integer> sampleListFourth = Arrays.asList(1,3,4,8,6,6,7,8,8,9,2);
        List<String>  sampleListFive   = Arrays.asList("A","l","i"," ","C","A","N","L","I");
        List<String>  sampleListSix    = Arrays.asList("Ali", "Veli", "Patika", "Dev");
        List<Object>  sampleListNine   = Arrays.asList(1, 3, 5, Arrays.asList(6, 7), 8, 9, 10, Arrays.asList(11, 13, 15, Arrays.asList(16, 17, Arrays.asList(18, 19))), 20);
        List<String>  sampleListTen    = Arrays.asList("two birds", "three green peas");


        System.out.println("*********************************************************************************************************************************");
        System.out.print("Mapping (reach each element get cube) before : " + sampleListFirst +" after = ");
        caseMap.mapping(sampleListFirst);
        System.out.println("*********************************************************************************************************************************");
        System.out.print("Concat two list one : " + sampleListFirst + " list two : " + sampleListSecond + " concat list = ");
        caseMap.concatenate(sampleListFirst,sampleListSecond);
        System.out.println("*********************************************************************************************************************************");
        System.out.print("Difference two list, list one : " +sampleListFirst + " list two : " + sampleListThird + " diff list = ");
        caseMap.difference(sampleListFirst, sampleListThird);
        System.out.println("*********************************************************************************************************************************");
        System.out.print("Distinct case before list : " + sampleListFourth + " after method  = ");
        caseMap.distinct(sampleListFourth);
        System.out.println("*********************************************************************************************************************************");
        System.out.print("Slice case before list : " +sampleListFourth + " after method (index start 3 end 6) = ");
        caseMap.slice(sampleListFourth,3,6);
        System.out.println("*********************************************************************************************************************************");
        System.out.print("Filter (mod 2) case before list : " + sampleListSecond + " after method = ");
        caseMap.filter(sampleListSecond);
        System.out.println("*********************************************************************************************************************************");
        System.out.print("Reduce case before list : " + sampleListFive + " after method = ");
        caseMap.reduce(sampleListFive);
        System.out.println("*********************************************************************************************************************************");
        System.out.print("Sort case before list : " + sampleListFourth + " after method = ");
        caseMap.sort(sampleListFourth);
        System.out.println("*********************************************************************************************************************************");
        System.out.print("Intersection case before  list : " + sampleListFirst + " " + sampleListThird + " after method = ");
        caseMap.intersection(sampleListFirst,sampleListThird);
        System.out.println("*********************************************************************************************************************************");
        System.out.print("Union case before  list : " + sampleListFirst + " " + sampleListFourth + " after method = ");
        caseMap.union(sampleListFirst,sampleListFourth);
        System.out.println("*********************************************************************************************************************************");
        System.out.print("GroupBy case before list : " + sampleListSix + " after method = ");
        caseMap.groupBy(sampleListSix);
        System.out.println("*********************************************************************************************************************************");
        System.out.print("Flatten case before list : " + sampleListNine + "\nafter method = ");
        flatten(sampleListNine);
        System.out.println("*********************************************************************************************************************************");
        System.out.print("FlatMap case before list : " + sampleListTen + " after method = ");
        caseMap.flatMap(sampleListTen);
        System.out.println("*********************************************************************************************************************************");

    }


    public List<String> flatMap(List<String> getFlatList){
        List<String> results = Arrays.asList(getFlatList
                .stream()                                                     //Open the stream on List
                .map(String::valueOf)                                         //mapping all value on list
                .collect(Collectors.joining("")).split("\\s")); // all element split by space
        System.out.println(results);
        return results;
    }

    public static List<Object> flatten(List<Object> list) {
        List<Object> result = new ArrayList<>();
        LinkedList<Object> stack = new LinkedList<>(list);
        while (!stack.isEmpty()) {
            Object e = stack.pop();                     // create object with name "e"
            if (e instanceof List<?>)                   // e is a list check.
                stack.addAll(0, (List<?>)e);      // if return true this statement add 0. index this list on linked-list.
            else
                result.add(e);                          // else add directly on linked-list
        }
        System.out.println(result);
        return result;
    }


    public List<String> groupBy(List<String> list){
        Map<Integer, List<String>> results = list
                .stream()                                           // opening the stream
                .collect(groupingBy(String::length, toList()));     // and grouping by all element length and get a list again
        System.out.println(results);
        return list;
    }

     public List<Integer> union(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set = new HashSet<>(); // create set list because we want a unique list
        set.addAll(list1);                  // add list1 elements on set list but just unique elements
        set.addAll(list2);                  // add list2 elements on set list but just unique elements
        System.out.println(set);
        return new ArrayList<>(set);
    }


    public List<Integer> intersection(List<Integer> first , List<Integer> two ){
        List<Integer> intersection = first
                .stream()                   // opening the stream
                .filter(two::contains)      // filtering two list if contains list first
                .collect(toList());         // get a list again
        System.out.println(intersection);
        return intersection;
    }

    public List<Integer> sort(List<Integer> unsortedList){
        List<Integer> finalSorted = unsortedList
                .stream()                   // opening the stream
                .sorted()                   // sorted unsortedList
                .collect(toList());         // get a list again
        System.out.println(finalSorted);
        return finalSorted;

    }

    public String reduce(List<String> strList){
        String finalStr = String
                .join("", strList); // all elements join one string elements and return this string
        System.out.println(finalStr);
        return finalStr;
    }

    public List<Integer> filter(List<Integer> filteringList){
        List<Integer> finalList = filteringList
                .stream()                   // opening the stream
                .filter(x -> (x % 2 == 0))  // the filtering get list and this filter is mod 2 all list and get return true statements.
                .collect(toList());         // get a list again.
        System.out.println(finalList);
        return finalList;
    }

    public List<Integer> slice(List<Integer> list , int subFirst , int subLast){
        List<Integer> finalList =  list
                .subList(subFirst,subLast); // this code generate subList and return this subbing list
        System.out.println(finalList);
        return finalList;
    }

    public List<Integer> distinct(List<Integer> listing){
        List<Integer> returned = listing
                .stream()               // opening the stream
                .distinct()             // remove duplicate elements
                .collect(toList());     // get a list again
        System.out.println(Arrays.toString(returned.toArray()));
        return returned;
    }

    public List<Integer> mapping(List<Integer> listing){
        List<Integer> finalList = listing
                .stream()               // opening the stream
                .map(x -> (x*x*x))      // reach all element and get a cube all elements
                .collect(toList());     // get a list again
        System.out.println(finalList);
        return finalList;
    }

    public List<Integer> concatenate(List<Integer> listingOne, List<Integer> listingTwo){
        List<Integer> newList = Stream
                .of(listingOne, listingTwo)  // stream create was two list
                .flatMap(Collection::stream) // and flat mapping this stream
                .collect(toList());          // get a list again
        System.out.println(newList);
        return newList;
    }

    public List<Integer> difference(List<Integer> real , List<Integer> diff){
        List<Integer> difference = real
                .stream()                          // opening the stream
                .filter(x -> !diff.contains(x))    // filtering the list on a if dont contains in diff list
                .collect(Collectors.toList());     // get a list again
        System.out.println(difference);
        return difference;
    }

}
