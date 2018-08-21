package com.daebaksong.myboard.repository;

import com.daebaksong.myboard.domin.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRoleRepository extends JpaRepository<MemberRole, Long> {
}
