package com.sandeep.ems.repository;

import com.sandeep.ems.entites.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long> {

    @Query("select e from Employees e where e.location=:location")
    List<Employees> findByLocation(@Param("location") String location);
}
