package top.soaringlab.longtailed.enginebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.soaringlab.longtailed.enginebackend.domain.ProcessLog;
import top.soaringlab.longtailed.enginebackend.repository.ProcessLogRepository;

@Service
@Transactional
public class ProcessLogService {

    @Autowired
    private ProcessLogRepository processLogRepository;

    public Page<ProcessLog> findAll(int page, int size) {
        return processLogRepository.findAll(PageRequest.of(page, size));
    }

    public Page<ProcessLog> findByBusinessKey(String businessKey, int page, int size) {
        return processLogRepository.findByBusinessKey(businessKey, PageRequest.of(page, size));
    }

    public void log(String businessKey, String message) {
        processLogRepository.save(new ProcessLog(businessKey, message));
    }
}
