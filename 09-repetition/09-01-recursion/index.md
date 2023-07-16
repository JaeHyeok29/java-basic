# Repitition[^sicp12]

## Recursion

음이 아닌 정수 n의 factorial을 정의하는 등식(equation)입니다.

$$
n! = n * (n-1)!
$$

정의대로 옮겨 씁니다.

```java
public class Mathx {
    public static int factorial(int n) {
        return n * factorial(n - 1);
    }
}
```

TestMathx.testFactorial에서 Mathx.factorial(10)을 돌려보면

```console
# cr TestMathx = javac TestMathx.java && java TestMathx
$ javac Mathx.java && cr TestMathx 2>&1 | more
Exception in thread "main" java.lang.StackOverflowError
        at Mathx.factorial(Mathx.java:5)
        at Mathx.factorial(Mathx.java:5)
        at Mathx.factorial(Mathx.java:5)
        at Mathx.factorial(Mathx.java:5)
        at Mathx.factorial(Mathx.java:5)
        ...
```

계산이 끝나지 않습니다. 정의에서 $n=0$인 경우를 빼먹었습니다.

$$
n! =
\begin{cases}
1, & n = 0 \\
n * (n-1)!, & n > 1
\end{cases}
$$

```java
public class Mathx {
    public static int factorial(int n) {
        return n == 0 ? 1 : n * Mathx.factorial(n - 1);
    }
}
```

```console
$ javac Mathx.java && java TestMathx
3628800
```

$n!$의 계산을 더 작은 두 가지 계산으로 나누어 푸는 것을 눈여겨봅니다.
 - $n!$의 정의에서 $n=0$인 경우를 base case, $n \gt 1$인 경우를 inductive case(또는 recursive case)라고 합니다.
 - $n!$을 계산하는 문제의 크기는 n의 크기와 같습니다.
    - $n=0$ 곧 문제의 크기가 가장 작을 때, 문제는 곧바로 풀려서 계산 결과가 1로 떨어집니다. 더 남은 계산은 없습니다.
    - $n \gt 0$ 곧 문제가 크기가 그보다 클 때는, 문제의 크기를 줄이면서 n이 끝내 base case에 다다를 때까지 같은 계산을 되풀이합니다.
    - 이런 문제 풀이 방식을 recursion이라고 합니다.

Recursion은 되풀이(반복, repetition) 계산을 표현하는 방법 가운데 하나입니다. 복잡하고 어려운 문제를 더 단순하고 쉬운 문제로 나누어 푸는 데 (divide-and-conquer) 도움이 됩니다. Recursion으로 설계한 계산 방식은 induction(수학 귀납법, mathematical induction)으로 증명할 수 있습니다.

### Recursive Process

Mathx.factorial(3)의 계산(evaulation)을 추적(trace)합니다.

```java
factorial(3)
3 * factorial(2)
3 * 2 * factorial(1)
3 * 2 * 1 * factorial(0)
3 * 2 * (1 * 1)
3 * (2 * 1)
(3 * 2 * 1)
6
```

꼬리를 물며 이어지던 method call이 더는 없을 때까지, 마무리 못 한 연산을 차곡차곡 기억합니다.
마침내 factorial(0)에 다다르면 기억을 거슬러 미뤄둔 연산을 하나씩 꺼내어 마무리합니다.
Last-In-First-Out(LIFO)으로 연산의 기억을 쌓고(push) 꺼내기(pop) 때문에,
흔히 [call stack][callstack]이라고 합니다.
Recursion은 call stack을 써서 같은 계산을 되풀이합니다.
Recurive method가 (recursive  procedure가) 만드는 recursive process가 어떤 모양[^linear]으로 자라나는지 그려보는 것은 프로그램을 읽고 이해하는 힘을 기르는 데 큰 도움이 됩니다.

> **note:**
- call stack (of activation records), lexical scoping, substition, evaluation, evironment를 조금 더 깊이 알고 싶다면 [closure](../09-01-sidetrip-closure/)를 공부합니다.

---

$n$ 번째 Fibonacci 수 $\{F_n\}$는

$$
F_n =
\begin{cases}
0, & n = 0 \\
1, & n = 1 \\
F_{n-1} + F_{n-2}, & \forall n \geqslant 2
\end{cases}
$$

Recursion으로 계산을 되풀이합니다.

```java
public class Mathx {
  public static int fibonacci(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }
}
```

[Mathx.fibonacci(5)](https://mitp-content-server.mit.edu/books/content/sectbyfn/books_pres_0/6515/sicp.zip/full-text/book/book-Z-H-11.html#%_sec_1.2.2)의 recursive process가 나무처럼 자랍니다.[^tree]

### 연습

- Mathx.factorial에서 call stack의 push와 pop이 일어나는 순간을 기록하면 process를 모양을 그릴 수 있습니다. Recursion stack을 추적 [^stacktrace]하는 코드를 더해서 RecursiveProcess.factorial method를 짭니다.

```console
$ cr RecursiveProcess 3
factorial(3)
3 * factorial(2)
2 * factorial(1)
1 * factorial(0)
factorial(0) = 1
1 * factorial(0)
2 * factorial(1)
3 * factorial(2)
6
```

- [파스칼 삼각형](https://ko.wikipedia.org/wiki/파스칼의_삼각형)에서 n 번째 줄의 k 번째 값을 (이항 계수를) 구하는 Mathx.binomialCoefficient(int n, int k)[^binomialcoefficient]를 만듭니다.
    - TestMathx.testBinomialCoefficient()에서 실험하고 검사하는 코드를 씁니다.
    - [Recurrence relation (recurrence fomula)](https://math.stackexchange.com/questions/2001859/find-a-binomial-term-general-formula-for-recurrence-relation) 그대로를 recursion으로 구현합니다.
    - Mathx.factorial만 써서 구현합니다. 이렇게 만들면 recursion으로 계산을 되풀이한다고 할 수 있나요?

[callstack]:https://kdoore.gitbook.io/cs1335-java-and-processing/getting-started/recursion/recursion-call-stack

[^sicp12]: [SICP 2nd Ed. 1.2  Procedures and the Processes They Generate](https://mitp-content-server.mit.edu/books/content/sectbyfn/books_pres_0/6515/sicp.zip/full-text/book/book-Z-H-11.html#%_sec_1.2)을 빌려 씁니다.
[^linear]: method call이 n과 나란하게 (또는 n에 비례하여, linearly with n) 늘어나면서 한 줄로 잇달아 늘어서기 때문에 linear recursive process라고 합니다.
[^tree]: method call이 n에 기하급수로 (exponentially with n) 늘어나면서 나무 가지처럼 퍼져가기 때문에 tree-recursive process라고 합니다.
[^stacktrace]: Stack trace API를 쓰지 않고 풉니다. Bug를 잡으려고 call stack을 추적할 때는 [`Thread.currentThread().getStackTrace()`](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#getStackTrace())를 씁니다. [Apache Commons Lang](https://commons.apache.org/proper/commons-lang/javadocs/api-release/index.html)의 ExceptionUtils도 도움이 됩니다.
[^binomialcoefficient]: 이항 계수(binomial coefficient), 원소가 n 개 있는 집합에서 k개를 고르는 방법 곧 그러한 조합(combination)의 값과 같습니다.
