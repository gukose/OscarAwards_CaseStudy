package com.app.movie.helper;

import com.app.movie.model.base.Constant;
import com.app.movie.model.movie.MovieInfoResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class CommonHelper {

        public <T> T callGetService(String endPoint,String apiKey, String parameters,Class<T> objectClass) throws IOException {

        String uri = endPoint + apiKey + "&" + parameters;
        RestTemplate restTemplate= new RestTemplate();
        String result= restTemplate.getForObject(uri,String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return (T) objectMapper.readValue(result, objectClass);
    }
}
