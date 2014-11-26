package goods;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;

@Configuration
@PropertySource(value = "classpath:/test.properties", ignoreResourceNotFound = true)
@EnableWebMvc
@Import(CommonConfig.class)
@ComponentScan(basePackages = {
        "goods.service",
        "goods.controller"
})
public class MvcTestConfig extends WebConfig {

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return Mockito.mock(EntityManagerFactory.class);
    }
}
