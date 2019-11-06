/*
Name: Eunsoo Jang
File: Vote.java
Date: 11/28/2018

*/


import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;


public class Vote {

  public static void main (String [] args) throws IOException {

    //making an inital tuple to later use in the reduse.
    Tuple<Integer,Integer> init = new Tuple<Integer,Integer> (0,0);

    Stream<String> lines = new BufferedReader(new FileReader("voterdata.csv")).lines();

    //filtering out everything that isn't Governor and Democratic/Republican votes.
    Stream <String[]> demoArray = lines.filter(e->e.contains("Governor")).filter(e->(e.contains("Republican")||e.contains("Democratic"))).map(e->e.split(";"));

    //putting in the votes of Democratic votes in the first of Tuple result and Republican votes in the second.
    Tuple<Integer,Integer> result = demoArray.map(e->e[4].equals("Democratic")? new Tuple<Integer,Integer> (0,Integer.parseInt(e[6])): new Tuple<Integer,Integer>(1,Integer.parseInt(e[6]))).reduce(init, (a,b)->{
    if(b.fst==0){
      return a.changeFirst(a.fst + b.snd);
    }
    else{
      return a.changeSecond(a.snd + b.snd);
    }
    });


  //Printing out the results.
    System.out.println("Total of Democratic votes: " + result.fst);
    System.out.println("Total of Republican votes: " + result.snd);

  }

}
