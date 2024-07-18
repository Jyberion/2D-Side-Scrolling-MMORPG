package com.jyberion.mmorpg.loginserver.repository;

import com.jyberion.mmorpg.loginserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsername(String username);
}
