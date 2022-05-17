package top.soaringlab.longtailed.compilerbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import top.soaringlab.longtailed.compilerbackend.domain.PublicApi;
import top.soaringlab.longtailed.compilerbackend.service.PublicApiService;

import java.util.List;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private PublicApiService publicApiService;

    @Override
    public void run(ApplicationArguments args) {
        PublicApi publicApi = new PublicApi();
        publicApi.setName("risk level of region");
        publicApi.setMethod("GET");
        publicApi.setUrl("http://localhost:8088/risk-level");
        publicApi.setInputFroms(List.of("region"));
        publicApi.setInputTos(List.of("region"));
        publicApi.setOutputFroms(List.of("risk_level"));
        publicApi.setOutputTos(List.of("risk_level"));
        publicApiService.save(publicApi);
    }
}
