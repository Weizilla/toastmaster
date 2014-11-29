package com.weizilla.toastmaster.controller;

import com.weizilla.toastmaster.data.Speaker;
import com.weizilla.toastmaster.data.TableTopic;
import com.weizilla.toastmaster.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ToastmasterController
{
    @Autowired
    private Store store;

    public ToastmasterController()
    {
        // for spring
    }

    public ToastmasterController(Store store)
    {
        this.store = store;
    }

    public void createTableTopic(String topic)
    {
        store.createTableTopic(topic);
    }

    public Collection<TableTopic> getTableTopics()
    {
        return store.getTableTopics();
    }

    public void deleteTopic(int id)
    {
        store.deleteTopic(id);
    }

    public void createSpeaker(String name)
    {
        store.createSpeaker(name);
    }

    public Collection<Speaker> getSpeakers()
    {
        return store.getSpeakers();
    }

    public void deleteSpeaker(int id)
    {
        store.deleteSpeaker(id);
    }
}
