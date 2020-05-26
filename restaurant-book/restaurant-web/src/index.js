(async () => {
    const url = 'http://localhost:8080/restaurant';
    const response = await fetch(url);
    const restaurants = await response.json();

    const element = document.getElementById('app');
    /*element.innerHTML = jSON.stringify(restaurants);*/
    /*element.innerHTML = `${restaurants[0].id} ${restaurants[0].name} ${restaurants[0].address}`;*/
    element.innerHTML = `${
        restaurants.map(
            restaurant => `<p>${restaurant.id} ${restaurant.name} ${restaurant.address}</p>`
        ).join('')}
     `;

})();