# Repetition

## Iteration

### 준비

- [while](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html), [for](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html)
    - WhileDemo, DoWhileDemo, ForDemo, EnhanceForDemo
- [Q&E](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/QandE/questions_flow.html)

> **note**
- [branching statement](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/branch.html)(break, continue), 필요한가요?

### factorial

- iterative defintion

$$
n! =
\begin{cases}
1, & n = 0 \\
n! = \Pi_{i=1}^{n}i = 1 * 2 * 3 \dots (n-1) * n, & n > 1
\end{cases}
$$

- iterative implementation (조심: 일부러 풀어 놓은 Bug!!가 있습니다.)

```java
//Test first
public class TestFactorial {

    public static void testBaseCase() {
        assert Mathx.factorial(0) == 1;
    }

    public static void testInductiveCase() {
        // not exhaustive but practical?
        int[] values = new int[] {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};
        for (int i = 0; i <= values.length; i++) {
            assert Mathx.factorial(i) == values[i];
        }
    }
}
```

```java
public class Mathx {
    public static int factorial(int n) {
        int product = 1;
        int counter = 1;
        while (counter < n) { // Loop Invariant
            product *= counter;
            counter++;
        }
        return product;
    }

    // ...
}
```
- [loop invariant](https://en.wikipedia.org/wiki/Loop_invariant)
- counter를 쓰지 않고 n 값을 줄이면서 loop를 도는 코드와 비교해 봅니다.

```java
public class TestMathx {
    public static void main(String[] args) {
        TestMathx.testFactorial();
    }

    private static void testFactorial() {
        TestFactorial.testBaseCase();
        TestFactorial.testInductiveCase();
    }

    // ...
}
```

- linear iterative (vs. recursive) process
- Recursive version과 비교해서 계산에 드는 시간과 공간은 n에 비례하여 어떻게 자라나는가?

## Order of Growth

- 문제의 크기가 커지면 문제의 계산하는데 드는 자원(줄여서 계산 자원, Computational Resource)은 얼마나 자라나는가?
    - 계산 자원 = 시간과 공간으로 나누어서 잰다.
    - 문제의 크기를 곧바로 알 수 없는 경우도 다수
    - $n!$ 문제나 $F_n$ 문제에서는 n이 문제의 크기로 곧 바로 문제의 크기를 파악할 수 있는 경우
- 계산에 드는 총 계산 자원 소비량의 나타내는 척도: $\theta(R(n))$
    - $R(n)$은 문제의 크기 (또는 입력) n에 따라 계산 과정(computational process)에서 쓰는 시간 또는 공간이 자라나는 정도를 간추린 함수
    - 줄여서 Computational Complexity(계산 복잡도)
    - Time Complexity(시간 복잡도), Space Complexity(공간 복잡도)라는 말도 널리 씁니다.
- 보기
    - Mathx.factorial(n)의 recursive vs. iterative version의 n에 따른 계산 시간 함수 $T(n)$은 대략 $2n$ vs. $n$이지만 Time Complexity는 $R(n) = n$, 곧 상수 계수는 n 곧 문제의 크기에 따른 계산 시간이 얼나마 늘어나는지에 영향을 미치지 않기 때문에 무시
    - 이를 테면 문제 크기가 n인 두 문제 $f, g$의 process가 n의 시간(공간) 함수 $f(n) = an^3 + bn^2 +c$, $g(n) = 10^8n^3$로 늘어 난다면 Computational (또는 따로 Time 또는 Space) Complexity는 $\theta(n^3)$

## 연습

### Debugging

- TestMathx를 통과하도록 Bug을 잡습니다.

### Fibonacci

- TestFibonacci를 만듭니다.
- Mathx.fibonacci의 type signature를 (Dummy) 구현합니다.
- TestMathx.testFibonacci를 만들고 test합니다.
- Mathx.fibonacci의 iterative version을 만듭니다. 정의대로 계산하는 과정을 펼쳐보면 앞 단계에서 계산한 값을 어떻게 뒷 단계로 옮겨 담아서 계산 값을 누적하며 되돌이 식을 꾸밀지가 눈에 드러 납니다. 보입니다.

    $$
        F_2 = F_1 + F_0 \\
        F_3 = F_2 + F_1  \\
        F_4 = F_3 + F_2  \\
        \dots
    $$

- Recursive version과 비교해서 계산에 드는 시간과 공간은 n에 비례하여 어떻게 자라납니까? 시간과 공간의 R(n)은 Recursive version과 견주어 얼마나 좋아지거나 나빠졌나요?
