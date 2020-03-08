const url = 'http://localhost:8080/ships/all';
fetch(url).then(async function (response) {
    await getDiv(response);
});

// Print response into div
async function getDiv(response) {
    let ourShips = JSON.parse(await response.text());
    let resultDiv = '<div>';
    ourShips.forEach(ship => resultDiv += '<div class="ship-div">' +
        '<p> Model: ' + ship.shipModel + '</p>' +
        '<p> Manufacturer: ' + ship.manufacturer + '</p>' +
        '<p> Cost: ' + ship.cost + ' cr</p>' +
        '<p> Landing Pad: ' + ship.size + '</p>' +
        '</div>');
    resultDiv += '</div>';
    document.getElementById("placeholder").innerHTML = resultDiv;
}