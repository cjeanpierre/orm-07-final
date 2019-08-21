package com.puthisastra.first;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@Sql("createJob.sql")
public class JobServiceTest {

	@Autowired
	private JobService jobService;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Test
	public void transactionsWithAnnotationWithInitalImportData() {
		jobService.transactionsWithAnnotation();
		List<Job> jobs = jobRepository.findAll();
 		assertEquals(6, jobs.size());
	}
	
	@Test
	@Sql
	public void transactionsWithAnnotationShouldCreate3Jobs() {
		jobService.transactionsWithAnnotation();
		List<Job> jobs = jobRepository.findAll();
		assertEquals(3, jobs.size());
	}
	
}
