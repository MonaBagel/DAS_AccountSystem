package za.ac.nwu.das.translator.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.das.repo.config.RepoConfig;

@Import({RepoConfig.class})
@Configuration
public class TranslatorConfig {
}
