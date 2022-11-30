package com.mute.Final_BE.dto;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

// 도연 작업완료
@Getter @Setter
public class MemberDTO {
//    private Long userNum; // 회원번호
    private String user; // 회원아이디
    private String pwd; // 비밀번호
    private String name; // 이름
    private String phone; // 전화번호
    private String mail; // 메일
    private String addr; // 주소
    private Date regDate; // 가입일
    private Date unRegDate; // 탈퇴일
}
