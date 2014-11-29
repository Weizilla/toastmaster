package com.weizilla.toastmaster.web;

import com.google.common.collect.Lists;
import com.weizilla.toastmaster.controller.ToastmasterController;
import com.weizilla.toastmaster.data.TableTopic;
import com.weizilla.toastmaster.store.Store;
import com.weizilla.toastmaster.stub.ModelStub;
import com.weizilla.toastmaster.stub.StoreStub;
import com.weizilla.toastmaster.web.ToastmasterWebControllerTest.ToastmasterWebControllerTestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ToastmasterWebControllerTestConfig.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ToastmasterWebControllerTest
{
    private static final List<TableTopic> EXPECTED = Lists.newArrayList(
        new TableTopic(1, "TEST TOPIC 1"), new TableTopic(2, "TEST TOPIC 2"));

    @Autowired
    private ToastmasterWebController webController;

    @Autowired
    private ToastmasterController controller;

    private Model model;

    @Before
    public void setUp() throws Exception
    {
        model = new ModelStub();
    }

    @Test
    public void populatesModelWithTableTopics() throws Exception
    {
        webController.tableTopics(model);

        assertEquals(EXPECTED, model.asMap().get("topics"));
    }

    @Test
    public void createsTableTopicAndReturnsModel() throws Exception
    {
        String topic = "TEST TOPIC";
        webController.createTableTopic(model, topic);

        verify(controller).createTableTopic(topic);
        assertEquals(EXPECTED, model.asMap().get("topics"));
    }

    @Test
    public void deletesTopicAndReturnsModel() throws Exception
    {
        int id = 1;
        webController.deleteTableTopic(model, id);

        verify(controller).deleteTopic(id);
        assertEquals(EXPECTED, model.asMap().get("topics"));
    }

    @Configuration
    static class ToastmasterWebControllerTestConfig
    {
        @Bean
        public ToastmasterWebController webController()
        {
            return new ToastmasterWebController();
        }

        @Bean
        public ToastmasterController controller()
        {
            ToastmasterController mock = mock(ToastmasterController.class);
            when(mock.getTableTopics()).thenReturn(EXPECTED);
            return mock;
        }

        @Bean
        public Store store()
        {
            return storeStub();
        }

        @Bean
        public StoreStub storeStub()
        {
            StoreStub storeStub = new StoreStub();
            storeStub.setTableTopics(EXPECTED);
            return storeStub;
        }
    }
}