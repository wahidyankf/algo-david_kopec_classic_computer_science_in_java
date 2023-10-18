package ch01_small_problems;

import java.util.HashMap;
import java.util.Map;

public class Fib {
  static Map<Integer, Integer> memo = new HashMap<>(Map.of(0, 0, 1, 1));

  public static void main(String[] args) {
    System.out.println("fib 1: no base case");
    try {
      System.out.println(fib1(5));
    } catch (StackOverflowError e) {
      System.out.println("Stack overflow");
    }

    System.out.println("fib 2: with base case");
    // res: 0
    System.out.println(fib2(0));
    // res: 5
    System.out.println(fib2(5));
    // 55
    System.out.println(fib2(10));
    // it will take a long time
    // System.out.println(fib2(100));

    System.out.println("fib 3: with memoization");
    // res: 5
    System.out.println(fib3(5));
    // res: 102334155
    System.out.println(fib3(40));
    // res: integer overflow, but fast
    System.out.println(fib3(100));

    System.out.println("fib 4: iterative approach");
    // res: 5
    System.out.println(fib4(5));
    // res: 102334155
    System.out.println(fib4(40));
    // res: integer overflow, but fast
    System.out.println(fib4(100));
  }

  public static int fib4(int n) {
    int last = 0, next = 1;
    for (int i = 0; i < n; i++) {
      int oldLast = last;
      last = next;
      next = oldLast + next;
    }
    return last;
  }

  public static int fib3(int n) {
    if (!memo.containsKey(n)) {
      // memoization step
      memo.put(n, fib3(n - 1) + fib3(n - 2));
    }

    return memo.get(n);
  }

  public static int fib2(int n) {
    if (n < 2) {
      return n;
    }
    return fib2(n - 1) + fib2(n - 2);
  }

  // this will cause stack overflow (no base case)
  private static int fib1(int n) {
    return fib1(n - 1) + fib1(n - 2);
  }
}