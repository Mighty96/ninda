package com.mighty.ninda.service;

import com.mighty.ninda.domain.post.Board;
import com.mighty.ninda.domain.post.Post;
import com.mighty.ninda.domain.post.PostRepository;
import com.mighty.ninda.domain.post.PostSpecs;
import com.mighty.ninda.domain.user.User;
import com.mighty.ninda.dto.post.SavePost;
import com.mighty.ninda.dto.post.UpdatePost;
import com.mighty.ninda.exception.onelinecomment.OneLineCommentAlreadyHateException;
import com.mighty.ninda.exception.onelinecomment.OneLineCommentAlreadyLikeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(SavePost requestDto, User user) {
        return postRepository.save(requestDto.toEntity(user)).getId();
    }

    @Transactional
    public Long update(Long id, UpdatePost requestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        post.update(requestDto.getTitle(), requestDto.getContext());

        return id;
    }

    @Transactional
    public Long delete(Long id) {
        postRepository.deleteById(id);

        return id;
    }

    @Transactional
    public Post findById (Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return post;
    }

    @Transactional
    public List<Post> findTop10ByBoardOrderByCreatedDateDesc(String board) {
        return postRepository.findTop10ByBoardOrderByCreatedDateDesc(board);
    }

    @Transactional
    public Page<Post> findAll(Map<String, Object> searchKeyword, Pageable pageable) {
        return postRepository.findAll(PostSpecs.searchPost(searchKeyword), pageable);
    }

    @Transactional
    public List<Post> findTop5DailyPost(String board) {
        return postRepository.findTop5ByBoardAndCreatedDateAfterOrderByReLikeDesc(board, LocalDateTime.now().minusDays(1));
    }

    @Transactional
    public List<Post> findTop5WeeklyPost(String board) {
        return postRepository.findTop5ByBoardAndCreatedDateAfterOrderByReLikeDesc(board, LocalDateTime.now().minusWeeks(1));
    }

    @Transactional
    public List<Post> findTop5MonthlyPost(String board) {
        return postRepository.findTop5ByBoardAndCreatedDateAfterOrderByReLikeDesc(board, LocalDateTime.now().minusMonths(1));
    }

    @Transactional
    public void viewCountUp(Long id) {
        Post post = findById(id);
        log.info(Integer.toString(post.getViewCount()));
        post.viewCountUp();
    }

    @Transactional
    public Long reLikeUp(Long userId, Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게임이 없습니다. id = " + postId));

        String _userId = "[" + userId.toString() + "]";

        if (post.getLikeList().contains(_userId)) {
            throw new OneLineCommentAlreadyLikeException("이미 추천했습니다.");
        } else {
            post.reLikeUp();
            post.updateLikeList(_userId);
        }

        return post.getId();
    }

    @Transactional
    public Long reHateUp(Long userId, Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게임이 없습니다. id = " + postId));

        String _userId = "[" + userId.toString() + "]";

        if (post.getHateList().contains(_userId)) {
            throw new OneLineCommentAlreadyHateException("이미 비추천했습니다.");
        } else {
            post.reHateUp();
            post.updateHateList(_userId);
        }


        return post.getId();
    }
}
