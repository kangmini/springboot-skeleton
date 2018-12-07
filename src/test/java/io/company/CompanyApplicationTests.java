package io.company;

import lombok.extern.slf4j.Slf4j;
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

    @Test
    public void contextLoads() {
        log.info(passwordEncoder.encode("1234"));
    }

}
