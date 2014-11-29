package com.weizilla.toastmaster.stub;

import org.springframework.ui.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ModelStub implements Model
{
    private Map<String, Object> map = new HashMap<>();

    @Override
    public Model addAttribute(String s, Object o)
    {
        map.put(s, o);
        return this;
    }

    @Override
    public Model addAttribute(Object o)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Model addAllAttributes(Collection<?> collection)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Model addAllAttributes(Map<String, ?> map)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Model mergeAttributes(Map<String, ?> map)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAttribute(String s)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<String, Object> asMap()
    {
        return map;
    }
}
