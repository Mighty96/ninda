package com.mighty.ninda.dto.comment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaveComment {


    @NotBlank(message = "내용을 입력해주세요.")
    @Size(max = 200, message="200자 이하로 작성해주세요.")
    private String context;

    @NotNull
    private Long postId;

    @NotNull
    private Long commentId;

    public SaveComment(String context, Long postId, Long commentId) {
        this.context = context;
        this.postId = postId;
        this.commentId = commentId;
    }
}
