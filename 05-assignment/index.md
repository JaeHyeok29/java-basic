## Assignment

- [PrePostDemo를][op1] 이해하고 돌려 봅니다.
- [Compound Assignment Operator의 예시를][compound] 돌려보면서 이해를 다집니다.
- [expression과 statement의 차이를][expressions] 이해합니다.

### 문제

- =(Assignment Operator)는 오른 결합 연산자(right associative operator)입니다.

  ```java
  (x = y) = 5;
  ```

    - 왼 결합 규칙을 따르면 어떤 문제가 생길 수 있는지 위 식의 comilation error message를 보고 설명합니다.
    - assignment[^assignment] 연산의 오른 결합 규칙을 설명할 때 lvalue, rvalue라는 기술 사투리도 씁니다.
      - lvalue, rvalue는 무엇을 가리키는 말인가요?
      - lvalue, rvalue로 왼 결합 규칙의 문제를 다시 설명하세요.

- 아래 코드를 compile 합니다.

  ```java
  int value = 57;

  value = value + 1;
  ++value;
  43 + value;
  ```

    - `int value = 57`은 =(assignment 연산자)를 씁니다.
      - initialization인가요? assignment인가요? Java에서는 둘에 차이가 있나요?
        - 둘을 달리 볼 필요가 있나요 없나요? 있다면 어떤 의미가 있고 없다면 왜 그런가요?
      - statement인가요? expression인가요? 왜 그런가요?
    - `43 + value`에서 error가 납니다. statement가 아니라서 그렇습니다.
      - `value = value + 1`은 error가 나지 않습니다. Assignment statement인가요? 아니면 assignment expression인가요?
    - 단항 연산자 ++는 산술 연산자인가요?
      - ++value는 expression인가요? statement인가요?

[op1]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html
[compound]: https://www.baeldung.com/java-compound-operators
[expressions]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/expressions.html

[^assignment]: '할당', '배정', '대입' 연산(자)라고 하지 않고 assignment라고 씁니다. 글의 흐름에 따라서는 '변수 ~의 값을 ~로 바꾼다'라고 씁니다.
