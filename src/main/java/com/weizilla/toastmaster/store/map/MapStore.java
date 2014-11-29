package com.weizilla.toastmaster.store.map;

import com.weizilla.toastmaster.data.Speaker;
import com.weizilla.toastmaster.data.TableTopic;
import com.weizilla.toastmaster.store.Store;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MapStore implements Store
{
    private Map<Integer, TableTopic> tableTopics = new ConcurrentHashMap<>();
    private AtomicInteger tableTopicCounter = new AtomicInteger(0);

    @Override
    public void createTableTopic(String topic)
    {
        int id = tableTopicCounter.getAndIncrement();
        TableTopic newTopic = new TableTopic(id, topic);
        tableTopics.put(id, newTopic);
    }

    @Override
    public Collection<TableTopic> getTableTopics()
    {
        return tableTopics.values();
    }

    @Override
    public void updateTopic(int id, String topic)
    {
        tableTopics.put(id, new TableTopic(id, topic));
    }

    @Override
    public void deleteTopic(int id)
    {
        tableTopics.remove(id);
    }

    @Override
    public void createSpeaker(String name)
    {

    }

    @Override
    public Collection<Speaker> getSpeakers()
    {
        return null;
    }

    @Override
    public void deleteSpeaker(int id)
    {

    }
}
