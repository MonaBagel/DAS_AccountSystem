package za.ac.nwu.das.web.sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.das.domain.service.GeneralResponse;

@RestController
public class AccountTypeController {

    @GetMapping("/all")
    public GeneralResponse<String> getAll(){
        return new GeneralResponse<String>(true, "No types found");
    }
}
