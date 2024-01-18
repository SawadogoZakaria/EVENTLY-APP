package com.evently.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.evently.app.model.Users;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UsersRepository extends CrudRepository<Users, Long>{

}
