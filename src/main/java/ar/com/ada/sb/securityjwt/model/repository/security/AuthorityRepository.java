package ar.com.ada.sb.securityjwt.model.repository.security;

import ar.com.ada.sb.securityjwt.model.entity.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("authorityRepository")
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
