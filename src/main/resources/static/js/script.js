var ourRequest = new XMLHttpRequest();
ourRequest.open('GET', 'http://localhost:8080/ships/all');
ourRequest.onload = function () {
    var ourShips = JSON.parse(ourRequest.responseText);
    ourShips.forEach(element => console.log(element));
    var resultTable = '<table class="ship-table">' +
        '<tr><td>Ship</td><td>Manufacturer</td><td>Cost, cr</td><td>Landing Pad</td></tr>';
    ourShips.forEach(ship => resultTable+='<tr>' +
        '<td>'+ ship.shipModel + '</td>' +
        '<td>'+ ship.manufacturer + '</td>' +
        '<td>'+ ship.cost + '</td>' +
        '<td>'+ ship.size + '</td>' +
        '</tr>');
    resultTable+='</table>';
    document.getElementById("demo").innerHTML = resultTable;
};
ourRequest.send();