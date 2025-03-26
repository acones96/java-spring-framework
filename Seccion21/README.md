# JSON Web Token (JWT) and OAuth2

## Encryption and Decryption

**Encryption** os the process which a readable message is converted to an unreadable form to prevent unauthorized parties from reading it.

There are two types of encryption:
* **Symmetric:** one key is used for both encryption and decryption
* **Asymmetric:** two keys are used: a public key to encrypt and a private key to decrypt

**Decryption** is the process of converting an encrypted message back to its original (readable) format.

## Digital Signature
Process that uses public key cryptography to create a unique hash of a message or document and encrypt it with a private key.

Digital signatures are used to prove that a message or document has not been modified and to authenticate the sender.

### How it works
1. The sender creates a hash of the message or document.
2. The sender encrypts the hash with their private key.
3. The sender sends the message or document with the encrypted hash.
4. The recipient creates their own hash of the message or document.
5. The recipient decrypts the sender's hash with the sender's public key.
6. The recipient compares their hash with the sender's decrypted hash.
7. If the hashes match, the message or document has not been modified.

## JWT

JWT (JSON Web Token) is a compact, self-contained way of securely transmitting information between parties as a JSON object. The information can be verified and trusted because it is digitally signed.

We can learn more about it on his website: [jwt.io](https://jwt.io/).

### Structure

A JWT has three parts, separated by dots `(.)`:
1. **Header.** Metadata about the token.
2. **Payload.** The actual data you want to transmit.
3. **Signature.** Ensures the token hasn't been tampered with. It's created by combining:
   * The header and payload
   * A secret key
   * The algorithm specified in the header.

```
Header.Payload.Signature

eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
```

### JWT Filters

They are components used in web applications, particularly in Spring Security, to handle JWT-based authentication and authorization. These filters intercept incoming HTTP requests, validate JWTs, and enforce security rules before allowing access to protected resources.

JWT filters are responsible for:
1. **Extracting the JWT** from the incoming request.
2. **Validating the JWT**
3. **Setting the Authentication** in the Spring Security context if the JWT is valid.
4. **Allowing or Denying Access** to protected endpoints based on the JWT's validity and claims.

### When is JWT Used
* **Authentication**. Used in login systems like OAuth (Google Login, Facebook Login).

* **Authorization**. APIs use JWT to grant access to specific resources.

* **Session Management**. Instead of storing session data on a server, JWT stores it on the client.

## OAuth2

Is a protocol that allows secure access to resources without exposing user credentials. It is commonly implemented using Spring Security OAuth2 or libraries like OAuth2 Client