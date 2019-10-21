package com.conatuseus.webservice.user.domain;

import com.conatuseus.webservice.user.service.dto.UserUpdateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    public User(final String email, final String password, final String name, final String phoneNumber) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public User update(final UserUpdateRequest userUpdateRequest) {
        this.password = userUpdateRequest.getPassword();
        this.phoneNumber = userUpdateRequest.getPhoneNumber();
        return this;
    }
}
