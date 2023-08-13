package com.bookvoyage.Member;


import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    MemberEntity findByNickname(String nickname);
}
