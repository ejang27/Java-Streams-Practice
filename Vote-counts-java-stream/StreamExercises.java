/*
Name: Eunsoo Jang
File: StreamExercises.java
Date: 11/28/2018

*/



import java.util.*;
import java.util.stream.*;

public class StreamExercises {

  public static void main (String [] args){

    System.out.println(longest(Arrays.asList("these","are","some","strings","in","a","list")));
    // prints Optional[strings]

    System.out.println(longest(new ArrayList<>()));
    // prints Optional.empty

    System.out.println(top5(Stream.of(6,2,9,10,3,8,6,34)).collect(Collectors.toList()));
    // prints [34, 10, 9, 8, 6]

    System.out.println(sumPrimes(5,15));
    // prints 36

    System.out.println("\nMy own tests: ");
    List<String> example = new ArrayList<String>();
    example.add("on");
    example.add("two");
    example.add("three");
    example.add("four");
    example.add("fiveee");
    System.out.println(longest(example));
    System.out.println(sumPrimes(2,6));


  }

  //longest: takes in a list of strings and returns the longest string.
  public static Optional<String> longest (List<String> strings){
    return strings.stream().max(Comparator.comparing(String::length));
  }

  //top5: sorts an input and returns the top 5
  public static <A extends Comparable<? super A>> Stream<A> top5(Stream<A> input){
    return input.sorted(Comparator.reverseOrder()).limit(5);
  }

  //isPrime: helper function for the sumPrimes function that filters all the prime numbers up until n.
  public static boolean isPrime(int n)
  {
    return n > 1 && IntStream.range(2,n).filter(d -> n % d == 0).count() == 0;
  }

  //sumPrimes: returns sum of all the prime numbers between lo and hi.
  public static int sumPrimes(int lo,int hi){
    if(hi<1||hi<lo){
      return -1;
    }
    else{

      return IntStream.range(lo,hi).filter(StreamExercises::isPrime).sum();
    }

  }

}
