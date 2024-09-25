package com.sbb.sbb.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
    @NotEmpty(message = "아이디 입력")
    @Size(min = 3, max = 20)
    private String username;

    @NotEmpty(message = "비밀번호 입력")
    private String password1;

    @NotEmpty(message = "비밀번호 확인")
    private String password2;

    @NotEmpty(message = "이메일 입력")
    private String nickname;
}
