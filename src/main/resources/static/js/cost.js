const url = 'http://localhost:8080/ships/сost?price-min=';
fetch(url).then(async function (response) {
    await getDiv(response);
});
