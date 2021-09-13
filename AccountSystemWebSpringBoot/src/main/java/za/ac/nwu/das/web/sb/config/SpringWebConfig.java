package za.ac.nwu.das.web.sb.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
    "za.ac.nwu.das.web.sb.controller",
    "za.ac.nwu.das.web.sb.exception"
})
public class SpringWebConfig {

}
