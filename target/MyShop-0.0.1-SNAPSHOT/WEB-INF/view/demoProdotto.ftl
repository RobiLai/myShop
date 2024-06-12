<#include "init.ftl">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyShop</title>
</head>
<#assign saluto = "Benvenuto nel Prodotto">
<body>

	<h1>${saluto}</h1>
	
	<h2>${prodotto.nome}</h2>
	<p>${prodotto.categoria}</p>
	<p>${prodotto.id}</p>
	<p>${prodotto.prezzo}</p>
	
	<footer>${copyright}</footer>
</body>
</html>