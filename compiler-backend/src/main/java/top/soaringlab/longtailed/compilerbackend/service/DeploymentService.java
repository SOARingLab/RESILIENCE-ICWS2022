package top.soaringlab.longtailed.compilerbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Service
public class DeploymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CompilerService compilerService;

    public void deploy(String filename, String data) {

        ByteArrayResource byteArrayResource = new ByteArrayResource(data.getBytes(StandardCharsets.UTF_8)) {
            @Override
            public String getFilename() {
                return filename;
            }
        };

        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("data", byteArrayResource);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(multiValueMap, httpHeaders);

        restTemplate.postForEntity("http://localhost:8082/engine-rest/deployment/create", httpEntity, Object.class);
    }

    public void deployWithAnnotations(String filename, String data) throws Exception {
        data = compilerService.compile(data);
        deploy(filename, data);
    }
}
