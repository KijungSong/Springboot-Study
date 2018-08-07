package com.daebaksong.myshop.domain;

import lombok.*;

// lombok을 쓰면 별도로 setter, getter를 만들지 않고 @Setter, @Getter 어노테이션 추가하면 된다
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
    // 필드 선언
    private Long id;
    private String name;
    private String email;
    private String password;
}
