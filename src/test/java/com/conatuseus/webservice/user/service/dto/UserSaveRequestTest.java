package com.conatuseus.webservice.user.service.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class UserSaveRequestTest {

    private UserSaveRequest user;
    private ValidatorFactory factory;
    private Validator validator;

    @BeforeEach
    void setUp() {
        user = UserSaveRequest.builder()
            .email("conatuseus@gmail.com")
            .password("1234")
            .gender("M")
            .name("conas")
            .phoneNumber("01099996384")
            .build();
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("blank email 검사")
    void blank_Email() {
        UserSaveRequest blankEmailUser = UserSaveRequest.builder()
            .email("")
            .password("1234")
            .gender("M")
            .name("conas")
            .phoneNumber("01099996384")
            .build();
        checkUserValidateMessage(blankEmailUser, "이메일을 입력해 주세요.");
    }

    @Test
    @DisplayName("올바르지 않은 이메일 양식 검사")
    void invalid_Email() {
        UserSaveRequest invalidEmailUser = UserSaveRequest.builder()
            .email("helloWorld!")
            .password("1234")
            .gender("M")
            .name("conas")
            .phoneNumber("01099996384")
            .build();
        checkUserValidateMessage(invalidEmailUser, "이메일 양식을 지켜주세요.");
    }

    @Test
    void blank_Password() {
        UserSaveRequest blankPasswordUser = UserSaveRequest.builder()
            .email("conatuseus@gmail.com")
            .password("")
            .gender("M")
            .name("conas")
            .phoneNumber("01099996384")
            .build();
        checkUserValidateMessage(blankPasswordUser, "비밀번호를 입력해 주세요.");
    }

    @Test
    void blank_gender() {
        UserSaveRequest blankGender = UserSaveRequest.builder()
            .email("conatuseus@gmail.com")
            .password("1234")
            .gender("")
            .name("conas")
            .phoneNumber("01099996384")
            .build();

        checkUserValidateMessage(blankGender, "성별을 입력해 주세요.");
    }

    @Test
    void invalid_gender() {
        UserSaveRequest invalidGender = UserSaveRequest.builder()
            .email("conatuseus@gmail.com")
            .password("1234")
            .gender("K")
            .name("conas")
            .phoneNumber("01099996384")
            .build();

        checkUserValidateMessage(invalidGender, "남자 또는 여자만 선택 가능합니다.");
    }

    @Test
    void blank_Name() {
        UserSaveRequest blankNameUser = UserSaveRequest.builder()
            .email("conatuseus@gmail.com")
            .password("1234")
            .gender("M")
            .name("")
            .phoneNumber("01099996384")
            .build();
        checkUserValidateMessage(blankNameUser, "이름을 입력해 주세요.");
    }

    @Test
    void blank_PhoneNumber() {
        UserSaveRequest blankPhoneNumberUser = UserSaveRequest.builder()
            .email("conatuseus@gmail.com")
            .password("1234")
            .gender("M")
            .name("conas")
            .phoneNumber("")
            .build();
        checkUserValidateMessage(blankPhoneNumberUser, "휴대폰 번호를 입력해 주세요.");
    }

    @Test
    @DisplayName("휴대폰 번호가 11자리가 안되는 경우")
    void invalid_PhoneNumber() {
        UserSaveRequest invalidPhoneNumberUser = UserSaveRequest.builder()
            .email("conatuseus@gmail.com")
            .password("1234")
            .gender("M")
            .name("conas")
            .phoneNumber("0101234")
            .build();
        checkUserValidateMessage(invalidPhoneNumberUser, "11자리의 숫자만 입력가능합니다.");
    }

    @Test
    @DisplayName("휴대폰 번호가 11자리지만 문자가 포함된 경우")
    void not_number_PhoneNumber() {
        UserSaveRequest invalidPhoneNumberUser = UserSaveRequest.builder()
            .email("conatuseus@gmail.com")
            .password("1234")
            .gender("M")
            .name("conas")
            .phoneNumber("0109999638u")
            .build();
        checkUserValidateMessage(invalidPhoneNumberUser, "11자리의 숫자만 입력가능합니다.");
    }

    @Test
    void getEmail() {
        assertThat(user.getEmail()).isEqualTo("conatuseus@gmail.com");
    }

    @Test
    void getPassword() {
        assertThat(user.getPassword()).isEqualTo("1234");
    }

    @Test
    void getGender() {
        assertThat(user.getGender()).isEqualTo("M");
    }

    @Test
    void getName() {
        assertThat(user.getName()).isEqualTo("conas");
    }

    @Test
    void getPhoneNumber() {
        assertThat(user.getPhoneNumber()).isEqualTo("01099996384");
    }

    private void checkUserValidateMessage(UserSaveRequest user, String message) {
        Set<ConstraintViolation<UserSaveRequest>> constraintViolations = validator.validate(user);
        assertThat(constraintViolations)
            .extracting(ConstraintViolation::getMessage)
            .contains(message);
    }
}
