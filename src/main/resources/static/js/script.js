let searchParams;

async function checkIt() {
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

    searchParams = `http://localhost:8080/ships/search?min=${min}&max=${max}&coreDynamics=${coreDynamics}&faulconDeLacy=${faulconDeLacy}&gutamaya=${gutamaya}&lakon=${lakon}&saudKruger=${saudKruger}&zorgonPeterson=${zorgonPeterson}&large=${large}&medium=${medium}&small=${small}`;
    // console.log(searchParams);

    const ajax_req = new XMLHttpRequest();
    ajax_req.open('POST', searchParams, true);

    ajax_req.onload = function () {
        if (this.status === 200) {
            const ourShips = JSON.parse(this.responseText);
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
    };

    ajax_req.send();
}