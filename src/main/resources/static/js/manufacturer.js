function coreDynamicsShips() {
    const url = 'http://localhost:8080/ships/coredymanics';

    if (document.getElementById("coreDynamics").checked) {
        fetch(url).then(async function (response) {
            await getDiv(response);
        });
    }
}

function faulconDeLacyShips() {
    const url = 'http://localhost:8080/ships/faulcondelacy';

    if (document.getElementById("faulconDeLacy").checked) {
        fetch(url).then(async function (response) {
            await getDiv(response);
        });
    }
}

function gutamayaShips() {
    const url = 'http://localhost:8080/ships/gutamaya';

    if (document.getElementById("gutamaya").checked) {
        fetch(url).then(async function (response) {
            await getDiv(response);
        });
    }
}

function lakonShips() {
    const url = 'http://localhost:8080/ships/lakon';

    if (document.getElementById("lakon").checked) {
        fetch(url).then(async function (response) {
            await getDiv(response);
        });
    }
}

function saudKrugerShips() {
    const url = 'http://localhost:8080/ships/saudkruger';

    if (document.getElementById("saudKruger").checked) {
        fetch(url).then(async function (response) {
            await getDiv(response);
        });
    }
}

function zorgonPetersonShips() {
    const url = 'http://localhost:8080/ships/zorgonpeterson';

    if (document.getElementById("zorgonPeterson").checked) {
        fetch(url).then(async function (response) {
            await getDiv(response);
        });
    }
}