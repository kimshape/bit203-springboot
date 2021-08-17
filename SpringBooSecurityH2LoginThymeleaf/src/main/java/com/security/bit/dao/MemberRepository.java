package com.security.bit.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.security.bit.model.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMemberId(String memberId);

}