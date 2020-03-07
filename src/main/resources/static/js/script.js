var ourRequest = new XMLHttpRequest();
ourRequest.open('GET', 'http://localhost:8080/ships/all');
ourRequest.onload = function () {
    var ourShips = JSON.parse(ourRequest.responseText);
    ourShips.forEach(element => console.log(element));
    var resultDiv = '<div>';
    ourShips.forEach(ship => resultDiv += '<div class="ship-div">' +
        '<p> Model: ' + ship.shipModel + '</p>' +
        '<p> Manufacturer: ' + ship.manufacturer + '</p>' +
        '<p> Cost: ' + ship.cost + ' cr</p>' +
        '<p> Landing Pad: ' + ship.size + '</p>' +
        '</div>');
    resultDiv += '</div>';
    document.getElementById("placeholder").innerHTML = resultDiv;
};
ourRequest.send();