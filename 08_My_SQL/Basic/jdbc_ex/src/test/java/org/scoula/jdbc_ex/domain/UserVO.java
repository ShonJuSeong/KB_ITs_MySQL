package org.scoula.jdbc_ex.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserVO{
//필드 정의
    private String id;
    private String password;
    private String name;
    private String role;
}