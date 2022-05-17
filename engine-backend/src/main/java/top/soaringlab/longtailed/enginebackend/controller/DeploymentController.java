package top.soaringlab.longtailed.enginebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.soaringlab.longtailed.enginebackend.dto.Message;
import top.soaringlab.longtailed.enginebackend.service.DeploymentService;

import java.util.Scanner;

@RestController
@RequestMapping(value = "/api/deployment")
public class DeploymentController {

    @Autowired
    private DeploymentService deploymentService;

    @PostMapping("/create")
    public Message create(MultipartFile file) {
        try {
            Scanner scanner = new Scanner(file.getInputStream());
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
            deploymentService.create(file.getOriginalFilename(), stringBuilder.toString());
            return new Message("Success");
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(e.getMessage());
        }
    }
}
