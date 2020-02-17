<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.css"/> 
    <script src="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.js"></script>
    <script>
        $(document).ready(function() {
            	if(${data} != null)	{
            		$('#result').empty()
            		var table = $('<table id="MydataTable" class="table table-bordered table-hover"></table>')
            		var tr = $("<tr></tr>")
            		var vars = ['code','sample']
            		$(vars).each(function(k, v) {
            			tr.append('<th>' + v + '</th>')
            		})
            		var thead = $("<thead></thead>")
            		thead.append(tr)
            		$(table).append(thead)
            		
            		var tbody = $("<tbody></tbody>")
            		var bindings = ${data}
            		$(bindings).each(function(k, b) {
            			tr = $("<tr></tr>")
            			
            			$(vars).each(function(k2, v) {
							tr.append('<td>' + b[v] + '</td>')
            			})
            			tbody.append(tr)
            		})
            		$(table).append(tbody)

            		$('#result').append(table)
            		table.DataTable({
                    'paging': true,
                    'lengthChange': false,
                    'searching': true,
                    'ordering': true,
                    'info': true,
                    "bFilter": true,
                    "bSort": true,
                    "order": [[ 5, "desc" ]],
                    scrollCollapse: true,
                    "retrieve": true
            		})
            		
            	}
            	else {
            		$('#result').empty()
            		error = JSON.stringify(${data})
            		var table = $('<table class="table table-bordered table-hover"><tbody><tr><td>error: ' + error + '</td></tr></tbody></table>')
            		$('#result').append(table)
            		table.DataTable({
            			bPaginate : false,		    
            	        'paging': true
            		})
            	}
        } );
    </script>
<title>Result</title>	
</head>

<body>
<h1>Result</h1>
Json Source: ${data}
<div id="result"></div>

</body>
</html>