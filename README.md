# DistanceCalculator
A test task for getting the distance between cities.
# Running
To start the project, follow these steps:
1. Create a database in mysql:
```
CREATE DATABASE 'distance-calculator'
```
2. Start the WildFly server. To do this, run the `standalone.bat` file . You also need to pre-configure the mysql jdbc driver in WildFly, and create DATASOURCES named `TestDistanceCalculatorDS` and JNDI `java:/magenta/datasource/test-distance-calculator`
3. Deploy project:
```
mvn wildfly:deploy
```
# Use
API has 3 endpoints:
1. The Post method for uploading data to the database, which accepts an xml file with a list of cities and a list of distances.
 ```
http://localhost:8080/distance-calculator/api/add/
```  
2. Get method to have list of all cities in the Database with fields `id` and `name`
```
http://localhost:8080/distance-calculator/api/city/
```
3. The Post method for calculating the distance, which in its body contains text in xml format (or a file) with a list of city names from and to
```
http://localhost:8080/distance-calculator/api/calculate/{1-3}
```
Where `1` is Crowflight calculation type, `2` search for a value in the database and `3` use both methods.
# Data format
Accept files in the following xml format:
```
<root>
    <cities>
        <cityList latitude="x" longtitude="y" name="CityName1"/>
        <cityList latitude="x" longtitude="y" name="CityName2"/>
    </cities>
    <distance>
        <distanceList fromCity="CityName1" toCity="CityName2" distance="z"/>
    </distance>
</root>
```
The project is accompanied by 2 files to upload to the project. `test.xml` with two cities and the distance between them. And `listsCityAndDistance.xml` with 497 cities and distances from each city and to each.

Example of the request body for calculating the distance one to one:
```
<root>
    <citiesListFrom>
        <cityListFrom>Самара</cityListFrom>
        <!--there may be other names of cities here-->
    </citiesListFrom>
    <citiesListTo>
        <cityListTo>Тольятти</cityListTo>
        <!--there may be other names of cities here-->
    </citiesListTo>
</root>
```
