package top.soaringlab.longtailed.compilerbackend.service;

import org.springframework.stereotype.Service;
import top.soaringlab.longtailed.compilerbackend.verifier.FunctionalVerifier;
import top.soaringlab.longtailed.compilerbackend.verifier.NonFunctionalVerifier;

import java.util.List;
import java.util.Map;

@Service
public class VerifierService {

    public Map<String, List<String>> verifyFunctional(String file, String start) throws Exception {
        FunctionalVerifier functionalVerifier = new FunctionalVerifier();
        return functionalVerifier.functionalVerify(file, start);
    }

    public boolean verifyNonFunctional(String file) throws Exception {
        NonFunctionalVerifier nonFunctionalVerifier = new NonFunctionalVerifier();
        return nonFunctionalVerifier.nonFunctionalVerify(file);
    }
}
