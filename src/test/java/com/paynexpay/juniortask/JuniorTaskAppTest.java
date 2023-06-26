package com.paynexpay.juniortask;

import com.paynexpay.juniortask.web.JuniorTaskAppController;
import org.junit.Ignore;
import org.junit.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = JuniorTaskAppTest.class)
public class JuniorTaskAppTest {

    @Autowired
    private JuniorTaskAppController controller;


    @Ignore
    @Test
    @DisplayName("context loads")
    public void contextLoaded() {
        Assertions.assertThat(controller).isNotNull();
    }
}
