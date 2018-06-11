package com.intuit.cg.backendtechassessment.dao.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.intuit.cg.backendtechassessment.domain.Project;


public interface ProjectRepository extends CrudRepository<Project, Long> {
	Page findAll(Pageable pageable);
}
