package za.ac.nwu.das.web.sb.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.das.logic.config.LogicConfig;

@Import({LogicConfig.class})
@Configuration
@ComponentScan(basePackages = {
    "za.ac.nwu.das.web.sb.controller",
    "za.ac.nwu.das.web.sb.exception"
})
public class SpringWebConfig {

}
