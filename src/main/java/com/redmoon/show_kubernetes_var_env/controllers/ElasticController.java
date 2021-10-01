package com.redmoon.show_kubernetes_var_env.controllers;

import com.redmoon.show_kubernetes_var_env.services.ReadEnvVar;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ElasticController {

    Map<String, Object> response = new HashMap<>();

    private final ReadEnvVar readEnvVar;

    public ElasticController(ReadEnvVar readEnvVar) {
        this.readEnvVar = readEnvVar;
    }

    @GetMapping("/elastic")
    private ResponseEntity<?> getElastic(){

        response.clear();
        response.put("PATH to JDK for ElasticSearch: ", readEnvVar.getElasticPath());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/kube")
    private ResponseEntity<?> getKubernetes(){

        response.clear();
        response.put("KUBERNETES_SERVICE_HOST: ", readEnvVar.getKube()[0]);
        response.put("KUBERNETES_SERVICE_PORT: ", readEnvVar.getKube()[1]);
        response.put("KUBERNETES_SERVICE_PORT_HTTPS: ", readEnvVar.getKube()[2]);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
