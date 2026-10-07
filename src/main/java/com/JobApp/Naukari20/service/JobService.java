package com.JobApp.Naukari20.service;	



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.JobApp.Naukari20.model.JobPost;
import com.JobApp.Naukari20.repo.JobRepo;
import java.util.ArrayList;
import java.util.List;


@Service
public class JobService {

	@Autowired
	public JobRepo repo;
	
	
		
		
		
		//method to return all JobPosts
		public List<JobPost> getAllJobs() {
			return repo.findAll();

			
		}
		
		
		
		


		
		
		
		// method to add a jobPost
		public void addJob(JobPost jobPost) {
			 repo.save(jobPost);
		
		}




//method to get job by id
		public JobPost getJob(int postId) {
			
			return repo.findById(postId).orElse(new JobPost());
		}




//method to update job with job post object
		public void updateJob(JobPost jobPost) {
		repo.save(jobPost);
			
		}




//method to delete job post by id 
		public void deleteJob(int postId) {
			repo.deleteById(postId);
			
		}









		public void load() {
			List<JobPost> jobs = new ArrayList<>(List.of(
					new JobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, tech("Java", "Spring", "SQL", "API")),
					new JobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, tech("Python", "Machine Learning", "TensorFlow", "API")),
					new JobPost(3, "Frontend Developer", "Create API amazing user interfaces with our talented frontend team.", 2, tech("JavaScript", "React", "CSS", "API")),
					new JobPost(4, "Network Engineer", "Design and API maintain our robust network infrastructure.", 4, tech("Cisco", "Routing", "Firewalls")),
					new JobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, tech("UI/UX Design", "Adobe XD", "Prototyping"))
			));

			repo.saveAll(jobs);
		}

		private List<String> tech(String... skills) {
			return new ArrayList<>(List.of(skills));
		}









		public List<JobPost> search(String keyword) {
		
			return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
		}



	
}
