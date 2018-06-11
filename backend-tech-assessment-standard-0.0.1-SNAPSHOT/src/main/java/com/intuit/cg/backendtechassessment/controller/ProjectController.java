package com.intuit.cg.backendtechassessment.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.cg.backendtechassessment.controller.requestmappings.RequestMappings;
import com.intuit.cg.backendtechassessment.domain.Project;
import com.intuit.cg.backendtechassessment.service.ProjectService;
import com.intuit.cg.backendtechassessment.service.SellerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController extends AbstractRestHandler {


	    
	 @Autowired
	    private ProjectService projectService;
	 @Autowired
	    private SellerService sellerService;
	 
	 @RequestMapping(value = "",
	            method = RequestMethod.POST,
	            consumes = {"application/json"},
	            produces = {"application/json"})
	    @ResponseStatus(HttpStatus.CREATED)
	    @ApiOperation(value = "Create a project resource.", notes = "Returns the URL of the new resource in the Location header.")
	    public void createProject(@RequestBody Project project, 
	    		@RequestParam(value = "sellerId", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer sellerId,
	                                 HttpServletRequest request, HttpServletResponse response) {
		 project.setSeller(sellerService.getSeller(sellerId).get());
		 
		 Project createdProject = this.projectService.createProject(project);
	        response.setHeader("Location", request.getRequestURL().append("/").append(createdProject.getProjectId()).toString());
	    }	 
	
	@RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all projects.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    Page<Project> getAllProject(@ApiParam(value = "The page number (zero-based)", required = true)
                                      @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @ApiParam(value = "Tha page size", required = true)
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
        return this.projectService.getAllProjects(page, size);
    }
	
	@RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single project.", notes = "You have to provide a valid project ID.")
    public
    @ResponseBody
    Project getHotel(@ApiParam(value = "The ID of the project.", required = true)
                             @PathVariable("id") Long id,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
		Optional<Project> project = this.projectService.getProject(id);
      // checkResourceFound(project.getProject(id));
        return project.get();
    }
	
	@RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a project resource.", notes = "You have to provide a valid project ID in the URL. Once deleted the resource can not be recovered.")
    public void deleteHotel(@ApiParam(value = "The ID of the existing hotel resource.", required = true)
                                 @PathVariable("id") Long id, HttpServletRequest request,
                                 HttpServletResponse response) {
		Optional<Project> project = this.projectService.getProject(id);
        this.projectService.deleteProject(project.get().getProjectId());
    }
	
	@RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a hotel resource.", notes = "You have to provide a valid hotel ID in the URL and in the payload. The ID attribute can not be updated.")
    public void updateHotel(@ApiParam(value = "The ID of the existing hotel resource.", required = true)
                                 @PathVariable("id") Long id, @RequestBody Project project,
                                 HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.projectService.getProject(id));
        Optional<Project> updateProject = this.projectService.getProject(id);
        updateProject.get().setProjectName(project.getProjectName());
        this.projectService.updateProject(project);
    }
}
