package com.daebaksong.myboard.domin;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
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

    // mappedBy = "member"를 설정안해주면 다:다 관계로 보고 매핑하는 테이블을 추가로 생성한다.
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MemberRole> memberRoles = new HashSet<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private Set<Board> boards;

    // helper method
    public void addMemberRole(MemberRole memberRole){
        memberRoles.add(memberRole);
        if(memberRole.getMember() != this){
            memberRole.setMember(this);
        }
    }
}
