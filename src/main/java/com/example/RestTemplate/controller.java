package com.example.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class controller {
    final String uri="http://localhost:8080/student";
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping(value = "/get")
    public String restTemplateExample() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<String>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(ri, HttpMethod.GET, httpEntity, String.class);
        return responseEntity.getBody();

    }
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public String postRest(@RequestBody student k){
        HttpHeaders headers=new HttpHeaders();
        HttpEntity<Object> entity=new HttpEntity<Object>(k,headers);
        return restTemplate.exchange(uri,HttpMethod.POST,entity,String.class).getBody();

    }
}
