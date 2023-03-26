<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Catalog Report</title>
</head>
<body>
	<h1>Catalog Report</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Path/URL</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
			<#list documents as document>
				<tr>
					<td>${document.id}</td>
					<td>${document.name}</td>
					<td><a href="${document.pathUrl}">${document.pathUrl}</a></td>
					<td>
						<#list document.tags as tag>
							${tag.name}: ${tag.value}<br>
						</#list>
					</td>
				</tr>
			</#list>
		</tbody>
	</table>
</body>
</html>
