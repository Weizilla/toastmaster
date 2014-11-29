package com.weizilla.toastmaster.data;

public class TableTopic
{
    private final int id;
    private final String topic;

    public TableTopic(int id, String topic)
    {
        this.id = id;
        this.topic = topic;
    }

    public int getId()
    {
        return id;
    }

    public String getTopic()
    {
        return topic;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        TableTopic that = (TableTopic) o;

        if (id != that.id)
        {
            return false;
        }
        if (topic != null ? !topic.equals(that.topic) : that.topic != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "TableTopic{" +
            "id=" + id +
            ", topic='" + topic + '\'' +
            '}';
    }
}
