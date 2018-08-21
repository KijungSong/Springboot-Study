package com.daebaksong.myboard.service;

import com.daebaksong.myboard.domin.Member;

public interface MemberService {
    Member addMember(Member member);
    Member getMember(String email);
}
