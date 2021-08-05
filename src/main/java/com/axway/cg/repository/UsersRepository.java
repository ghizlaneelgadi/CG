package com.axway.cg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axway.cg.domain.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {

}
