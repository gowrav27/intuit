package com.intuit.cg.backendtechassessment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.intuit.cg.backendtechassessment.dao.repo.ProjectRepository;
import com.intuit.cg.backendtechassessment.domain.Project;


@Service
public class ProjectService {
	@Autowired
    private ProjectRepository projectRepository;
	
	public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Optional<Project> getProject(long id) {
        return projectRepository.findById(id);
    }

    public void updateProject(Project project) {
        projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
    
    public Page<Project> getAllProjects(Integer page, Integer size) {
    	return projectRepository.findAll(PageRequest.of(page, size));
    }
}
