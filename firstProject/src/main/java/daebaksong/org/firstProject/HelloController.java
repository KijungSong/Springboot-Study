package daebaksong.org.firstProject;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public HelloController() {
        System.out.println("Hello Controller!!");
    }
}
