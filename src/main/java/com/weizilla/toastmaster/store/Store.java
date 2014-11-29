package com.weizilla.toastmaster.store;

import com.weizilla.toastmaster.data.Speaker;
import com.weizilla.toastmaster.data.TableTopic;

import java.util.Collection;

public interface Store
{
    void createTableTopic(String topic);
    Collection<TableTopic> getTableTopics();
    void deleteTopic(int id);

    void createSpeaker(String name);
    Collection<Speaker> getSpeakers();
    void deleteSpeaker(int id);
}
