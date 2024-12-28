# REST using Spring Boot

Representational State Transfer (REST) is an architectural style for designing networked applications. t relies on a stateless, client-server communication protocol, typically HTTP.

## Key Principles of REST
* **Stateless.** Each request from a client to a server contain all the information needed to understand and process the request. The server does not store any client context between requests.
* **Client-Server.** They are separate entities that communicate over a network. This separation allows for independent evolution of the client and server.
* **Cacheable.** Responses from the server can be marked as cacheable or non-cacheable, allowing clients to reuse responses for subsequent requests.
* **Uniform interface.** RESTful systems adhere to a uniform interface, simplifying and decoupling the structure. This includes using standard HTTP methods (GET, POST, PUT, DELETE) and standard media types (JSON, XML).
* **Layered Systems.** A client cannot ordinarily tell whether it is connected directly to the end server or an intermediary along the way. This allows for scalability through load balancing and shared caches.
* **Code on Demand (optional).** Servers can temporarily extend or customize the functionality of a client by transferring executable code.

## HTTP
Hypertext Transfer Protocol (HTTP) is the foundaion of data communication on the World Wide Web (WWW). It is a protocol used for transmitting hypertext requests and information between servers and clients.

The methods HTTP manage are: 
* **GET.** Read/Requests data from a specified resource.
* **POST.** Create/Submits data to be processed to a specified resource.
* **PUT.** Update a specified resource with the provided data.
* **DELETE.** Deletes a specified resource.

