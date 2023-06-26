# Nexpay Junior Task

## Functional requirements:

Write a microservice to determine the country by phone number.

The user enters a phone number, the system validates it and displays the country or error message.

For country codes use the table on the page https://en.wikipedia.org/wiki/List_of_country_calling_codes

- [X] It is necessary to load data from it every time the service starts.


### Non-functional requirements:
#### Backend: 
- Java 11 or 17 (**JDK 11 chosen**)
- Spring Boot
- Maven
- HTTP, REST-WS with JSON data format.

#### Frontend (**optional**): **NOT IMPLEMENTED**
- Html
- JavaScript
- Supporting libraries - at your discretion.

#### Notes:
- [X] The application must be built and run from the command line, on port 8080. 
- [ ] It should also be possible to run tests and view reports on them. (**NOT IMPLEMENTED**)
- [X] All calls to the application are done using REST-WS with JSON as the data format.
- [X] Data validation, tests are required. (**Validation is inside service and parser classes**)
- [X] Add a curl example on how to invoke REST endpoint.

Request: curl http://localhost:8080/api/country?phone=+380(95)1234456
Response: Ukraine

Request: curl http://localhost:8080/api/country?phone=+1(728)1234456
Response: United States

Request: curl http://localhost:8080/api/country?phone=+198(728)1234456
Response: Invalid country code: 198

Request: curl http://localhost:8080/api/country?phone=+1(728)12344567899
Response: Phone number is too long. Please, enter correct phone number in international format like +0 (000) 000 00 00.

Request:  curl http://localhost:8080/api/country
Response: Phone number was not submitted.

Request: curl http://localhost:8080/api/country?phone=+1(728)dsfsdfsdfsdf
Response: Please, enter valid phone number in international format like +0 (000) 000 00 00.

Request: curl http://localhost:8080/api/country?phone=+995(950)12-34-45
Response: Georgia

##### Optional part: (**NOT IMPLEMENTED**)
The appearance of the interface is unimportant, plain HTML will be fine.
For requests, use any AJAX-capable framework, you can just JQuery.