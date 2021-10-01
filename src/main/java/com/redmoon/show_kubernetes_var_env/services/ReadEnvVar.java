package com.redmoon.show_kubernetes_var_env.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReadEnvVar {

    @Value("${ES_JAVA_HOME:No set jet}")
    private String es_java;

    @Value("${KUBERNETES_SERVICE_HOST:No set jet}")
    private String kubernetes_service_host;

    @Value("${KUBERNETES_SERVICE_PORT:No set jet}")
    private String kubernetes_service_port;

    @Value("${KUBERNETES_SERVICE_PORT_HTTPS:No set jet}")
    private String getKubernetes_service_port_https;

    public String getElasticPath(){
        return es_java;
    }

    public String[] getKube(){
        String[] kubernetes=new String[3];

        kubernetes[0]=kubernetes_service_host;
        kubernetes[1]=kubernetes_service_port;
        kubernetes[2]=getKubernetes_service_port_https;

        return kubernetes;
    }
}
