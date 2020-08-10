package com.web.blog.service;

import java.util.List;
import java.util.stream.Collectors;

import com.web.blog.dao.posts.PostsRepository;
import com.web.blog.model.posts.Posts;
import com.web.blog.model.posts.PostsListResponseDto;
import com.web.blog.model.posts.PostsResponseDto;
import com.web.blog.model.posts.PostsSaveRequestDto;
import com.web.blog.model.posts.PostsUpdateRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService{
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getPno();
    }

    @Transactional
    public Long update(Long pno, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findByPno(pno)
                .orElseThrow(() -> new IllegalArgumentException("해당 글이 없습니다. pno=" + pno));

        posts.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getCreateDate());

        return pno;
    }

    @Transactional
    public void delete (Long pno) {
        Posts posts = postsRepository.findByPno(pno)
                .orElseThrow(() -> new IllegalArgumentException("해당 글이 없습니다. pno=" + pno));

        postsRepository.delete(posts);
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findByPno(Long pno) {
        Posts entity = postsRepository.findByPno(pno)
                .orElseThrow(() -> new IllegalArgumentException("해당 글이 없습니다. pno=" + pno));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
	public String getUserNickname(Long pno) {
		return postsRepository.getUserNickname(pno);
    }
    
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findByTitleContaining(String title) {
        return postsRepository.findByTitleContaining(title).stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

}