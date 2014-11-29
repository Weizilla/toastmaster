package com.weizilla.toastmaster.controller;

import com.google.common.collect.Lists;
import com.weizilla.toastmaster.data.Club;
import com.weizilla.toastmaster.data.Speaker;
import com.weizilla.toastmaster.data.TableTopic;
import com.weizilla.toastmaster.stub.StoreStub;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertSame;

public class ToastmasterControllerTest
{
    private StoreStub storeStub;
    private ToastmasterController controller;

    @Before
    public void setUp() throws Exception
    {
        storeStub = new StoreStub();
        controller = new ToastmasterController(storeStub);
    }

    @Test
    public void callsStoreWithNewTopic() throws Exception
    {
        String testTopic = "TEST TOPIC";
        controller.createTableTopic(testTopic);
        assertSame(testTopic, storeStub.getCreatedTestTopic());
    }

    @Test
    public void returnsTableTopicsFromStore() throws Exception
    {
        List<TableTopic> expected = Lists.newArrayList(
            new TableTopic(1, "TEST TOPIC 1"), new TableTopic(2, "TEST TOPIC 2"));
        storeStub.setTableTopics(expected);
        Collection<TableTopic> actual = controller.getTableTopics();
        assertSame(expected, actual);
    }

    @Test
    public void callsStoreToDeleteTableTopic() throws Exception
    {
        int testTopicId = 100;
        controller.deleteTopic(testTopicId);
        int actual = storeStub.getDeleteTopicId();
        assertSame(testTopicId, actual);
    }

    @Test
    public void callsStoreToUpdateTopic() throws Exception
    {
        int testTopicId = 100;
        String testTopic = "TEST TOPIC";
        controller.updateTopic(testTopicId, testTopic);
        assertSame(testTopicId, storeStub.getUpdateTopicId());
        assertSame(testTopic, storeStub.getUpdateTopicString());
    }

    @Test
    public void callsStoreWithNewSpeaker() throws Exception
    {
        String testSpeaker = "TEST SPEAKER";
        controller.createSpeaker(testSpeaker);
        assertSame(testSpeaker, storeStub.getCreatedSpeaker());
    }

    @Test
    public void returnsSpeakersFromStore() throws Exception
    {
        List<Speaker> expected = Lists.newArrayList(
            new Speaker(new Club(1, "CLUB"), 2, "SPEAKER"));

        storeStub.setSpeakers(expected);
        Collection<Speaker> actual = controller.getSpeakers();
        assertSame(expected, actual);
    }

    @Test
    public void callsStoreToDeleteSpeaker() throws Exception
    {
        int testSpeakerId = 100;
        controller.deleteSpeaker(testSpeakerId);
        int actual = storeStub.getDeletedSpeakerId();
        assertSame(testSpeakerId, actual);
    }
}