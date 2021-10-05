package za.ac.nwu.das.translator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.das.repo.config.RepoConfig;
import za.ac.nwu.das.repo.persistence.AccountTypeRepo;

@Import({RepoConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.das.translator"
})
public class TranslatorConfig {
}
