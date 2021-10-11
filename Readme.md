#####  롬복 테스트 실패 해결
###### 문제 원인 파악
+ 프로젝트 디렉터리의 gradle - wrapper - 마지막줄에 gradle의 버전이 나옵니다
+ 4.10.2 보다 높을시 롬복이 정상작동 하지 않습니다
###### 해결 방법
+ alt+F12 키를 누를시 해당 프로젝트 기준으로 터미널이 열립니다
+ --gradle-version 4.10.2
+ enter를 눌러 다운그레이드 합니다

#### TEST 클래스 자동 생성 단축키
+ 테스트 대상인 클래스명에 커서를 갖다 둔다
+ Ctrl+Shift+T

#### IntelliJ 토큰을 사용해 깃에 올리기

+ 원래 비밀번호 인증을 통해 깃에 업로드 했지만 이제 지원이 제거되었다고한다
+ 대신 개인 액세스 토큰을 사용하라 나온다

1. github login
2. Main page - setting - Click!
3. Developer settings - Click!
4. Personal access tokens - Click!
5. Generate new token - Click!
6. Note ex) My token
7. Expiration = 토큰사용기한
8. Scope - repo - Selecte!
9. Generate token - Copy - Click!
10. Back to IntelliJ - put in the password space

#### Spring에서 view 표현의 흐름은 어떻게 될까?
+ 참고 사이트
https://all-record.tistory.com/165

#### [코드 리뷰 ]

```
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
```