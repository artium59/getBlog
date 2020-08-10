package com.web.blog.service;

import java.util.List;
import java.util.stream.Collectors;

import com.web.blog.dao.reply.ReplyRepository;
import com.web.blog.model.reply.Reply;
import com.web.blog.model.reply.ReplyListResponseDto;
import com.web.blog.model.reply.ReplyResponseDto;
import com.web.blog.model.reply.ReplySaveRequestDto;
import com.web.blog.model.reply.ReplyUpdateRequstDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

    @Transactional
    public Long save(ReplySaveRequestDto requestDto){
        return replyRepository.save(requestDto.toEntity()).getRno();
    }

    @Transactional
    public Long update(Long rno, ReplyUpdateRequstDto requestDto) {
        Reply reply = replyRepository.findByRno(rno)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. rno=" + rno));

        reply.update(requestDto.getReplytext(), requestDto.getReplyer(), requestDto.getCreateDate());

        return rno;
    }

    @Transactional
    public void delete (Long rno) {
        Reply reply = replyRepository.findByRno(rno)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. rno=" + rno));

        replyRepository.delete(reply);
    }

    @Transactional(readOnly = true)
    public ReplyResponseDto findByRno(Long rno) {
        Reply entity = replyRepository.findByRno(rno)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. rno=" + rno));
        
        return new ReplyResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ReplyListResponseDto> findAll() {
        return replyRepository.findAll().stream()
                .map(ReplyListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
	public List<ReplyListResponseDto> findByPno(Long pno) {
		return replyRepository.findByPno(pno).stream()
                .map(ReplyListResponseDto::new)
                .collect(Collectors.toList());
	}
}
