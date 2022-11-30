package com.mute.Final_BE.entity;

import com.mute.Final_BE.constant.AlarmStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table
public class Wish {
    @Id
    @GeneratedValue
    private Long indexNum; // PK
    @ManyToOne
    @JoinColumn(name = "user_num") // 회원 번호(FK)
    private Member member; // Member 객체

    @ManyToOne // Musical 엔티티와 일대일 매핑
    @JoinColumn(name = "musical_id") // 공연 ID(FK)
    private Musical musical;

    private AlarmStatus alarmStatus; // 알림(Enum)
}
