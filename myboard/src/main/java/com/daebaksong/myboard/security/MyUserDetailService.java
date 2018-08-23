package com.daebaksong.myboard.security;

import com.daebaksong.myboard.domin.Member;
import com.daebaksong.myboard.domin.MemberRole;
import com.daebaksong.myboard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    MemberService memberService;

    @Override
    @Transactional(readOnly = true) // 설정을 해줘야만 MemberRole을 Lazy 로딩이 가능하다
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // 1.email을 이용하여 Member 엔티티를 찾고
        Member member = memberService.getMember(email);
        if (member == null){
            throw new UsernameNotFoundException("user name not found:" +email);
        }

        // MemberRole 레이지로딩
        Set<MemberRole> memberRoles = member.getMemberRoles();
        List<GrantedAuthority> list = new ArrayList<>();

        // 2.UserDetails를 구현하고 있는 객체에 Member의 id와 암호를 저장한다.
        for(MemberRole memberRole : memberRoles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+ memberRole.getName()));
        }
        UserDetails user = new User(email, member.getPasswd(), list);
        return user;
    }
}
