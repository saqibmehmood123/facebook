package com.example.facebookclone.repository;

import com.example.facebookclone.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long>
{
   List<Users> findByIdIn(List<Long> list);
   Users findByEmail(String email);


}
