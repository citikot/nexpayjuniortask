# Nexpay Junior Task

## Functional requirements:

Write a microservice to determine the country by phone number.

The user enters a phone number, the system validates it and displays the country or error message.

For country codes use the table on the page https://en.wikipedia.org/wiki/List_of_country_calling_codes

- [ ] It is necessary to load data from it every time the service starts.


### Non-functional requirements:
#### Backend: 
- Java 11 or 17 (**JDK 11 chosen**)
- Spring Boot
- Maven
- HTTP, REST-WS with JSON data format.

#### Frontend (**optional**):
- Html
- JavaScript
- Supporting libraries - at your discretion.

#### Notes:
- [ ] The application must be built and run from the command line, on port 8080. 
- [ ] It should also be possible to run tests and view reports on them.
- [ ] All calls to the application are done using REST-WS with JSON as the data format.
- [ ] Data validation, tests are required.
- [ ] Add a curl example on how to invoke REST endpoint.

##### Optional part:
The appearance of the interface is unimportant, plain HTML will be fine.
For requests, use any AJAX-capable framework, you can just JQuery.