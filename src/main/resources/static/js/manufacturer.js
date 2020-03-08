function coreDynamicsShips() {
    const url = 'http://localhost:8080/ships/coredymanics';

    if ( document.getElementById("coreDynamics").checked) {
        fetch(url)
            .then(async function (response) {
                JSON.parse(await response.text());
                document.getElementById("placeholder").innerHTML = '<p>Core Dymanics Ships</p>';
            });
    }
}

function faulconDelacyShips() {
    const url = 'http://localhost:8080/ships/faulcondelacy';

    if ( document.getElementById("faulconDelacy").checked) {
        fetch(url)
            .then(async function (response) {
                JSON.parse(await response.text());
                document.getElementById("placeholder").innerHTML = '<p>Faulcon Delacy Ships</p>';
            });
    }
}

function gutamayaShips() {
    const url = 'http://localhost:8080/ships/gutamaya';

    if ( document.getElementById("gutamaya").checked) {
        fetch(url)
            .then(async function (response) {
                JSON.parse(await response.text());
                document.getElementById("placeholder").innerHTML = '<p>Gutamaya Ships</p>';
            });
    }
}

function lakonShips() {
    const url = 'http://localhost:8080/ships/lakon';

    if ( document.getElementById("lakon").checked) {
        fetch(url)
            .then(async function (response) {
                JSON.parse(await response.text());
                document.getElementById("placeholder").innerHTML = '<p>Lakon Ships</p>';
            });
    }
}

function saudKrugerShips() {
    const url = 'http://localhost:8080/ships/saudkruger';

    if ( document.getElementById("saudKruger").checked) {
        fetch(url)
            .then(async function (response) {
                JSON.parse(await response.text());
                document.getElementById("placeholder").innerHTML = '<p>Saud Kruger Ships</p>';
            });
    }
}

function zorgonPetersonShips() {
    const url = 'http://localhost:8080/ships/zorgonpeterson';

    if ( document.getElementById("zorgonPeterson").checked) {
        fetch(url)
            .then(async function (response) {
                JSON.parse(await response.text());
                document.getElementById("placeholder").innerHTML = '<p>Zorgon Peterson Ships</p>';
            });
    }
}