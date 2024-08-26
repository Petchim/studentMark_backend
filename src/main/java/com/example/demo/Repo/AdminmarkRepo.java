package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AdminmarkModel;

@Repository
public interface AdminmarkRepo extends JpaRepository<AdminmarkModel , Integer> {

	AdminmarkModel findByRollnumber(String rollnumber);

}
