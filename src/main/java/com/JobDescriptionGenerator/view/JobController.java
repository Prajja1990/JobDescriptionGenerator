package com.JobDescriptionGenerator.view;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JobController {
	
	@PostMapping("/job_description_generator/predictJobDescription")
	public Job getDetatils(@RequestBody JobRequest job)
	{
		Job jobDetails = new Job();
		jobDetails.setAbout_company("Wells");
		jobDetails.setRoles("Engineer");
		jobDetails.setSkills("java");
		return jobDetails;
	}
	

}
