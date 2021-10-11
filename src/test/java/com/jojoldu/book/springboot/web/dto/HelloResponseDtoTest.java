package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void  lombok_test(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        String g_name = dto.getName();
        int g_amount = dto.getAmount();

        assertThat(g_name).isEqualTo(name); //1.인자로 들어오는 값을 검증함 2.g_name과 name 이 같을때만 성공
        assertThat(g_amount).isEqualTo(g_amount);
    }

}