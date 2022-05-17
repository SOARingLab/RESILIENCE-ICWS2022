package top.soaringlab.longtailed.compilerbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.soaringlab.longtailed.compilerbackend.domain.PublicApi;

public interface PublicApiRepository extends JpaRepository<PublicApi, Long> {
}
