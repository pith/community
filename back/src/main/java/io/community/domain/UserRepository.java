package io.community.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Pierre Thirouin
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
