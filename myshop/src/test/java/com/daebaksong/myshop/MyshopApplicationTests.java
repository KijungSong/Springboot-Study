package com.daebaksong.myshop;

import com.daebaksong.myshop.domain.Member;
import com.daebaksong.myshop.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

// @RunWith: junit을 확장할 수 있는 어노테이션
// SpringRunner: 내부적으로 Application Context를 지님.
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional // 설정을 해야 테스트 메서드 단위로 트랜잭션이 설정된다. (없으면 레퍼지토리 메서드 실행 이후 롤백이 되어 정상 동작이 되지 않는다.)
public class MyshopApplicationTests {
	@Autowired
	MemberRepository memberRepository;

	@Test
	public void contextLoads() { // 설정에 문제가 없는지 체크하는 테스트 메서드
	}

	@Test
	public void testNotNull() {
		Assert.assertNotNull(memberRepository);
	}

	@Test
	public void testSaveMember() {
		System.out.println("-----------------");
		Member member = new Member();
		member.setName("Kim");
		member.setEmail("kim@gmail.com");
		member.setPassword("1234");

		memberRepository.save(member);
		System.out.println("member.getId():" + member.getId());

		Member member2 = memberRepository.getOne(member.getId());

		System.out.println("member.hashCode(): " + member.hashCode());
		System.out.println("member2.hashCode(): " + member2.hashCode());
		if (member == member2) {
			System.out.println("member == member2");
		} else {
			System.out.println("member != member2");
		}
		System.out.println("-----------------");
	}

}
