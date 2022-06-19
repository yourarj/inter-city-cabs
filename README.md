# inter-city-cabs

## config
    java version: 18
    

## flow
    Start with application state initialization
    localhost:8080/app/initialize?initialState=CabOne%2CIDLE%2CCityOne%0ACabTwo%2CIDLE%2C%20CityTwo%0ACabThree%2CIDLE%2CCityOne%0ACabFour%2CIDLE%2CCityOne

    then try booking a ride

    localhost:8080/booking/create?sourceCityId=CityOne&destinationCityId=CityTwo

