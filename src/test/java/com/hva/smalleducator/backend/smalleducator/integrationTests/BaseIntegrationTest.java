package com.hva.smalleducator.backend.smalleducator.integrationTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public abstract class BaseIntegrationTest {
    protected MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    protected LocalValidatorFactoryBean localValidatorFactoryBean;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(getControllerUnderTest())
                .setControllerAdvice()
                .setValidator(localValidatorFactoryBean)
                .build();
    }

    @After
    public void after() {

    }

    public String objectToJsonString(final Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);

    }


    protected abstract Object getControllerUnderTest();
}
