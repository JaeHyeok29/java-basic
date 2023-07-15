## 공부 거리

- built-in data type이란 말도 흔히 씁니다.
  - 여기서 built-in은 어떤 뜻으로 쓰나요?
  - primitive data type과 어떻게 다른가요?
  - primitive나 built-in을 우리말로 옮긴다면?
- Python, JavaScript는 dynamic typing 합니다.
  - 여기서 dynamic은 무엇을 뜻하나요?
  - Python, JavaScript 코드를 보기로 들어 static typing과 무엇이 다른지 설명하세요.
- 전산학에서 static, dynamic은 무엇을 뜻하나요?

### Java on Linux

- [Literals](Literals.java)에서 [`\n` 대신에 `%n`을 써야 하는 까닭을][newline] 알아봅니다.
- cr 스크립트를 다음처럼 쓸 수 있게 고치려고 합니다.

  ```sh
  ./cr Literals
  ```

  - cr 파일의 [permission을][permission] 설명하세요.

    ```console
    $ ls -al cr
    -rw-rw-r-- 1 kizoo kizoo 255  6월 27 20:36 cr
    ```
  - [`chmod +x cr`][chmod] 한 다음에 permission은 어떻게 달라졌나요?
  - cr의 file type이 아래와 같습니다.

    ```console
    $ file cr
    cr: ASCII text
    ```

    cr의 첫 줄에 ['#!'을][shebang] 넣어 스크립트를 실행하는 [shell을 bash로][whyenv] 지정합니다.
    다시 `file cr` 합니다.

[newline]: https://stackoverflow.com/questions/31981136/difference-between-n-and-n-for-printing-a-new-line-in-java
[permission]: https://askubuntu.com/questions/528411/how-do-you-view-file-permissions
[chmod]: https://askubuntu.com/questions/932713/what-is-the-difference-between-chmod-x-and-chmod-755
[shebang]: https://en.wikipedia.org/wiki/Shebang_\(Unix\)
[whyenv]: https://stackoverflow.com/questions/10376206/what-is-the-preferred-bash-shebang
