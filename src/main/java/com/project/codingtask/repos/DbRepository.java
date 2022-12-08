package com.project.codingtask.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.codingtask.entity.DbModel;

@Repository
public interface DbRepository extends JpaRepository<DbModel,String> {

}
