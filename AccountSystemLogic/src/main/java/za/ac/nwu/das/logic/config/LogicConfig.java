package za.ac.nwu.das.logic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.das.translator.config.TranslatorConfig;

@Import({TranslatorConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.das.logic.flow"
})
public class LogicConfig {
}
