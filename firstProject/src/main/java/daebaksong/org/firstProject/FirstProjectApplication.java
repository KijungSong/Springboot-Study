package daebaksong.org.firstProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstProjectApplication {

	// @Bean: spring bean 컨테이너에게 빈을 생성해 달라는 어노테이션
	// 이 메서드 이름이 Bean ID가 된다.
	@Bean
	public HelloController helloController() {
		// 아래 메서드 출력결과: daebaksong.org.firstProject.FirstProjectApplication$$EnhancerBySpringCGLIB$$7741d4ae
		System.out.println(getClass().getName());
		return new HelloController();
	}

	public static void main(String[] args) {
		// java config class을 첫번째 인자로 넣는다.
		SpringApplication.run(FirstProjectApplication.class, args);
	}
}
