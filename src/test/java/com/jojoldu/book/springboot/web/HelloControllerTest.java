package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/* Hello 테스트 클래스 */

@RunWith(SpringRunner.class) // SpringRunner라는 스프링 실행자 사용, 스프링 부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class) //@Controller,@ControllerAdvice 등을 사용할 수 있게 해줌
public class HelloControllerTest {

    @Autowired // spring이 관리하는 빈을 주입받는다
    private MockMvc mvc; //HTTP GET, POST등에 대한 API 테스트를  할 수있다

    @Test
    public void hellodto_return() throws Exception{
        String name = "hello";
        int amount = 1000;

        /*
        .
        .
        ①
        helloCotroller에 매핑 테스트할때 사용될 파라미터를 설정한다
        단, String만 허용되기 때문에 숫자/날짜 데이터 등록시 문자열로 변경해야한다
        ②
        JSON 응답값을 필드별로 검증한다
        $를 기준으로 필드명을 명시한다
        .
        .
        */
        mvc.perform(
                    get("/hello/dto")
                            .param("name", name)
                            .param("amount", String.valueOf(amount)))
                                                        .andExpect(status().isOk())
                                                        .andExpect(jsonPath("$.name",is(name)))
                                                        .andExpect(jsonPath("$.amount",is(amount)));


    }

    @Test
    public void hello_return() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello")) // HTTP GET 요청
                .andExpect(status().isOk()) //mvc.andExpect(status().isOk()) 와 같은 구문, 200,404,500과 같은 상태 검증
                .andExpect(content().string(hello)); //응답이 들어왔을때 응답본문의 내용이 hello가 맞는지 검증한다
    }

}