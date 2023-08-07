package com.epam.mjc;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionService {

    public List<Integer> filterEvenNumbers(List<Integer> list) {
        return list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
    }

    public List<String> toUpperCaseCollection(List<String> list) {
        return list.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public Optional<Integer> findMax(List<Integer> list) {
        return list.stream().max(Integer::compareTo);
    }

    public Optional<Integer> findMin(List<List<Integer>> list) {
        return list.stream().flatMap(Collection::stream).min(Integer::compareTo);
    }

    public Integer sum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        var collectionService = new CollectionService();
        System.out.println(collectionService.filterEvenNumbers(IntStream.range(1, 23).boxed().collect(Collectors.toList())));
        System.out.println(collectionService.toUpperCaseCollection(List.of("asd", "qwe", "qwgh", "pixcv")));

        List<Integer> list1 = IntStream.range(5, 34).boxed().collect(Collectors.toList());
        List<Integer> list2 = IntStream.range(55, 314).boxed().collect(Collectors.toList());
        List<Integer> list3 = IntStream.range(43, 54).boxed().collect(Collectors.toList());

        System.out.println(collectionService.findMax(list1));
        System.out.println(collectionService.findMax(list2));
        System.out.println(collectionService.findMax(list3));

        System.out.println(collectionService.findMin(List.of(list1, list2, list3)));

        System.out.println(collectionService.sum(list1));
    }
}
