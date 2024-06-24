package com.crudoperation.addcrew.controller;


import com.crudoperation.addcrew.model.Crew;
import com.crudoperation.addcrew.model.ProcessedRequestDTO;
import com.crudoperation.addcrew.model.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AddCrewController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper mapper;
    String url = "http://dynamodbupdater/ddboperation";


    @PostMapping("/addCrew")
    public ResponseEntity<Response> addCrew(@RequestBody Crew crew) throws JsonProcessingException {
        ProcessedRequestDTO requestDTO = createRequest(crew);
        String jsonRequest =mapper.writeValueAsString(requestDTO);
        System.out.println(jsonRequest);
        HttpEntity request = new HttpEntity<>(requestDTO);
        ResponseEntity<Response> response = restTemplate.exchange(url, HttpMethod.POST,request, Response.class);
        System.out.println(response);

        return response;
    }

    private ProcessedRequestDTO createRequest(Crew crew){
        ProcessedRequestDTO requestDTO = new ProcessedRequestDTO();
        requestDTO.setCrewid(crew.getCrewid());
        requestDTO.setOperationType("CREATE");
        requestDTO.setCrewDTO(crew);

        return  requestDTO;
    }

}
