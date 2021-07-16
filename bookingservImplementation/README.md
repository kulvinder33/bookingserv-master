# bookingservImplementation

## Application Enhancement Overview

- Added all the fields listed to enhance the booking json-schema requested in the assignment.
- Added the support for storing/fetching from h2 database
- Added Validations for Json Request Body using @NotNull annotations on required fields in generated model classes.
- Created Separate BookingEntity and AddressEntity to be stored in Database in separates tables.
- Implemented Junit tests to perform the unit testing of the methods.

### Interface designing & Error Handling
- Implemented Base service interface to provide implementation for common/default repository methods and provide a Base class to all other services. 
- Added a BaseRepository which acts as a base interface to all other repositories for all entities.
- Added Custom Global Exception Handler for generic exception handling using `@ControllerAdvice`. Custom ErrorMessage Model has been created to wrap error responses and return it back to Client. Common exceptions like input-validation failed / SQL-Constraint violation etc. have been captured and reverted to client in ErrorResponse Model.


### Idempotency Logic Implementation

- Implemented a custom idempotent interceptor which helps in achieving the Idempotency safety in POST method. To achieve this functionality, I have added a token generator at the path :: `/v1/bfs/idempotencytoken`. This path generates the token `(uuid key)` for client to attach in every unique request in request headers as `Idempotency-Key`.

- If the token is not found for a POST request an error is thrown at client. If the token is found in request headers then the corresponding entry is looked in DB, to check if this is a duplicate request or not. 
- If the token id is not present in DB it is treated as a new request. Whereas if the token id is present then the corresponding mapped booking id (already created resource) is returned to the client instead of duplicate resource creation.

### Sample resource requests and responses : 

- GET new token : 

    - URI : `http://{host:port}/v1/bfs/idempotencytoken`
    - Response : 
```
{
    "uuid": "cc1228f1-2983-4fa9-832d-77861252c1121626468107415",
    "bookingId": null
}
```

- POST new Booking : 

    - URI : `http://{host:port}/v1/bfs/booking`
    - Headers : `Idempotency-Key` : `cc1228f1-2983-4fa9-832d-77861252c1121626468107415` (UUID from above requests response)
    - Request Body : 
```
{
    "first_name" : "kulvinder",
    "last_name" : "singh",
    "date_of_birth" : "1994-10-10",
    "checkin" : "2020-12-20",
    "checkout" : "2020-12-21",
    "total_price" : 1000,
    "deposit" : 500,
    "address" : {
        "line1" : "h.no. 774",
        "line2" : "sector - 16",
        "city" : "karnal",
        "state" : "haryana",
        "country" : "India",
        "zip_code" : 132001
    }
}

```

    - Response : 

```
{
    "id": 2,
    "first_name": "kulvinder",
    "last_name": "singh",
    "date_of_birth": "1994-10-10",
    "checkin": "2020-12-20",
    "checkout": "2020-12-21",
    "total_price": 1000,
    "deposit": 500,
    "address": {
        "line1": "h.no. 774",
        "line2": "sector - 16",
        "city": "karnal",
        "state": "haryana",
        "country": "India",
        "zip_code": 132001,
        "id": 2
    }
}
```

- GET All Bookings: 

    - URI : `http://{host:port}/v1/bfs/booking`
    - Response : 
```
[
    {
        "id": 2,
        "first_name": "kulvinder",
        "last_name": "singh",
        "date_of_birth": "1994-10-10",
        "checkin": "2020-12-20",
        "checkout": "2020-12-21",
        "total_price": 1000,
        "deposit": 500,
        "address": {
            "line1": "h.no. 774",
            "line2": "sector - 16",
            "city": "karnal",
            "state": "haryana",
            "country": "India",
            "zip_code": 132001,
            "id": 2
        }
    }
]

```
