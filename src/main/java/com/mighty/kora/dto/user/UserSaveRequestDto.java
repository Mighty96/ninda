package com.mighty.kora.dto.user;

import com.mighty.kora.domain.user.RegistrationId;
import com.mighty.kora.domain.user.Role;
import com.mighty.kora.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    private String email;
    private String password;
    private String familyName;
    private String givenName;
    private String birthday;
    private String nickname;
    private String picture;
    private Role role;
    private RegistrationId registrationId;

    @Builder
    public UserSaveRequestDto(String email, String password, String familyName, String givenName, String birthday, String nickname, String picture, RegistrationId registrationId) {
        this.email = email;
        this.password = password;
        this.familyName = familyName;
        this.givenName = givenName;
        this.birthday = birthday;
        this.nickname = nickname;
        this.picture = picture;
        this.role = Role.GUEST;
        this.registrationId = registrationId;
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .familyName(familyName)
                .givenName(givenName)
                .birthday(birthday)
                .nickname(nickname)
                .picture(picture)
                .role(role)
                .registrationId(registrationId)
                .build();

    }
}
