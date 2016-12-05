package com.amir.repository;

import com.amir.entities.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Amir on 2016-11-27.
 * spring-weblog
 */
public interface BlogUserRepository extends JpaRepository<BlogUser ,Long> {

    public BlogUser findByEmail(String email);
}
