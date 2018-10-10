package com.zhaoyu.spingbootsecurity.practice1.repository;

import com.zhaoyu.spingbootsecurity.practice1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByIdAndName(Long id, String name);

    public User findByNameAndPassword(String name, String possword);
}
