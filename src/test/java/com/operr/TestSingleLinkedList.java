package com.operr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * A <code>TestSingleLinkedList</code> implementation that uses the Node class.
 *
 * @author ThangTQ
 * @version 1.0.0 Aug 04, 2017
 */
@RunWith(SpringRunner.class)
@SpringBootApplication

public class TestSingleLinkedList {

    private static final Logger log = LoggerFactory.getLogger(TestSingleLinkedList.class);
    @Test
    public void TestSingleLinkedListWithIntegerElements()
    {
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
        log.info("dumping singleLinkedList: \n"+singleLinkedList.toString());
        assertThat(singleLinkedList.size(), is(9));

        log.info("removeElementsGreaterThanValue:"+singleLinkedList.removeElementsGreaterThanValue(8));
        log.info("dumping singleLinkedList: \n"+singleLinkedList.toString());
        assertThat(singleLinkedList.size(), is(8));

        log.info("removeElementsGreaterThanValue:"+singleLinkedList.removeElementsGreaterThanValue(5));
        log.info("dumping singleLinkedList: \n"+singleLinkedList.toString());
        assertThat(singleLinkedList.size(), is(5));

        int tail=singleLinkedList.removeTail();
        log.info("removed a tail:"+tail);
        assertThat(tail, is(1));

        log.info("removeElementsGreaterThanValue:"+singleLinkedList.removeElementsGreaterThanValue(0));
        log.info("dumping singleLinkedList: \n"+singleLinkedList.toString());
        assertThat(singleLinkedList.size(), is(0));
    }
}
