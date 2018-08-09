package com.daebaksong.myshop.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

// lombok을 쓰면 별도로 setter, getter를 만들지 않고 @Setter, @Getter 어노테이션 추가하면 된다
@Entity                 // Entity로 관리할때 추가.
@Table(name = "member") // 이 테이블과 매핑하게 만들겠다!
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member implements Serializable {
    // 필드 선언
    @Id // 이 필드가 ID값이다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // identity 컬럼을 이용해서 DB에서 자동으로 생성하는 방식.
    private Long id;
    private String name;
    private String email;
    private String password;
}
