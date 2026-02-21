package com.myweb.controller;

import com.myweb.dto.BoardDTO;
import com.myweb.entity.BoardEntity;
import com.myweb.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/boards")
@Controller
public class BoardController {

   private final BoardService service;

    @GetMapping("/save")
    public String saveBoard(){
        return "board/save";
    }

    @PostMapping("/save")
    public String save(BoardDTO boardDTO){
       System.out.println("boardDdTO=" + boardDTO);
       service.save(boardDTO);
       return "redirect:/boards";
    }

    //글 목록
    @GetMapping
    public String getAllList(Model model){
        List<BoardEntity> boardList = service.findAll();
        model.addAttribute("boardList", boardList);
        return "board/list";
    }

    //글 상세보기
    @GetMapping("/{id}")
    public String getBoard(@PathVariable Long id,
            Model model){
        //조회수 증가
        service.updateBoardHits(id);

        //글 상세보기
        BoardEntity board = service.findById(id);
        model.addAttribute("board", board);
        return "board/detail";
    }

    //글 삭제
    @GetMapping("/delete/{id}")
    public String deleteBoard(@PathVariable Long id){
        service.delete(id);
        return "redirect:/boards";
    }

    //글 수정 페이지 요청
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id,
                             Model model){
        BoardEntity board = service.findById(id);
        model.addAttribute("board", board);
        return "board/update";
    }

    //글 수정
    @PostMapping("/update")
    public String update(BoardDTO boardDTO,
                         RedirectAttributes ra){
        try {
            service.update(boardDTO);
            return "redirect:/boards/" + boardDTO.getId(); //상세보기로 이동
        }catch (IllegalArgumentException e){
            ra.addFlashAttribute("errorMsg", e.getMessage());
            return "redirect:/board/update/" + boardDTO.getId();
        }
    }

}
