package com.holiday.repository;

import com.holiday.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer> {

    UserModel findByUserName(String userName);

    List<UserModel> findByUserCity(String userCity);
}
