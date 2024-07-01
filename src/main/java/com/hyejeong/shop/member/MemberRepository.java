package com.hyejeong.shop.member;

import com.hyejeong.shop.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {


}
