package com.telusko.SpringIACode;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ollama")
public class OllamaController {
//    private final OllamaChatModel chatModel; // Used for Ollama Model

    /**
     * @implNote  ChatClient is an interface that offers a fluent API for communicating with an AI Model. It supports both a synchronous and streaming programming model. It encapsulates: sending prompts, receiving model responses, managing chat context and memory, supporting both simple and complex message interactions.
     */
    private final ChatClient chatClient; //

    public OllamaController(OllamaChatModel chatModel) {
//        this.chatModel = chatModel;
        this.chatClient = ChatClient.create(chatModel);
    }

    /**
     * @param message send the prompt to OpenAI.
     * @implNote {chatModel.call} make the call with the prompt message which will return an answer.
     * @return show the response that OpenAI send.
     */
    @GetMapping("/{message")
    public ResponseEntity<String> getAnswer(@PathVariable String message) {
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
