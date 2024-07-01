package com.hyejeong.shop.member;

import com.hyejeong.shop.member.Member;
import com.hyejeong.shop.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository ms;

    public void saveMember(Member member) {
        ms.save(member);

    }
}
