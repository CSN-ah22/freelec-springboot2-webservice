package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 스프링부트 자동 설정, 스프링 bean 읽기와 생성 모두 자동으로 설정
// @SpringBootApplication 위치부터 설정을 읽어가기 때문에 항상 최상단에 위치해둔다

@SpringBootApplication
public class Application { //project의 메인 클래스
    public static void main(String[] args) {
        //내장 WAS 실행
        SpringApplication.run(Application.class, args);
    }
}
