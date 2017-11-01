<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ui="http://java.sun.com/jsf/facelets"> 
<head>
<title>Layout 2</title>
<style type="text/css">
#div1 {
	background-color: black;
	border: 2px solid;
	border-radius: 25px;
	height: 500px;
	margin-bottom: 5px;
}

#div2 {
	background-color: black;
	border: 2px solid;
	border-radius: 45px;
	height: 70px;
}
</style>
</head>
<body>
	<div align="right">
		Voc&ecirc; est&aacute; no <img alt="" src="img/BANCO-24-HORAS.jpg" width="200px" height="46px"/>
	</div>
	<div>
		${requestScope.layout.mensagem2}
	</div>
	<div id="div1" align="center" />
	<div id="div2" align="center">
		<font size="55" color="white">Layout 2</font>
	</div>
</body>
</html>