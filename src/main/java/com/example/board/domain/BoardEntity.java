package com.example.board.domain;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "board")
public class BoardEntity extends TimeEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

//    @Column(length = 10, nullable = false)
    @Column
    private String writer;

//    @Column(length = 100, nullable = false)
    @Column
    private String title;
//    @Column(columnDefinition = "TEXT", nullable = false)
    @Column
    private String content;
	
	@Builder
	public BoardEntity(Long id, String writer, String title, String content) {
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
}
