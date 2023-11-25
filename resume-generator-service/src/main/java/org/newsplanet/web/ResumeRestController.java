package org.newsplanet.web;
//import java.net.http.HttpHeaders;

import org.newsplanet.models.OpenAIRequest;
import org.newsplanet.models.OpenAIResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/resume")
public class ResumeRestController {
    private static final String OPENAI_API_KEY = "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";
    private static final String OPENAI_API_URL = "https://api.openai.com/v1/engines/text-davinci-003/completions";

    @PostMapping("/generate")
    public String generateResume(@RequestBody OpenAIRequest candidateDetails){
        System.out.println(candidateDetails.getPrompt());
        String prompt = "Create a resume for a candidate with the following details:\n"+candidateDetails.getPrompt();
        String generatedResume = callOpenAIApi(prompt);
        return generatedResume;
    }

    @GetMapping("/")
    public String hello(){
        return "Hello word";
    }

    public String callOpenAIApi(String prompt){
        RestTemplate restTemplate = new RestTemplate();

        //Set the OpenAI API request params
        OpenAIRequest request = new OpenAIRequest();
        request.setPrompt(prompt);
        request.setTemperature(0.7);
        request.setMaxTokens(300);
        request.setN(1);

        //Set the OpenAI API headers, including your API key
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Beares " + OPENAI_API_KEY);
        HttpEntity<OpenAIRequest> entity = new HttpEntity<>(request, headers);

        //Make the POST request to the OpenAI GPT-3 API
        OpenAIResponse response = restTemplate.postForObject(OPENAI_API_URL, entity, OpenAIResponse.class);

        //Extract the generated resume from the API response
        return response.getChoices().get(0).getText().trim();
    }
}
