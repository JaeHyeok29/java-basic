# 공부 거리

- 연산자와 연산을 구분지어 설명할 수 있나요? 'Operation vs. Operator'로 검색한 정보를 한 줄로 간추려서 정리합니다.
- [ParseInteger.java](ParseInteger.java)에서:
    - `java ParseInteger 123 123 123`의 결과는? 왜 이런 결과가 나오나요?
    - `java ParseInteger 0.12 0.12 0.12`의 결과는? 왜 이런 결과가 나오나요?
    - 숫자(numerals, digits, numeric literals)와 수(number)의 차이를 설명하세요.
- Regular Expression(정규 표현, RE)으로 variable의 naming 규칙을 적습니다.
  1. RE(https://docs.oracle.com/javase/tutorial/essential/regex/intro.html)를 공부합니다.
  1. RE에 속하는 string 검사 [code][retest]를 내려받아 제대로 돌아가는지 [실험][regex]합니다.
  1. 정수, 실수, 변수의 naming 규칙을 명시하는 RE을 준비합니다.
  1. 규칙을 따르는 보기 5개, 어기는 보기 5개를 준비합니다.
  1. RE에 문제가 있다면 이유가 무엇인지 설명합니다.

## Java on Linux

cr은 인자를 하나만 받기 때문에 ParseInteger처럼 command line 인자를 받는 application에 인자를 넘기지 못합니다.

  ```console
  $ ./cr ParseInteger
  Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
    at ParseInteger.main(ParseInteger.java:3)
  $ ./cr ParseInteger 123 123 123
  cr <filename without .java>
  ```

  - cr이 `$2`부터 이어지는 [shell 스크립트 인자][args]를 Java application에 넘기도록 만들려고 합니다.
    -  $1.java 파일이 있다면 `$1`을 변수 filename에 저장합니다.
    - [`shift 1`][shift]으로 `$1`을 인자에서 뺍니다.
    - `java "$filename" "$@"`로 나머지 인자를 모두 Java application에 넘깁니다.
      - 왜 [shell 변수에 `""`을][quotes] 치나요?
      - [`"$@"` 대신에 `"$*"`를][allargs] 쓰면 어떻게 되나요? `$@` 대신에 `$*`를 쓰면 어떻게 되나요?

## 도전 과제

- 산술 식에서 expression tree를 뽑아내는 절차를 적으세요.
- expression tree를 타고 오르며 값을 계산하는 절차를 적으세요.[^interpreter]

<!-- TODO: 사칙 연산을 할 수 있는 stack-based machine의 instruction set(byte code)을 주고, evaluation을 byte code로 번역하는 간단한 컴파일러를 만드는 문제를 여기서 또는 자료 구조를 가르치는 데서 내도 좋겠다.  -->

<!-- 링크 -->
[regex]: https://docs.oracle.com/javase/tutorial/essential/regex/char_classes.html
[retest]: https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/essential/regex/examples/RegexTestHarness.java
[args]: https://www.redhat.com/sysadmin/process-script-inputs
[shift]: https://unix.stackexchange.com/questions/174566/what-is-the-purpose-of-using-shift-in-shell-scripts
[quotes]:https://stackoverflow.com/questions/10067266/when-to-wrap-quotes-around-a-shell-variable
[allargs]:https://stackoverflow.com/questions/22589032/what-is-the-difference-between-and

<!-- 각주 -->
[^interpreter]: 두 단계를 이어 붙이면 식을 읽어서(Read) 계산(Evaluate)하고 결과를 찍는(Print) 산술 연산 프로그래밍 언어의 REP(Read-Eval-Print) 프로그램을 짤 수 있습니다. 이런 프로그램을 흔히 interpreter라고 합니다.
[^assignment]: '할당'이나 '배정' 연산자라고 하지 않고 assignment라고 씁니다. 글의 흐름에 따라서는 변수의 값을 바꾼다거나 고친다고 씁니다.
