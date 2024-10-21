package rh.home;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication( scanBasePackages = "rh.home" )
@EnableJpaRepositories(basePackages = { "rh.home.repositories" } )
@EntityScan( basePackageClasses = { rh.home.data.MabEntry.class } )   
public class TestApplication {

}
