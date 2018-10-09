package com.zhaoyu.spingbootsecurity.practice1.repository;

import com.zhaoyu.spingbootsecurity.practice1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
