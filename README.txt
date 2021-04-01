For initialization of the database you have the file database.sql 
in folder src/main/resources with the creation of the database, 
tables and data insertion. The Diagram.jpg is the structure of the database.

I can't do the id's autoincremental with postgresSQL so on the insert 
of the movie i sended the id in the body, 

Endpoints examples:

1) http://localhost:8080/Companies/Movies?id=1 GET
2) http://localhost:8080/Movies/Screenwriter?id=1 GET
3) http://localhost:8080/Movies/Script?id=1 GET
4) http://localhost:8080/Movies/newMovie PUT
{
       "movie" : {
           "id":1,
           "name" : "asd",
           "durationInMinutes": 123,
           "releaseDate": "",
           "criticReview": 8
       },
       "script" : {
           "id":1,
           "timesModified": 23,
           "lastModified": "2018-10-12"
       }
}