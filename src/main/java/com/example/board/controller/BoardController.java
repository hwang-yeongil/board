package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {
	private BoardService boardService;
	
	@GetMapping("/test")
	public String test() {
		return "Hello World";
	}
	
	@GetMapping("/")
	public String list() {
		return "board/list";
	}
	
	@GetMapping("/post")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/post")
	public String write(BoardDto boardDto) {
		boardService.savePost(boardDto);
		return "redirect:/";
	}
}
