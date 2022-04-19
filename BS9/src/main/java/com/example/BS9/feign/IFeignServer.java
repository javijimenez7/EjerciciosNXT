package com.example.BS9.feign;

import com.example.BS9.profesor.infrastructure.dto.OutputProfesorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "simpleClient", url = "http://localhost:8080/")
public interface IFeignServer {

    @GetMapping("person/profesor/{id}")
    ResponseEntity<OutputProfesorDto> getProfesor(@PathVariable String id);
}
