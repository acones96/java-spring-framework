package com.telusko.SpringIACode;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/open-ai")
public class OpenAIController {
//    private final OpenAiChatModel chatModel; // Used for ChatGPT Model

    /**
     * @implNote  ChatClient is an interface that offers a fluent API for communicating with an AI Model. It supports both a synchronous and streaming programming model. It encapsulates: sending prompts, receiving model responses, managing chat context and memory, supporting both simple and complex message interactions.
     */
    private final ChatClient chatClient; //

/*
    public OpenAIController(OpenAiChatModel chatModel) {
//        this.chatModel = chatModel;
        this.chatClient = ChatClient.create(chatModel);
    }
*/

    /**
     * @param builder The ChatClient.Builder in Spring AI is a builder interface designed to configure and instantiate ChatClient instances. We can configure it to use only one LLM Model
     */
    public OpenAIController(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory())) // Maintain the memory from the conversation
                .build();
    }

    /**
     * @param message send the prompt to OpenAI.
     * @implNote {chatModel.call} make the call with the prompt message which will return an answer.
     * @return show the response that OpenAI send.
     */
    @GetMapping("/{message")
    public ResponseEntity<String> getAnswer(@PathVariable String message) {

    // Simple way to request a prompt by using ChatGPT
/*
        String response = chatModel.call(message);
*/

    // Use chatClient for flexible use
/*
        String response = chatClient
                .prompt(message) // Send the prompt
                .call() // Call de prompt
                .content(); // Archive the content of it
*/

    // Use ChatResponse for metadata information
        ChatResponse chatResponse = chatClient
                .prompt(message)
                .call()
                .chatResponse();

        System.out.println(chatResponse.getMetadata().getModel()); // Return metadata to console

        String response = chatResponse
                .getResult()
                .getOutput()
                .getText();

        return ResponseEntity.ok(response);
    }
}
