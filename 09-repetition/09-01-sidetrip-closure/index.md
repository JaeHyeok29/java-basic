# Closure[^closure]

## Variable?

변수에서 무엇이 '변'하는 것일까요?

### Substitution

> 식(expression) 속에서 값(다른 식)이 들어갈 자리(place-holder)와 조건(data type)을 간추려 이름 붙인 (abstraction 한)  것

- Expression을 evaluation하려면 식 속의 이름이 가리키는 데이터(값, Type, Scope 따위)를 찾아 볼 수 있는 dictionary(Compiler에서 symbol table로 구현)가 있으면 편리
  - 이렇게 쓰는 dictionary를 [Environment](https://mitp-content-server.mit.edu/books/content/sectbyfn/books_pres_0/6515/sicp.zip/full-text/book/book-Z-H-10.html#%_sec_1.1.2)
- Block-structured 언어에서 Environment(또는 Context)는
  - 블록($\{...\}$) 마다 (이름, 속성)의 집합을 표현하는 dictionary 곧 frame이 따로 있어서 격리된 scope (name space)를 표현하고, 블록이 블록을 둘러 싸는 (lexical scoping) 방식을 frame이 나무 구조(Structure)를 이루는 것으로 표현
  - 블록을 계산하면 $(code, environment)$ 곧 [closure][closure]가 나옵니다.
  - 블록을 evaluation한다는 것은 code를 environment(context, 문맥)에서 해석하겠다는 말

### Parameter

- parameter와 arguement의 binding 말하기 앞서 수학 함수에서 정의역, 치역, 매개변수, 미지수 ...
- method의 (함수, 프로시저의) parameter는 값을 지정하지 않은 local variable
- paramter passing
  - call-by-value (그 밖에 by-name, by-reference, ...)
- method call과 activation record
  - [non-recursive](https://www.inf.unibz.it/~calvanese/teaching/04-05-ip/lecture-notes/uni10/node18.html)
  - [recursive](https://www.inf.unibz.it/~calvanese/teaching/04-05-ip/lecture-notes/uni10/node19.html)

Java에서 말하는 '변'수는 아마 ... (assignment 때문에 ... 시도 때도 없이 막 변수 값 지 맘대로 바꾸고 그래서 ^^?)

> "메모리 뭉치(address to memory chunk)"와 그 속에 저장된 "bit pattern의 해석 방식(data type)"을 요약(abstraction)한 것

[closure]: https://en.wikipedia.org/wiki/Closure_(computer_programming)
[^closure]: [여러 분야에서 쓰는 말](https://en.wikipedia.org/wiki/Closure)입니다.
적어도 Regular expression의 [Kleene closure](https://en.wikipedia.org/wiki/Kleene_star) 연산,
(전산학에서 graph로 표현하는) 수학에서 relation의 [transitive closure](https://en.wikipedia.org/wiki/Transitive_closure) 연산,
[Clojure](https://clojure.org/) 프로그래밍 언어와 구분합니다.
