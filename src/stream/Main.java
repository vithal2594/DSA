package stream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
         // Q) create a list and filter all even numbers from list
        List<Integer> list1 = List.of(2,4,50,21,22,67);
        // List<Integer> list2 = new ArrayList<>();
        // list2.add(12);
        // list2.add(34);
        // list2.add(23);
        // list2.add(78);

        //without streams
        List<Integer> listeven = new ArrayList<>();
        for(Integer i : list1){
            if(i % 2 == 0){
                listeven.add(i);
            }
        }
        System.out.println(list1);
        System.out.println(listeven);

        //withStreams
        List<Integer> listofeven = list1.stream().filter(i -> i %2 == 0).collect(Collectors.toList());
        System.out.println(listofeven);

        List<Integer> listofodds = list1.stream().filter(i->i % 2 != 0).collect(Collectors.toList());
        System.out.println(listofodds);
    }
}
