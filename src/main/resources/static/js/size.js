function largeShips() {
    const url = 'http://localhost:8080/ships/large';

    if ( document.getElementById("large").checked) {
        fetch(url)
            .then(async function (response) {
                JSON.parse(await response.text());
                document.getElementById("placeholder").innerHTML = '<p>Large ships</p>';
            });
    }
}

function mediumShips() {
    const url = 'http://localhost:8080/ships/medium';

    if ( document.getElementById("medium").checked) {
        fetch(url)
            .then(async function (response) {
                JSON.parse(await response.text());
                document.getElementById("placeholder").innerHTML = '<p>Medium ships</p>';
            });
    }
}

function smallShips() {
    const url = 'http://localhost:8080/ships/small';

    if ( document.getElementById("small").checked) {
        fetch(url)
            .then(async function (response) {
                JSON.parse(await response.text());
                document.getElementById("placeholder").innerHTML = '<p>Small ships</p>';
            });
    }
}