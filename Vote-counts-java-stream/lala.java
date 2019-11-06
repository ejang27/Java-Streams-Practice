/*
Name: Eunsoo Jang
Date: 11/28/2018

*/


import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Vote {

  public static void main (String [] args) throws IOException {
    final int[] sumVotes = new int[2];
    sumVotes[0] = 0;
    sumVotes[1] = 0;
    Stream<String> lines = new BufferedReader(new FileReader("voterdata.csv")).lines();
    Stream <String[]> demoArray = lines.filter(e->e.contains("Governor")).filter(e->e.contains("Republican")||e.contains("Democratic")).map(e->e.split(";"));
    demoArray.forEach(e->{
      if(e[4].equals("Democratic")){
        //demoRep.changeFirst(Integer.parseInt(e[6]));
        sumVotes[0]+=Integer.parseInt(e[6]);
        }
      else{
        sumVotes[1]+=Integer.parseInt(e[6]);
      }
      });

    System.out.println("Total of Democratic votes: " + sumVotes[0]);
    System.out.println("Total of Republican votes: " + sumVotes[1]);


    //List<String[]> asList = lines.filter(e->e.contains("Governor")).map(e->e.split(";")).collect(Collectors.toList());

    //int demo = demoArray.filter(e->e[4].equals("Democratic")).mapToInt(e->Integer.parseInt(e[6])).sum();
    //demoArray.tuple()

    //demoRep.map(sum(),sum());
    /*Stream <String[]> repArray = lines
      .filter(e->e.contains("Governor"))
      .filter(e->e.contains("Republican"))
      .map(e->e.split(";"));
*/
    //int rep = demoArray.filter(e->e[4].equals("Republican")).mapToInt(e->Integer.parseInt(e[6])).sum();

    //System.out.println(demo);
    //System.out.println(rep);
    //Stream<Tuple<Integer,Integer>> tuple = demoArray.filter(e->e.map())
  }
  Function<Integer, UnaryOperator<Integer>> sum = x -> y -> x + y;
  Function<Integer,Integer> add = x -> x+1;
  Tuple<Integer,Integer> demoRep = new Tuple<Integer, Integer> (0,0);
  Stream<String> lines = new BufferedReader(new FileReader("voterdata.csv")).lines();
  Stream <String[]> demoArray = lines.filter(e->e.contains("Governor")).filter(e->(e.contains("Republican")||e.contains("Democratic"))).map(e->e.split(";"));
  demoArray.forEach(e->{
    if(e[4].equals("Democratic")){
      //Function<Integer, Integer> add1 = sum.apply(Integer.parseInt(e[6]));
      demoRep.mapFirst(add1);
    }
    else{
      //demoRep.changeSecond((Integer.parseInt(e[6])).sum());
      Function<Integer, Integer> add2 = sum.apply(Integer.parseInt(e[6]));
      demoRep.mapFirst(add2);
    }
    });

  System.out.println("Total of Democratic votes: " + demoRep.fst);
  System.out.println("Total of Republican votes: " + demoRep.snd);
  }
