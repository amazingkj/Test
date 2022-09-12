<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title> </title>
<link rel="stylesheet" type="text/css" href="../css/common.css" />
<link rel="stylesheet" type="text/css" href="../css/board.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
<style type="text/css">


.search-box {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: #56F569;
  height: 40px;
  padding-left: 10px;
  display: inline;
  line-height: 40px;
}

.search-btn {
  color: #fff;
  float: right;
  width: 40px;
  height: 40px;
  border: none;
  background: #56F569;
  display: flex;
  align-items: center;
  justify-content: center;
}

.search-txt {
  padding: 0;
  background: none;
  border: none;
  outline: none;
  color: white;
}

</style>

</head>


<body>
<div class="search-box">
  <form action="." method="post">
    <input class="search-txt" type="text" placeholder="검색어를 입력해 주세요">
    <button class="search-btn" type="submit">
  	<i class="fas fa-search"></i>
	</button>
  </form>
</div>



</body>
</html>