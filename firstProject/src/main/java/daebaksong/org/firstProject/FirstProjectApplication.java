package daebaksong.org.firstProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
@SpringBootApplication이 클래스의가 package가 base 경로다.
@SpringBootApplication은 @ComponentScan을 상속 받고 있음.
	@CoponentScan은 base 경로에서 @Component를 지닌 클래스들을 찾아서 Bean으로 등록하는 역할을 한다.

@Component를 상속받은 대표적인 어노테이션은 @Controller, @Service, @Repository 등이 있다.
*/
@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
		// java config class을 첫번째 인자로 넣는다.
		SpringApplication.run(FirstProjectApplication.class, args);
	}
}
