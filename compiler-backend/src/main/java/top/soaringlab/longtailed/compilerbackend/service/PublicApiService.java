package top.soaringlab.longtailed.compilerbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import top.soaringlab.longtailed.compilerbackend.domain.PublicApi;
import top.soaringlab.longtailed.compilerbackend.repository.PublicApiRepository;

@Service
public class PublicApiService {

    @Autowired
    private PublicApiRepository publicApiRepository;

    public Page<PublicApi> findAll(int page, int size) {
        return publicApiRepository.findAll(PageRequest.of(page, size));
    }

    public PublicApi save(PublicApi publicApi) {
        return publicApiRepository.save(publicApi);
    }

    public void delete(PublicApi publicApi) {
        publicApiRepository.delete(publicApi);
    }
}
