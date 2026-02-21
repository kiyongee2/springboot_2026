package com.myweb.service;

import com.myweb.dto.BoardDTO;
import com.myweb.entity.BoardEntity;
import com.myweb.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    public void save(BoardDTO boardDTO){
       BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        repository.save(boardEntity);
    }

    public List<BoardEntity> findAll() {
        return repository.findAll();
    }

    public BoardEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("존재하지 않는 게시글입니다."));
    }

    @Transactional
    public void updateBoardHits(Long id) {
        repository.updateHits(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void update(BoardDTO boardDTO) {
        //수정할 게시글 가져오기
       BoardEntity board = repository.findById(boardDTO.getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("존재하지 않는 게시글입니다."));

        //글 수정
        board.setBoardTitle(boardDTO.getBoardTitle());
        board.setBoardContents(boardDTO.getBoardContents());
        repository.save(board);
    }
}
