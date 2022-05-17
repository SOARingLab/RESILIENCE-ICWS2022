package top.soaringlab.longtailed.compilerbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.soaringlab.longtailed.compilerbackend.service.DeploymentService;

@RestController
@RequestMapping(value = "/api/deployment")
public class DeploymentController {

    @Autowired
    private DeploymentService deploymentService;

    @PostMapping(value = "/deploy")
    public void deploy(String filename, String data) {
        deploymentService.deploy(filename, data);
    }

    @PostMapping(value = "/deploy-with-annotations")
    public void deployWithAnnotations(String filename, String data) throws Exception {
        deploymentService.deployWithAnnotations(filename, data);
    }
}
