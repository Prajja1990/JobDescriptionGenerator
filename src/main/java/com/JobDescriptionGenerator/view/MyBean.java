package com.JobDescriptionGenerator.view;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Scope("view")
public class MyBean {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ConfigProperties configProperties;
	
	public String jobTitel;
	public String jobSkill;
	public String jobCompany;
	public String jobLocation;
	
	public Job jobResponse;
	
	public String skills;
	public String roles;
	public String about;

	public MyBean() {
		System.out.println("Created!");
	}

	public String getFrom() {
		return this.toString();
	}

	public String getDate() {
		return new Date().toString();
	}

	public String getJobTitel() {
		return jobTitel;
	}

	public void setJobTitel(String jobTitel) {
		this.jobTitel = jobTitel;
	}

	public String getJobSkill() {
		return jobSkill;
	}

	public void setJobSkill(String jobSkill) {
		this.jobSkill = jobSkill;
	}

	public String getJobCompany() {
		return jobCompany;
	}

	public void setJobCompany(String jobCompany) {
		this.jobCompany = jobCompany;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	
	
	
	public Job getJobResponse() {
		return jobResponse;
	}

	public void setJobResponse(Job jobResponse) {
		this.jobResponse = jobResponse;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public void generate()
	{
		JobRequest job = new JobRequest();
		job.setInput_company_name(jobCompany);
		job.setInput_job_title(jobTitel);
		job.setInput_location(jobLocation);
		job.setInput_skills(jobSkill);
			
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<JobRequest> entity = new HttpEntity<JobRequest>(job, headers);
		
		 jobResponse =restTemplate.exchange("http://" + configProperties.getHostName() + "/job_description_generator/predictJobDescription", HttpMethod.POST,
				entity, Job.class).getBody();
		clean();
	
	}
	
	private void clean()
	{
		setJobCompany(null);
		setJobTitel(null);
		setJobLocation(null);
		setJobSkill(null);
	}

}
