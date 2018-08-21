package com.daebaksong.myboard.domin;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="member")
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID 자동생성
    private String name;
    private String email;
    private String passwd;
    private LocalDateTime regdate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MemberRole> memberRoles;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Board> boards;

    // helper method
    public void addMemberRole(MemberRole memberRole){
        memberRoles.add(memberRole);
        if(memberRole.getMember() != this){
            memberRole.setMember(this);
        }
    }
}
