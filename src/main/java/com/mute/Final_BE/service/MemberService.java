package com.mute.Final_BE.service;
import com.mute.Final_BE.entity.Member;
import com.mute.Final_BE.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

// 로그인 - 도연 작업완료
@Service
@Transactional
@Slf4j
public class MemberService {
    private MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public Integer loginCheck(String userId, String pwd) {
        System.out.println("here is loginCheck");
        System.out.println("In Service, id/pwd : "+ userId + pwd);
        List<Member> memberCheckedList = memberRepository.findByUserIdAndPwd(userId, pwd);
        List<Member> memberExistList = memberRepository.findByUserId(userId);

        System.out.println("test33"+memberCheckedList + memberCheckedList.size() + memberExistList.size() );
        if(memberCheckedList.size() != 0 ) {return 200;}
        else if (memberExistList.size() != 0) {return 300;}
        else {return 400;}
    }
}
