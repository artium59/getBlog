package com.web.blog.controller.reply;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import java.util.List;

import com.web.blog.model.BasicResponse;
import com.web.blog.model.reply.ReplyListResponseDto;
import com.web.blog.model.reply.ReplyResponseDto;
import com.web.blog.model.reply.ReplySaveRequestDto;
import com.web.blog.model.reply.ReplyUpdateRequstDto;
import com.web.blog.service.ReplyService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RequiredArgsConstructor
@RestController
public class ReplyApiController {

    private final ReplyService replyService;

    @PostMapping("/api/reply/insert")
    @ApiOperation(value = "댓글 등록하기")
    public Long save(@RequestBody ReplySaveRequestDto requestDto) {
        return replyService.save(requestDto);
    }

    @PutMapping("api/reply/modify/{rno}")
    @ApiOperation(value = "댓글 수정하기")
    public Long update(@PathVariable Long rno, @RequestBody ReplyUpdateRequstDto requestDto) {
        return replyService.update(rno, requestDto);
    }

    @DeleteMapping("api/reply/{rno}")
    @ApiOperation(value = "댓글 삭제하기")
    public Long delete(@PathVariable Long rno) {
        replyService.delete(rno);
        return rno;
    }

    @GetMapping("api/reply/{rno}")
    @ApiOperation(value = "댓글 가져오기")
    public ReplyResponseDto findByRno(@PathVariable Long rno){
        return replyService.findByRno(rno);
    }   

    @GetMapping("/api/reply/list")
    @ApiOperation(value = "전체 댓글 가져오기")
    public List<ReplyListResponseDto> findAll() {
        return replyService.findAll();
    }

    @GetMapping("api/reply/list/{pno}")
    @ApiOperation(value = "게시글 댓글 가져오기")
    public List<ReplyListResponseDto> findByPno(@PathVariable Long pno){
        return replyService.findByPno(pno);
    }

}
