package com.daebaksong.myboard.service.impl;

import com.daebaksong.myboard.domin.Member;
import com.daebaksong.myboard.repository.MemberRepository;
import com.daebaksong.myboard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    //org.springframework.transaction.annotation.Transactional, 하나의 트랜잭션 단위로 실행 실행중 Exception이 발생하면 롤백.
    @Transactional
    public Member addMember(Member member) {
        // member의 암호를 암호화한다. (Controller에서 암호화를 할지, Service에서 할지는 생각해보자)
        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories
                        .createDelegatingPasswordEncoder();

        String encodePasswd = passwordEncoder.encode(member.getPasswd());
        System.out.println("encode: " + encodePasswd);
        member.setPasswd(encodePasswd);
        // memberRole을 member에 추가한다.
        // member를 저장한다.
        // member를 리턴한다.
        return null;
    }

    @Override
    // @Transaction의 경우 readOnly 기본 값이 false이므로 읽기만 하는 메서드는 true를 설정해준다.
    // true를 안주면 메서드 동작이후 commit동작을 한다.
    // 조회 메서드에 왜 설정을 하느냐 하면 다른 서비스 메서드에서 호출될 경우 트랜잭션이 중첩될수 있기때문에 설정을 해줘야한다.
    @Transactional(readOnly = true)
    public Member getMember(String email) {
        return null;
    }
}
