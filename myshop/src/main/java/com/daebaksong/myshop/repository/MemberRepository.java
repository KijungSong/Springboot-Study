package com.daebaksong.myshop.repository;

import com.daebaksong.myshop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// JpaReposiory를 상속받은 인터페이스의 구현체는 자동으로 생성된다.
// 자동으로 생성된 객체에서 내부적으로 EntityManager에 접근하여 동작한다
public interface MemberRepository extends JpaRepository<Member, Long> {
    /*
    1. Method Query
    * 메서드 이름을 보고 자동으로 쿼리를 만들어준다!

    * count로 시작하면 count를 구하겠다는 의미
    * ByName : name 컬럼을 통해
     */
    public Long countByNameContains(String name);

    /*
    2. @Query
    * JPQL을 사용 SQL이 아니다 아래 내용을 기반으로 SQL을 생성하여 호출
    * 네이티브 SQL도 사용할수 있지만 그럴때에는 네이티브 SQL을 사용한다는 추가 정보를 설정해 줘야한다.
    * */
    @Query("SELECT COUNT(m) FROM Member m WHERE m.name = :name") //JPQL
    public Long countAllByName(@Param("name") String name);
}
