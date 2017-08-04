package com.operr;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.System.exit;

/**
 * A <code>OperrApplication</code> that uses the SingleLinkedList class.
 *
 * @author ThangTQ
 * @version 1.0.0 Aug 04, 2017
 */

@SpringBootApplication
public class OperrApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(OperrApplication.class);


    public static void main(String[] args) throws Exception {
        log.info("running Application");
        SpringApplication.run(OperrApplication.class, args);
    }

    @Transactional(readOnly = true)
    @Override
    public void run(String... args) throws Exception {

        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addToHead(1);
        singleLinkedList.addToHead(2);
        singleLinkedList.addToHead(3);
        singleLinkedList.addToHead(4);
        singleLinkedList.addToHead(5);
        singleLinkedList.addToHead(6);
        singleLinkedList.addToHead(7);
        singleLinkedList.addToHead(8);
        singleLinkedList.addToHead(9);
        log.info("dumping singleLinkedList: \n" + singleLinkedList.toString());
        exit(0);
    }

}