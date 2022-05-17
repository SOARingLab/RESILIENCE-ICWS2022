package top.soaringlab.longtailed.enginebackend.service;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RepositoryService;
import org.springframework.stereotype.Service;

@Service
public class DeploymentService {

    public void create(String filename, String file) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment()
                .addString(filename, file)
                .deploy();
    }
}
