package com.example.developer.repository;

import com.example.developer.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
//data.sql 실행되지 않도록함
@TestPropertySource(properties = {
        "spring.sql.init.mode=never"
})
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Sql("/insert-members.sql")
    @Test
    void getAllMembers(){
         List<Member> memberList = memberRepository.findAll();

         //than
         assertThat(memberList.size()).isEqualTo(3);
    }

    /*@Sql("/insert-members.sql")
    @Test
    void getMemberById(){
        Member member = memberRepository.findById(2L).get();

        //than
        assertThat(member.getName()).isEqualTo("B");
    }*/

    @Test
    void getMemberById() {
        Member saved = memberRepository.save(new Member(null, "B"));

        Member member = memberRepository.findById(saved.getId()).get();

        assertThat(member.getName()).isEqualTo("B");
    }

    @Test
    void getMemberByName(){
        Member saved = memberRepository.save(new Member(null, "C"));

        Member member = memberRepository.findByName(saved.getName()).get();

        assertThat(member.getId()).isEqualTo(saved.getId());
    }
}