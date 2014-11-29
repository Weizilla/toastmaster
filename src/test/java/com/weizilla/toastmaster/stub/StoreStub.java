package com.weizilla.toastmaster.stub;

import com.weizilla.toastmaster.data.Speaker;
import com.weizilla.toastmaster.data.TableTopic;
import com.weizilla.toastmaster.store.Store;

import java.util.Collection;

public class StoreStub implements Store
{
    private Collection<TableTopic> tableTopics;
    private String createdTestTopic;
    private int updateTopicId;
    private String updateTopicString;
    private int deleteTopicId;
    private Collection<Speaker> speakers;
    private String createdSpeaker;
    private int deletedSpeakerId;

    @Override
    public void createTableTopic(String topic)
    {
        this.createdTestTopic = topic;
    }

    public String getCreatedTestTopic()
    {
        return createdTestTopic;
    }

    @Override
    public Collection<TableTopic> getTableTopics()
    {
        return tableTopics;
    }

    public void setTableTopics(Collection<TableTopic> tableTopics)
    {
        this.tableTopics = tableTopics;
    }

    @Override
    public void updateTopic(int id, String topic)
    {
        updateTopicId = id;
        updateTopicString = topic;
    }

    public int getUpdateTopicId()
    {
        return updateTopicId;
    }

    public String getUpdateTopicString()
    {
        return updateTopicString;
    }

    @Override
    public void deleteTopic(int id)
    {
        this.deleteTopicId = id;
    }

    public int getDeleteTopicId()
    {
        return deleteTopicId;
    }

    @Override
    public void createSpeaker(String name)
    {
        this.createdSpeaker = name;
    }

    public String getCreatedSpeaker()
    {
        return createdSpeaker;
    }

    @Override
    public Collection<Speaker> getSpeakers()
    {
        return speakers;
    }

    public void setSpeakers(Collection<Speaker> speakers)
    {
        this.speakers = speakers;
    }

    @Override
    public void deleteSpeaker(int id)
    {
        this.deletedSpeakerId = id;
    }

    public int getDeletedSpeakerId()
    {
        return deletedSpeakerId;
    }
}
