package com.conatuseus.webservice.user.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Setter
@Getter
@NoArgsConstructor
@Builder
public class UserUpdateRequest {

    @NotBlank(message = "이메일을 입력해 주세요.")
    @Email(message = "이메일 양식을 지켜주세요.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해 주세요.")
    private String password;

    @NotBlank(message = "이름을 입력해 주세요.")
    private String name;

    @NotBlank(message = "성별을 입력해 주세요.")
    @Pattern(regexp = "^[M|W]")
    private String gender;

    @NotBlank(message = "휴대폰 번호를 입력해 주세요.")
    @Pattern(regexp = "010[0-9]{8}", message = "11자리의 숫자만 입력가능합니다.")
    private String phoneNumber;

    public UserUpdateRequest(final String email, final String password, final String name, final String gender, final String phoneNumber) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }
}
