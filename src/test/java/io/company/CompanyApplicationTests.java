package io.company;

import io.company.app.model.Member;
import io.company.app.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyApplicationTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MemberRepository memberRepository;


    @Test
    public void contextLoads() {
        for(int i = 0; i < 120; i++) {
            Member member = new Member();
            member.email = "email@email.com" + String.valueOf(i);//("email@email.com" + String.valueOf(i));
            member.name = "뼈다구님" + String.valueOf(i);
            memberRepository.save(member);
        }
    }

}
