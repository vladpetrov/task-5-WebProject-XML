<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
  <meta charset="utf-8">
  <title>Deposits</title>
  <link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="view/css/index.css">
</head>
<body>

<form name="parserChoiceForm" method="post" action="showTable">
  <h2 align="center">Choose a parser:</h2>
  <div class="parserContainer">
    <input type="hidden" name="command" value="load"/>
    <input type="submit" class="btn btn-default" name="parser" value="DOM"/>
    <input type="submit" class="btn btn-default" name="parser" value="SAX"/>
    <input type="submit" class="btn btn-default" name="parser" value="STAX"/>
  </div>
</form>

</body>
</html>