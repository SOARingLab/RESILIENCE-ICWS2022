package top.soaringlab.longtailed.compilerbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.soaringlab.longtailed.compilerbackend.compiler.Compiler;
import top.soaringlab.longtailed.compilerbackend.compiler.CompilerScript;
import top.soaringlab.longtailed.compilerbackend.repository.PublicApiRepository;

@Service
public class CompilerService {

    @Autowired
    private PublicApiRepository publicApiRepository;

    public String compile(String file) throws Exception {
        Compiler compiler = new Compiler();
        compiler.publicApiList = publicApiRepository.findAll();
        return compiler.compile(file);
    }

    public String compileScript(String text) throws Exception {
        CompilerScript compilerScript = new CompilerScript();
        return compilerScript.compileScript(text);
    }
}
