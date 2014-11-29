package com.weizilla.toastmaster.store.map;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.weizilla.toastmaster.data.TableTopic;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MapStoreTest
{
    private MapStore store;

    @Before
    public void setUp() throws Exception
    {
        store = new MapStore();
    }

    @Test
    public void emptyTableTopicsToBeginWith() throws Exception
    {
        assertTrue(store.getTableTopics().isEmpty());
    }

    @Test
    public void createdTableTopicAppearsInGetTableTopic() throws Exception
    {
        String testTopic = "TEST TOPIC";
        store.createTableTopic(testTopic);

        Collection<TableTopic> actual = store.getTableTopics();
        assertEquals(testTopic, Iterables.getOnlyElement(actual).getTopic());
    }

    @Test
    public void deletesFromTableTopics() throws Exception
    {
        TableTopic topic1 = new TableTopic(0, "TEST TOPIC 1");
        TableTopic topic2 = new TableTopic(1, "TEST TOPIC 2");
        TableTopic topic3 = new TableTopic(2, "TEST TOPIC 3");

        store.createTableTopic(topic1.getTopic());
        store.createTableTopic(topic2.getTopic());
        store.createTableTopic(topic3.getTopic());

        Collection<TableTopic> expected = Lists.newArrayList(topic1, topic3);

        store.deleteTopic(topic2.getId());
        Collection<TableTopic> actual = store.getTableTopics();

        for (TableTopic e: expected)
        {
            assertTrue(actual.contains(e));
        }
    }

}