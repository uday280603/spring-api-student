package com.ro.RoSpringBootApi.Repository;

import com.ro.RoSpringBootApi.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student ,Long> {
}
