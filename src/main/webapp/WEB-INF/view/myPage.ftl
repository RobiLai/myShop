<#include "init.ftl">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyShop</title>
</head>
<#assign welcome = "Ciao ${user} !">
<#assign numMessaggi = "Hai ${messaggi} messaggi da leggere">
<#assign valA = 10>
<#assign valB = 5>
<body>
<h1>${welcome + " " + numMessaggi}</h1>

<p>${valA - valB}</p>

<#if valA == 10>
<p> ValA vale 10 </p>
<#else if valA == 5>
<p> ValA vale 5 </p>
<#else>
<p> ValA vale altro </p>
</#if>

<#if numMessaggi gt 0 && numMessaggi <6 >
<p>hai messaggi da leggere</p>
<#else>
<p>non hai messaggi da leggere</p>
</#if>

<h2>Prodotti</h2>

<table>
<tbody>
<tr>
<th>Id</th>
<th>Nome</th>
<th>Categoria</th>
<th>Prezzo</th>
</tr>

<#list prodotti prodotto>
<tr>
<td>${prodotto.id}</td>
<td>${prodotto.nome}</td>
<td>${prodotto.categoria}</td>
<td>${prodotto.prezzo}</td>
</tr>
</#list>
</tbody>
</table>

<#list codici as codice >
${codice}
</#list>


<h2>Codici Promozionali</h2>

<#list codici as codice >
${codice}
</#list>


<footer>${copyright}</footer>
</body>
</html>