package com.mighty.ninda.dto.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserNickname {

    @Size(min = 2, max = 12)
    private String nickname;

    @Builder
    public UserNickname(String nickname) {
        this.nickname = nickname;
    }
}
