package com.daebaksong.myboard.repository;

import com.daebaksong.myboard.domin.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
