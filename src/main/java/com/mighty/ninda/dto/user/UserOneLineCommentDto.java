package com.mighty.ninda.dto.user;

import com.mighty.ninda.domain.comment.OneLineComment;
import com.mighty.ninda.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class UserOneLineCommentDto {

    private Long gameId;
    private String gameTitle;
    private Long commentId;
    private String context;
    private String createdDate;

    @Builder
    public UserOneLineCommentDto(Long gameId, String gameTitle, Long commentId, String context, LocalDateTime createdDate) {
        this.gameId = gameId;
        this.gameTitle = gameTitle;
        this.commentId = commentId;
        this.context = context;
        this.createdDate = createdDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));


    }

    public List<UserOneLineCommentDto> toList(List<OneLineComment> oneLineComments) {
        List<UserOneLineCommentDto> list = new ArrayList<>();

        for (OneLineComment oneLineComment : oneLineComments) {
            list.add(UserOneLineCommentDto.builder()
                    .gameId(oneLineComment.getGame().getId())
                    .gameTitle(oneLineComment.getGame().getTitle())
                    .commentId(oneLineComment.getId())
                    .context(oneLineComment.getContext())
                    .createdDate(oneLineComment.getCreatedDate())
                    .build());
        }

        return list;
    }
}
