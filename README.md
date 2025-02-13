# CurrencyConverter

#Project Overview

-> Fetch live exchange rates from a public API.
-> Convert currency amounts from one currency to another.
-> Error handling for API failures and invalid inputs.
-> RESTful API endpoints for fetching rates and converting amounts.

#Technologies Used
-> Maven tool
-> JAVA 17
-> JUnit for testing 
-> RestTemplate

#API Endpoints

-> GET http://api.exchangeratesapi.io/v1/latest?access_key=9cd3cdaa0f16b561117e36660a4e3842&base=EUR&symbols=EUR,GBP,INR
here the default base currency is EUR
Response
{
    "success": true,
    "timestamp": 1739419443,
    "base": "EUR",
    "date": "2025-02-13",
    "rates": {
        "EUR": 1,
        "GBP": 0.835125,
        "INR": 90.440832
    }
}
