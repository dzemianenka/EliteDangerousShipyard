function largeShips() {
    const url = 'http://localhost:8080/ships/large';
    if (document.getElementById("large").checked) {
        fetch(url).then(async function (response) {
            await getDiv(response);
        });
    }
}

function mediumShips() {
    const url = 'http://localhost:8080/ships/medium';
    if (document.getElementById("medium").checked) {
        fetch(url).then(async function (response) {
            await getDiv(response);
        });
    }
}

function smallShips() {
    const url = 'http://localhost:8080/ships/small';
    if (document.getElementById("small").checked) {
        fetch(url).then(async function (response) {
            await getDiv(response);
        });
    }
}