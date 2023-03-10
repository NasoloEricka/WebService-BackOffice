package enchere.enchere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import enchere.enchere.controller.CategorieController;
import enchere.enchere.controller.DureeController;
import enchere.enchere.controller.SoldeUtilisateurController;

@ComponentScan(basePackageClasses = CategorieController.class)
@ComponentScan(basePackageClasses = DureeController.class)
@ComponentScan(basePackageClasses = SoldeUtilisateurController.class)


@RestController
@SpringBootApplication
public class EnchereApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnchereApplication.class, args);
	}

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                        .allowedHeaders("*");
            }
        }; 
    }

}
