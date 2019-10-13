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
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class UserSaveRequestDtoTest {

    private UserSaveRequestDto user;
    private ValidatorFactory factory;
    private Validator validator;

    @BeforeEach
    void setUp() {
        user = new UserSaveRequestDto();
        user.setEmail("conatuseus@gmail.com");
        user.setName("conatuseus");
        user.setPassword("conas");
        user.setPhoneNumber("01099996384");

        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void set_valid_Email() {
        assertDoesNotThrow(() -> user.setEmail("abc@gmail.com"));
    }

    @Test
    @DisplayName("blank email 검사")
    void set_blank_Email() {
        user.setEmail("");
        checkUserValidateMessage("이메일을 입력해 주세요.");
    }

    @Test
    @DisplayName("올바르지 않은 이메일 양식 검사")
    void set_invalid_Email() {
        user.setEmail("helloWorld!");
        checkUserValidateMessage("이메일 양식을 지켜주세요.");
    }

    @Test
    void setPassword() {
        assertDoesNotThrow(() -> user.setPassword("1234"));
    }

    @Test
    void set_blank_Password() {
        user.setPassword("");
        checkUserValidateMessage("비밀번호를 입력해 주세요.");
    }

    @Test
    void setName() {
        assertDoesNotThrow(()->user.setName("coonas"));
    }

    @Test
    void set_blank_Name() {
        user.setName("");
        checkUserValidateMessage("이름을 입력해 주세요.");
    }

    @Test
    void setPhoneNumber() {
        assertDoesNotThrow(()->user.setPhoneNumber("01099996383"));
    }

    @Test
    void set_blank_PhoneNumber() {
        user.setPhoneNumber("");
        checkUserValidateMessage("휴대폰 번호를 입력해 주세요.");
    }

    @Test
    @DisplayName("휴대폰 번호가 11자리가 안되는 경우")
    void set_invalid_PhoneNumber() {
        user.setPhoneNumber("0101234");
        checkUserValidateMessage("11자리의 숫자만 입력가능합니다.");
    }

    @Test
    @DisplayName("휴대폰 번호가 11자리지만 문자가 포함된 경우")
    void set_not_number_PhoneNumber() {
        user.setPhoneNumber("0101234567a");
        checkUserValidateMessage("11자리의 숫자만 입력가능합니다.");
    }

    @Test
    void getEmail() {
        assertThat(user.getEmail()).isEqualTo("conatuseus@gmail.com");
    }

    @Test
    void getPassword() {
        assertThat(user.getPassword()).isEqualTo("conas");
    }

    @Test
    void getName() {
        assertThat(user.getName()).isEqualTo("conatuseus");
    }

    @Test
    void getPhoneNumber() {
        assertThat(user.getPhoneNumber()).isEqualTo("01099996384");
    }

    private void checkUserValidateMessage(String message) {
        Set<ConstraintViolation<UserSaveRequestDto>> constraintViolations = validator.validate(user);
        assertThat(constraintViolations)
            .extracting(ConstraintViolation::getMessage)
            .contains(message);
    }
}
