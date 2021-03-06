## Environment:
- Java version: 1.8
- Maven version: 3.*
- Spring Boot version: 2.2.1.RELEASE

## Read-Only Files:
- src/test/*

## Data:
Description of an event data JSON object:

```json
{
   "id": "the unique ID of the event (Integer)",
   "type": "the type of the event, written in PascalCase (String)",
   "public": "whether the event is public, either true or false (Boolean)",
   "repoId": "the ID of the repository the event belongs to (Integer)",
   "actorId": "the ID of the user who created the event (Integer)"
}
```

Example of an event data JSON object:
```json
{
    "type": "PushEvent",
    "public": true,
    "repoId": 1,
    "actorId": 1
}
```


## Requirements:
The REST service must expose the `/events` endpoint, which allows for managing the collection of event records in the following way:

`POST` request to `/events` :
* creates a new event
* expects a JSON event object without an id property as the body payload. You can assume that the given object is always valid.
* adds the given event object to the collection of events and assigns a unique integer id to it. The first created event must have id 1, the second one 2, and so on.
* the response code is 201 and the response body is the created event object, including its id

`GET` request to `/events`:
* returns a collection of all events
* the response code is 200, and the response body is an array of all events ordered by their ids in increasing order

`GET` request to `/repos/{repoId}/events`:
* returns a collection of events related to the given repository
* the response code is 200, and the response body is an array of events related to the given repository ordered by their ids in increasing order

GET request to `/events/{eventId}`:
* returns an event with the given id
* if the matching event exists, the response code is 200 and the response body is the matching event object
* if there is no event in the collection with the given id, the response code is 404

## Commands
- run: 
```bash
mvn clean package; java -jar target/springboot-github-events-api-1.0.jar
```
- install: 
```bash
mvn clean install
```
- test: 
```bash
mvn clean test
```
