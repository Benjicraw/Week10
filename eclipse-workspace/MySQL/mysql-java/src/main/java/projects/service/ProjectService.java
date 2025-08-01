package projects.service;

import projects.entity.Project;
import projects.exception.DbException;

import java.util.List;
import java.util.NoSuchElementException;

import projects.dao.ProjectDao;

public class ProjectService {
	private ProjectDao projectDao = new ProjectDao();
	public Project addProject(Project project) {
		return projectDao.insertProject(project);
	}
	public Project fetchProjectById(Integer projectId) {
		// TODO Auto-generated method stub
		return projectDao.fetchProjectById(projectId).orElseThrow(() -> new NoSuchElementException("Project with project ID=" + projectId +" does not exist."));
	}
	public List<Project> fetchAllProjects() {
		// TODO Auto-generated method stub
		return projectDao.fetchAllProjects();
	}
	public void deleteProject(Integer projectId) {
		if (!projectDao.deleteProject(projectId)) {
			throw new DbException("Project with Id =" + projectId + "does not exist.");	
		}
		
	}
	public void modifyProjectDetails(Project project) {
		if (!projectDao.modifyProjectDetails(project)) {
			throw new DbException("Project with Id =" + project.getProjectId() + "does not exist.");	
		}
	}
	
	
}
