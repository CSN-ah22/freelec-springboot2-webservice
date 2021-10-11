package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
.
.
lombok의 기능
필드를 대상으로 get 메서드를 자동 생성한다
final 필드를 대상으로 생성자가 자동 생성된다
.
.
*/
@Getter
@RequiredArgsConstructor

public class HelloResponseDto {

    private final String name;
    private final int amount;
}
