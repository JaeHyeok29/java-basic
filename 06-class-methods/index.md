# Class method

- 수학에서 함수(function)는 두 집합의 원소 사이에 n:1 (n>0인 정수) 이항 관계(binary relation)를 정의합니다.
- 프로그래밍 언어에는 컴퓨터 계산 절차를 수학의 함수처럼 간추릴 수 있는 표현 수단이 있는데 흔히 함수(function)나 프로시저(procedure)라고 합니다.
- Java에서는 method나 class method로 함수를 정의합니다.

## 문법

[sigma](Mathx.java) 함수를 보기로 들어 [class method를 정의하는 문법][classvars]을 살펴봅니다.

  - public [access modifier][accesscontrol]
  - static [class member][classvars]
  - return 데이터 타입
  - method 이름
  - paramter의 이름과 데이터 타입
  - method signature

## Name space

class가 constant(static final field)와 static method를 감싸며 name space를  가르는 역할을 합니다.
  - '광주 아카데미', '김해 아카데미'처럼 '아카데미'란 이름이 같아도 '광주'와 '김해'로 name space가 나뉘어 있으면 서로 다른 곳이라 구분할 수 있습니다.
  - `System.out.println()`에서 class 변수 out을 감싸는 java.lang.System은 name space를 정의합니다.
  - [`java.lang.Math`][Math]는 여러 수학 함수나 상수의 정의를 감싸는 name space입니다.
  - [package][package]와 비슷합니다.

## Convention

  - class method는 `Math.random()`처럼 className.methodName으로 씁니다.[^staticimport]

## 연습

### 구의 부피

  1. 구(sphere)의 반지름(radius)이 r일 때, 구의 부피(volume)를 구하는 공식을 찾습니다.
  1. Mathx.sphereVolume으로 공식을 구현합니다. double type으로 연산합니다.
  1. TestMathx.testSphereVolume에서 반지름이 6 cm인 구의 부피를 구합니다.

### 마구잡이 정수
  1. Math.random() 값을 $[min, max)$ 사이의 정수로 바꾸는 공식을 찾습니다.
  1. $[min, max)$ 사이 마구잡이 정수를 구현하는 Mathx.random(int, int) 정의합니다.[^random]

  <!-- 링크 -->
[Math]: https://docs.oracle.com/javase/tutorial/java/data/beyondmath.html
[static import]: https://docs.oracle.com/javase/tutorial/java/package/usepkgs.html#staticimport
[classvars]: https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html
[accesscontrol]: https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
[package]: (https://docs.oracle.com/javase/tutorial/java/package/index.html)

<!-- 주석 -->
[^staticimport]: [**static import**][static import]로 class 이름 없이 함수나 상수 이름을 그냥 쓸 수 있습니다. static import는 class의 (static) name space를 지금 정의하는 namespace와 합치는 효과를 냅니다.

      ```java
      import static java.lang.Math.*; // static import

      public class MergingNamespaces {
          public static void main(String[] args) {
              System.out.println(random());
              System.out.println(PI);
          }
      }
      ```
    - Math.이 없어서 코드가 짧고 보기 좋을 수도 있습니다.
    - 일부러 나눈 공간을 다시 뭉치면 코드를 읽거나 다루기 어려운 경우가 더 많습니다.
    - 이득이 확실하지 않다면 쓰지 않는게 낫습니다.

[^random]:  [여기와](https://www.baeldung.com/java-generating-random-numbers-in-range) 비교해 보세요.
