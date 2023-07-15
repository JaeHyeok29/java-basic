# Boolean Expressions

- return type이 [boolean][Boole] 곧 true,false를 내놓는 함수를 predicate[^predicate]이라고 합니다.
- [Equality, Relational Operator는][op2] 모두 predicate입니다.[^teaching]
    - ComparisonDemo 연습
- [Conditional Operator로][op2] 복잡한 boolean expression을 조립할 수 있습니다.[^bitwise]
    - ConditionalDemo 연습
- [Questions and Exercises: Operators][questions_operators]을 풉니다.

## 연습

if를 쓰지 않고 풉니다.

1. majority
    - boolean 값을 셋 받아서 true가 둘보다 많으면 true 아니면 false라 답하는 MajorityTest.majority를 정의합니다.[^majority]
    - command line에서 세 String을 받아 boolean 값으로 바꾸고 majority를 판단하는 application으로 고칩니다. Boolean.parseBoolean(String)을 씁니다.
1. even
    - 짝수를 판별하는 predicate Mathx.even을 구현하고 TestMathx.testEven()에서 Mathx.random으로 뽑은 int 값으로 test합니다.
    - 홀수를 판별하는 Mathx.odd도 만들어 같은 방식으로 test합니다.
1. kinetic energy
    - 질량 $m$, 속력 $v$인 물체의 운동에너지는 ${1 \over 2} mv^2$입니다.
    - 운동에너지를 구하는 method는 Physics.kineticEnergy 입니다.
    - 두 자동차의 질량과 속력를 받아 첫 자동차의 운동에너지가 두 번째보다 크면 true 아니면 false를 찍는 application을 짭니다.
    모든 수는 double type입니다.

[op2]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html
[Boole]: https://en.wikipedia.org/wiki/George_Boole
[op3]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
[questions_operators]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/QandE/questions_operators.html

[^predicate]: predicate logic (술어 논리)의 predicate을 말합니다.
    - 2는 짝수라는 참인 명제(proposition)에서 2를 미지수 x로 두고 술어를 분리하면 'x는 짝수'인지를 판별하는 함수 곧 predicate이 됩니다.
[^teaching]: instanceof 연산자는 subtyping과 함께 공부합니다.
[^majority]:  [여기에](https://introcs.cs.princeton.edu/java/21function/) 정답이 있습니다.
[^bitwise]: 정수의 bit 표현을 [bit 단위 operator로][op3] 연산할 수 있습니다.

<!-- TODO:
    - kinetic energy, majority 문제 원본 표시
    - on to java 23 boolean expression의 연습 문제 다음어서 보태기
    - &&, ||의 계산 규칙이 shortcut 방식이라는 걸 예시하는 퀴즈 내기
        - 한 쪽이 Exception이 나는 경우
        - 한 쪽의 assignment가 무시되는 경우
        - 둘 다 바람직하지 않다는 점을 명시
        - 이 예시와 동일한 결과를 내는 if 문을 보여주면 뭐가 더 readable한지 묻는 문제를 if 나오는 곳에서 more로 묻기
    - java.util.function.Predicate<T>를 써서 predicate function 정의하고 쓰는 보기
        - characteristic function 예제가 딱이야
    - Predicate<T>를 만들어 보거나 -->
