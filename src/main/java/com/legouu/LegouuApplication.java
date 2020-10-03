package com.legouu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 这个类必须放在最外层，因为在访问的时候默认访问同级目录
 */
@SpringBootApplication
public class LegouuApplication {

    public static void main(String[] args) {
        SpringApplication.run(LegouuApplication.class, args);
    }

}
