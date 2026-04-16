# Game Library REST API

A simple Spring Boot REST API for managing a small in‑memory game collection.
Supports full CRUD operations and enforces one rule:
a game cannot be added if another game with the same title + platform already exists.

## How to Run
```
./mvnw spring-boot:run
```

or
```
mvn spring-boot:run
```
API runs at:
http://localhost:8080

## Sample Insomnia Requests

### GET all games
```
GET http://localhost:8080/games
```
### GET game by ID
```
GET http://localhost:8080/games/1
```
### POST create new game
```
POST http://localhost:8080/games
{
  "title": "Halo Infinite",
  "genre": "FPS",
  "platform": "Xbox"
}
```
### PUT update existing game
```
PUT http://localhost:8080/games/1
{
  "title": "Halo Infinite",
  "genre": "Shooter",
  "platform": "Xbox"
}
```

### DELETE game
```
DELETE http://localhost:8080/games/1
```
