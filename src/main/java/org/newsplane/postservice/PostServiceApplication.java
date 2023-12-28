package org.newsplane.postservice;

import java.util.List;

import org.newsplane.postservice.entities.Competency;
import org.newsplane.postservice.entities.PostCategory;
import org.newsplane.postservice.repositories.CompetencyRepository;
import org.newsplane.postservice.repositories.PostCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PostServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(PostCategoryRepository rep, CompetencyRepository cmpRep){
		return args->{

			/*var cat = PostCategoryImpl.builder()
			.categoryName("informatic2")
			.competencies(List.of(Competency.builder().competancyName("jEE").competencyDescription("backend").build(),
			Competency.builder().competancyName("django").competencyDescription("backend").build()))
			.build();
			rep.save(cat);*/

			/*var cat = rep.findById(2L).get();
			var cpt = Competency.builder()
			.competancyName("react_namtive")
			.competencyDescription("mobile")
			.post_category(cat).build();
			cmpRep.save(cpt);

			var cpt2 = Competency.builder()
			.competancyName("angular")
			.competencyDescription("web")
			.post_category(cat).build();
			cmpRep.save(cpt2);*/
		};
	}
}
