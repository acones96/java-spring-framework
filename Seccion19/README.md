# Spring Security

## Introduction 

Spring Security is a powerful and highly customizable framework designed to secure Java applications. It's part of the larger Spring Framework ecosystem and focuses on handling authentication, authorization, and a range of other security concerns.

### Key Features

1. **Authentication**

    Verifying the identity of a user or system. For example:
    * Logging in with a username and password.
    * Using tokens, like JWT (JSON Web Tokens).
    * Integrating with OAuth2 or LDAP for authentication.
   
2. **Authorization**

    Ensuring that authenticated users have the right permissions to perform specific actions. For instance: 
    * Only admins can access a `/manage` endpoint.
    * Regular users can view their own profiles but not modify others.

3. **Declarative Security**

    You can define security rules in configuration files or annotations without deep coding:
    * `@PreAuthorize("hasRole('ADMIN')")` to restrict access at the method level.
    * Configure URL access rules.
   
4. **Integration with Standards**

    * OAuth2 for single sign-on (SSO).
    * OpenID Connect for identity verification.
    * JAAS, LDAP, and SAML support.
   
5. **Comprehensive API**

    Can extend or override the default behavior to fit our specific security requirements.

### Components of Spring Security

1. **Security Filters**

    There are the backbone of Spring Security. For example: 
    * `BasicAuthenticationFilter` for basic auth.
    * `OAuth2AuthorizatnRequestRedirectFilter` for OAuth2
   
2. **Authentication Manager**

    Central to the authentication process. It coordinates the verification of credentials.

3. **UserDetailsService**

    Retrieves user details (like roles and permissions) from a data source.

4. **Password Encoder**

    Handles password hashing and validation securely:
    * BCryptPasswordEncoder (recommended for strong password hashing).
   
5. **Security Context**

    Stores the security information of the current user (like roles) during their session.

## OWASP

OWASP stands for the Open Worldwide Application Security Project. It is a nonprofit organization that provides free resources, tools, and guidelines to help developers, testers, and organizations secure their applications. The goal of OWASP is to improve software security practices and reduce vulnerabilities in applications.

[OWAP Top 10](https://owasp.org/www-project-top-ten/) is updated every 4 years. 

## Filters
Filters form the backbone of Spring Security's request processing. These filters intercept HTTP requests, process them, and decide if the request should proceed or be blocked based on security rules. 

### Key Concepts

* **Filter Chain.**
   Spring Security uses a chain of filters to process incoming requests. Each filter performs a specific function like: authentication, authorization, or request modification, and then passes the request down the chain.
  
* **Integration with Servlet Filters.** 
   Spring Security's filters are based on the Servlet `Filter` API. The filters sit between the client request and the application's `DispatcherServlet`.

* **Filter Chain Proxy.**
   The `FilterChainProxy` is a delegating filter that acts as the entry point forall Spring Security filters. It determines which filters to invoke for the current request based on the security configuration.

```
Client Request --> Filter 1 --> Filter 2 --> Filter 3 --> ... --> Filter N --> Servlet
     ^                                                                                 |
     |                                                                                 v
Client Response <-- Filter 1 <-- Filter 2 <-- Filter 3 <-- ... <-- Filter N <-- Servlet
```

### Common Filters in the Chain
1. **SecurityContextPersistenceFilter:** Maintains the SecurityContext between requests.
2. **UsernamePasswordAuthenticationFilter:** Handles login with username and password.
3. **BasicAuthenticationFilter:** Handles HTTP Basic authentication.
4. **BearerTokenAuthenticationFilter:** Handles JWT or token-based authentication.
5. **ExceptionTranslationFilter:** Converts exceptions into proper HTTP responses (e.g., 401 or 403).
6. **FilterSecurityInterceptor:** Enforces authorization rules.

## Session

Session is a mechanism to store data about a user's interaction with a web application across multiple requests. It helps the server recognize and track a user during their visit.

Knowing this, a session ID is a unique, randomly generated string that identifies a session which acts as a "key" for the server to retrieve the user's session data. It is typically stored on the client side and sent to the server with every request.

## Cross-Site Request Forgery (CSRF)

CSRF is a type of security attack in which an attacker tricks a user into performing an unwanted action on a trusted web application where the user is authenticated. CSRF exploits the trust that a web application has in the user's browser.

## Bcrypt

BCrypt is a password hashing function used in Java (and other programming languages) for securely storing passwords. It's part of the bcrypt algorithm, which is specifically designed to handle password security.

### Key Features

1. **One-Way Hashing:** Converts passwords into a hashed format that cannot be reversed.

2. **Salted Hashing:** Adds a unique salt to each password before hashing, making it resilient to rainbow table attacks.

3. **Adaptive Function:** Allows you to adjust the cost (work factor), making it computationally expensive as hardware improves.

4. **Built-in Security:** Protects against common attacks like brute force or dictionary attacks.

