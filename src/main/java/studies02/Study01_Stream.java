package studies02;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Study01_Stream {

    @Test
    public void streamFilter(){

        ArrayList<String> names = new ArrayList<>();
        names.add("Mertens");
        names.add("Sergio");
        names.add("Vıctor");
        names.add("Torreira");
        names.add("Sacha");
        Long c = names.stream().filter(s -> s.startsWith("S")).count();
        System.out.println(c);

        Long d = Stream.of("Mertens", "Sergio", "Vıctor", "Torreira", "Sacha").filter(s ->
        {
            s.startsWith("A");
            return true;
        }).count();
        System.out.println(d);

        names.stream().filter(s -> s.length() > 6).forEach(s -> System.out.println(s));
        names.stream().filter(s -> s.length() > 6).limit(1).forEach(s -> System.out.println(s));
    }

    @Test
    public void streamMap(){

        Stream.of("Mertens", "Sergio", "Vıctor", "Torreira", "Sacha").filter(s -> s.endsWith("a"))
                        .map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        List<String> names = Arrays.asList("Mertens", "Sergio", "Vıctor", "Torreira", "Sacha");
        names.stream().filter(s -> s.startsWith("S")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
    }

    @Test
    public void streamConcat(){

        ArrayList<String> names = new ArrayList<>();
        names.add("Dubois");
        names.add("Rachica");
        names.add("Mata");

        List<String> names1 = Arrays.asList("Mertens", "Sergio", "Vıctor", "Torreira", "Sacha");

        Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
        //newStream.sorted().forEach(s -> System.out.println(s));

        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Mata"));
        Assert.assertTrue(flag);
    }

    @Test
    public void streamCollect(){

        List<String> ls = Stream.of("Mertens", "Sergio", "Vıctor", "Torreira", "Sacha").filter(s -> s.endsWith("a"))
                .map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));

        List<Integer> values = Arrays.asList(4, 8, 9, 5, 6, 2, 7, 5, 9, 3, 5);
        values.stream().distinct().forEach(s -> System.out.print(s + " "));

        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("\n" + li.get(2));
    }

}
