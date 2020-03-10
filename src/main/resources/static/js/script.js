// var searchParams = 'http://localhost:8080/ships/search?min=31000&max=208968450&coreDynamics=true&faulconDeLacy=true&gutamaya=true&lakon=true&saudKruger=true&zorgonPeterson=true&large=true&medium=true&small=true';

function checkIt() {
    let min = document.getElementById("price-min").value;
    let max = document.getElementById("price-max").value;
    let coreDynamics = document.getElementById("coreDynamics").checked;
    let faulconDeLacy = document.getElementById("faulconDeLacy").checked;
    let gutamaya = document.getElementById("gutamaya").checked;
    let lakon = document.getElementById("lakon").checked;
    let saudKruger = document.getElementById("saudKruger").checked;
    let zorgonPeterson = document.getElementById("zorgonPeterson").checked;
    let large = document.getElementById("large").checked;
    let medium = document.getElementById("medium").checked;
    let small = document.getElementById("small").checked;

    // searchParams = `http://localhost:8080/ships/search?min=${min}&max=${max}&coreDynamics=${coreDynamics}&faulconDeLacy=${faulconDeLacy}&gutamaya=${gutamaya}&lakon=${lakon}&saudKruger=${saudKruger}&zorgonPeterson=${zorgonPeterson}&large=${large}&medium=${medium}&small=${small}`;
    // console.log(searchParams);
}

const searchParams = 'http://localhost:8080/ships/search';

fetch(searchParams).then(async function (response) {
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
