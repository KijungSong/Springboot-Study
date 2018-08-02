package daebaksong.org.firstProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    public HelloController() {
        System.out.println("Hello Controller!!");
    }

    // http://localhost:8080/hello
    // @ResponseBody가 붙으면 메서드가 리턴해주는 값이 응답값이 된다.
    // @ResponseBody가 없으면 view이름이 된다.
    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    // /hello2?name=kim&age=5
    @GetMapping("/hello2")
    public String sayHello2(@RequestParam(name ="name", required = true)String name,
                           @RequestParam(name="age", required = false, defaultValue = "0")int age) {
        return "hello "+ name + " , "+age;
    }


    // /hello2?name=kim&age=5
    // 되도록 HttpServletRequest 쓰지말고 어노테이션으로 받아서 사용하는 방식을 쓰자.
    @GetMapping("/hello3")
    public String sayHello3(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        return "hello "+ name + " , "+age;
    }

    // /hello2?name=kim&age=5
    // DTO로 받는 방식! 파라미터 이름과 DTO의 프로퍼티 이름이 같아야한다!
    @GetMapping("/hello4")
    public String sayHello4(@ModelAttribute HelloDTO helloDTO) {
        return "hello "+ helloDTO.getName() + " , "+ helloDTO.getAge();
    }
}
