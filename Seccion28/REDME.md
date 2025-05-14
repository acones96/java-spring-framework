# Spring AI
Spring AI is a project under the Spring ecosystem designed to simplify integration with AI services and models in Java-based applications, particularly those using Spring Framework or Spring Boot.

This use Model as a Service (MaaS), where from the application we could use a LLM or generative AI and return the request of the prompt to us.

Spring AI provides abstractions that serve as the foundation for developing AI applications. These abstractions have multiple implementations, enabling easy component swapping with minimal code changes.


We can search for documentation of [Spring AI](https://spring.io/projects/spring-ai) in his official website.


## Open AI
We need to create the project and use the dependency of the Model we want to use, for example, Open AI which his dependency would be:

```xml
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-starter-model-openai</artifactId>
</dependency>
```

The project won't start even when you did not modify it because it needs the `spring.ai.openai.api-key` in `application.properties` which we can generate it in their API Platform by a cost.