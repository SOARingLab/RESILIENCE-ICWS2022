package top.soaringlab.longtailed.enginebackend;

import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.kafka.support.converter.RecordMessageConverter;
//import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class EngineBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EngineBackendApplication.class, args);
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        ManagementService managementService = processEngine.getManagementService();
        managementService.toggleTelemetry(false);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public RecordMessageConverter converter() {
//        return new StringJsonMessageConverter();
//    }
}
