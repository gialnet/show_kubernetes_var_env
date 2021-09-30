package com.redmoon.show_kubernetes_var_env.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReadEnvVar {

    @Value("${ES_JAVA_HOME:No set jet}")
    private String es_java;

    @Value("${KUBERNETES_SERVICE_HOST:No set jet}")
    private String kubernetes;

    public String getElasticPath(){
        return es_java;
    }

    public String getKube(){
        return kubernetes;
    }
}
