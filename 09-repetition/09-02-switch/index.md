# switch

```java
public class Mathx {
  public static int fibonacci(int n) {
    switch (n) {
      case 0:
        return 0;
      case 1:
        return 1;
      default:
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }
```

- return 0; 지우면? (fall-through 조심, default 빼먹을 때 조심)
- return 대신에 모두 break를 쓰면?
- switch (n) .. 에서 n에 올 수 있는 type은?

<!--
TODO:
( Java v12 ~ v17: break value; yield value; Switch Expression) -->

# 연습

- Mathx.binomialCoefficient(int n, int k)의 recursion 판에서 if statement 대신에 switch를 쓰도록 고치세요.
- 년과 월 두 숫자를 받아 월의 날짜 수를 구하는 프로그램[^SwitchDemo2]을 짭니다. switch 쓰고 fall-through하도록 짭니다. (윤년 따지는 문제)

[^SwitchDemo2]: https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/java/nutsandbolts/examples/SwitchDemo2.java
