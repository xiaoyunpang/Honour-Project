package nsercServer;

import nsercServer.ResearchDAO;
import nsercServer.ResearchDAOImpl;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import inm.client.InmTemplate;
import inm.client.InmTemplateFactory;

@Configuration
@ComponentScan(basePackages="nsercServer")
@EnableWebMvc
public class awardJDBC extends WebMvcConfigurerAdapter {
	@Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
     
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
 
    @Bean
    public InmTemplate getDataSource() {
    	InmTemplateFactory.buildTemplate("rose.whu.edu.cn", 3008);
    	InmTemplate inm = InmTemplateFactory.getInitializedTemplate();
        //DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //dataSource.setUrl("jdbc:mysql://localhost:3306/nserc");
        //dataSource.setUsername("root");
        //dataSource.setPassword("921113");
        System.out.println("Success!!!!!!!!!!!!");
         
        return inm;
    }
     
    @Bean
    public ResearchDAO getResearchDAO() {
    	System.out.println("I'm here!!!");
        return new ResearchDAOImpl(getDataSource());
    }

}
