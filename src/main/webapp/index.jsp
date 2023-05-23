<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>첫화면</title>
    <style>
      * {
        margin: 0;
        padding: 0;
      }

      ul {
        list-style: none;
        display: flex;
        flex-direction: row;
        align-item: center;
        justify-content: center;
        text-align: center;
        margin-top: 50px;
      }

      ul a {
        text-decoration: none;
        flex: 1;
        height: 50px;
        margin: 0 10px;
        background-color: lightgrey;
      }

      ul a li {
        color: white;
        height: 50px;
        line-height: 50px;
        font-weight: bold;
      }
    </style>
  </head>
  <body>
    <h2>Spring Study Function</h2>
    <ul>
      <a href="#"><li>[로그인]</li></a>
      <a href="/regist"><li>[회원가입]</li></a>
      <a href="#"><li>[방문글 작성]</li></a>
    </ul>
  </body>
</html>
