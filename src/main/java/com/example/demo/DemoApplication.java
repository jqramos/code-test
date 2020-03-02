package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.max;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);

    SpringApplication.run(DemoApplication.class, args);
    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] q = new int[n];

      String[] qItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int qItem = Integer.parseInt(qItems[i]);
        q[i] = qItem;
      }

      minimumBribes(q);
    }
  }


  static int alternatingCharacters(String s) {
    List<String> words = Arrays.asList(s.split(""));
    long count = IntStream.range(1, words.size()).filter(i -> words.get(i).equals(words.get(i - 1)) ).count();
    return Math.toIntExact(count);
  }

  static int makeAnagram(String a, String b) {
    List<String> bWord = new ArrayList<String>(Arrays.asList(b.split("")));
    long count = Arrays.stream(a.split("")).filter(x -> !bWord.remove(x)).count();
    int result = bWord.size() + Math.toIntExact(count);
    return result;
  }



  static void checkMagazine(String[] magazine, String[] note) {
    List<String> magList =  new ArrayList<String>(Arrays.asList(magazine));
    boolean result = Arrays.stream(note).anyMatch(
        x->
            !magList.remove(x));
    System.out.println(result ? "No" : "Yes");

  }

  static void minimumBribes(int[] q) {

    final int[] finalAns = {0};
    final int[] length = {q.length};
    final boolean[] stop = {false};
    int bound = length[0] -1;
    for (int ind = bound; ind >= bound; ind--) {
      if (q[ind] - (ind + 1) > 2) {
        System.out.println("Too chaotic");
        return;
      }
      int start = Integer.max(0, q[ind] - 2);
      for (int index = start; index < ind; index++) {
        if (q[index] > q[ind]) finalAns[0]++;
      }
    }
    System.out.println(finalAns[0]);
//    for (int i = q.length - 1; i >= 0; i--) {
//      if (q[i] - (i + 1) > 2) {
//        System.out.println("Too chaotic");
//        return;
//      }
//      for (int j = Integer.max(0, q[i] - 2); j < i; j++) {
//        if (q[j] > q[i]) ans++;
//      }
//    }
//    System.out.println(ans);
  }

  static long repeatedString(String s, long n) {
    long count = s.chars().filter(r -> r == 'a').count();
    long iteration = n / s.length();
    count = iteration * count;
    for (int i = 0; i < n % s.length(); i++) {
      if (s.charAt(i) == 'a') {
        count++;
      }
    }
    return count;
  }

  static int countingValleys(int n, String s) {
    int level = 0;
    int valleys = 0;
    for (int i = 0; i < n;i++) {
      level = (s.charAt(i) == 'U') ? ++level : --level;
      if (level == 0 && s.charAt(i) == 'U') {
        valleys++;
      }
    }
    return valleys;
  }

  static int jumpingOnClouds(int[] c) {
    int jumps = 0;
    int length = c.length;
    for (int i = 0; i < length;i++) {
      if (i+2 < length && c[i+2] == 0) {
        i = i+1;
      } else if (!(i+1 < length && c[i+1] == 0)) {
        break;
      }
      jumps++;
    }
    return jumps;
  }


  static int sockMerchant(int n, int[] ar) {
    int pairs = 0;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int input = ar[i];
      Integer check = list.stream().filter(x -> x.equals(input)).findAny().orElse(null);
      if (check != null) {
        list.remove(check);
        pairs++;
      } else {
        list.add(ar[i]);
      }
    }

    return pairs;

  }
}
