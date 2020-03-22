async function checkIt() {
    const jsonData = {
        priceMin: document.getElementById("priceMin").value,
        priceMax: document.getElementById("priceMax").value,
        coreDynamics: document.getElementById("coreDynamics").checked,
        faulconDeLacy: document.getElementById("faulconDeLacy").checked,
        gutamaya: document.getElementById("gutamaya").checked,
        lakon: document.getElementById("lakon").checked,
        saudKruger: document.getElementById("saudKruger").checked,
        zorgonPeterson: document.getElementById("zorgonPeterson").checked,
        large: document.getElementById("large").checked,
        medium: document.getElementById("medium").checked,
        small: document.getElementById("small").checked
    };

    $.ajax({
        type: 'POST',
        contentType : "application/json",
        url: 'http://localhost:8080/ships/search',
        data: JSON.stringify(jsonData),
        dataType : "json",
        success: function(data) {
            const ourShips = data;
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
    });
}