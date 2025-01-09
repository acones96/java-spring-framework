# Project using Spring Boot MVC

## HTTP Status Code
HTTP status codes are three-digit numbers returned by a server in response to a client's request. They indicate whether the request was successful, encountered an error, or requires further action. These codes help both developers and clients understand the outcome of an HTTP request.

| **Category** | **Code Range** | **Description**                      |
|--------------|----------------|--------------------------------------|
| **1xx**      | 100-199        | Informational – Request received, continuing process. |
| **2xx**      | 200-299        | Success – The request was successfully processed. |
| **3xx**      | 300-399        | Redirection – Further action needed to complete the request. |
| **4xx**      | 400-499        | Client Error – The request had an issue (e.g., bad request). |
| **5xx**      | 500-599        | Server Error – The server failed to fulfill a valid request. |

### Common Status Codes

* 1xx – Informational. These codes are rare and mostly used for protocol-level communication.

  * 100 Continue – The server has received the request headers and the client should proceed to send the body.
  * 101 Switching Protocols – The server is switching protocols as requested by the client.
  
* 2xx – Success. Everything worked as expected.

  * 200 OK – Standard response for successful HTTP requests.
  Example: Accessing a webpage or API successfully.
  * 201 Created – A new resource was successfully created.
  Example: A user account is created via a POST request.
  * 204 No Content – The server processed the request but there is no content to return.
  Example: Deleting a resource successfully.
  
* 3xx – Redirection. The client needs to take additional steps to complete the request.

  * 301 Moved Permanently – The requested URL has been moved to a new location.
  Example: Redirecting from http://oldsite.com to http://newsite.com.
  * 302 Found (Temporary Redirect) – The resource is temporarily available at a different location.
  * 304 Not Modified – The resource hasn’t changed since the last request (used for caching).
  
* 4xx – Client Error.
The issue is on the client side.

  * 400 Bad Request – The request is invalid (e.g., malformed syntax).
  Example: Missing required fields in an API call.
  * 401 Unauthorized – Authentication is required but not provided or failed.
  Example: Accessing a protected page without logging in.
  * 403 Forbidden – The server understands the request but refuses to authorize it.
  Example: Accessing admin-only pages without proper permissions.
  * 404 Not Found – The requested resource could not be found.
  Example: Typing a wrong URL or broken link.
  * 429 Too Many Requests – The client has sent too many requests in a given timeframe (rate limiting).
  
* 5xx – Server Error
The server encountered an error while processing a valid request.

  * 500 Internal Server Error – A generic error indicating something 
  went wrong on the server.
  * 502 Bad Gateway – The server received an invalid response from an upstream server.
  * 503 Service Unavailable – The server is temporarily unable to handle the request (e.g., maintenance).
  * 504 Gateway Timeout – The server didn’t receive a response in time from another server.

