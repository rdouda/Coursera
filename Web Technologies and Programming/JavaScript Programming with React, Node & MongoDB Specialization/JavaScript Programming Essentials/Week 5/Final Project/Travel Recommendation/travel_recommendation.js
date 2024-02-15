const travel_recommendation_api = "https://cf-courses-data.s3.us.cloud-object-storage.appdomain.cloud/IBMSkillsNetwork-JS0101EN-SkillsNetwork/travel1.json";
const searchBtn = document.getElementById('searchBtn');
const clearBtn = document.getElementById('clearBtn');
const destinationInput = document.getElementById('destinationInput');

function getCountryTime(time_zone) {
    // const time_zone = 'America/New_York'
    const options = { timeZone: time_zone, hour12: true, hour: 'numeric', minute: 'numeric', second: 'numeric' };
    const currentTime = new Date().toLocaleTimeString('en-US', options);
    return currentTime;
}

function recommendTravel() {
    const userInput = destinationInput.value.trim().toLowerCase();
    if (userInput.value == "")
        return;
    fetch(travel_recommendation_api)
        .then(response => response.json())
        .then(data => {
            const matches = [];
            const countryMatches = data.countries.filter(country =>
                country.name.toLowerCase().includes(userInput)
            );
            matches.push(...countryMatches);
            console.log(matches);
        })
        .catch(error => {
            console.log(error);
        })
}

clearBtn.addEventListener('click', () => {
    destinationInput.value = '';
});

searchBtn.addEventListener('click', recommendTravel);
