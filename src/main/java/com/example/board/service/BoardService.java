package com.example.board.service;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.board.domain.BoardEntity;
import com.example.board.domain.BoardRepository;
import com.example.board.dto.BoardDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BoardService {
	private BoardRepository boardRepository;
	
	@Transactional
	public Long savePost(BoardDto boardDto) {
		return boardRepository.save(boardDto.toEntity()).getId();
	}
	@Transactional
	public void deletePost(Long id) {
		boardRepository.deleteById(id);
	}
	@Transactional
	public List<BoardDto> getBoardlist() {
		List<BoardEntity> boardEntities = boardRepository.findAll();
		List<BoardDto> boardDtoList = new ArrayList<>();
		
		for(BoardEntity boardEntity : boardEntities) {
			BoardDto boardDto = BoardDto.builder()
					.id(boardEntity.getId())
					.title(boardEntity.getTitle())
					.content(boardEntity.getContent())
					.writer(boardEntity.getWriter())
					.createdDate(boardEntity.getCreatedDate())
					.build();
			boardDtoList.add(boardDto);
		}
		return boardDtoList;
	}
	@Transactional
	public BoardDto getPost(Long id) {
		Optional<BoardEntity> boardEntityWrapper = boardRepository.findById(id);
		BoardEntity boardEntity = boardEntityWrapper.get();
		
		BoardDto boardDto = BoardDto.builder()
			.id(boardEntity.getId())
			.title(boardEntity.getTitle())
			.content(boardEntity.getContent())
			.writer(boardEntity.getWriter())
			.createdDate(boardEntity.getCreatedDate())
			.build();
		return boardDto;
	}
	
	
}
