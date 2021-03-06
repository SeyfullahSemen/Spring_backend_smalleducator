package com.hva.smalleducator.backend.smalleducator.integrationTests;

import com.hva.smalleducator.backend.smalleducator.Feature.lesson.Lesson;
import com.hva.smalleducator.backend.smalleducator.Feature.lesson.LessonController;
import com.hva.smalleducator.backend.smalleducator.Feature.lesson.LessonImpl;
import com.hva.smalleducator.backend.smalleducator.Feature.lesson.LessonRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LessonIntegrationTest extends BaseIntegrationTest {
    @Mock
    private LessonRepository lessonRepository;

    @InjectMocks
    private LessonImpl lessonImpl;

    @Autowired
    private MockMvc mockMvc;

    @Override
    protected Object getControllerUnderTest() {
        return new LessonController(lessonImpl);
    }

    /**
     * @throws Exception
     */
    @Test
    public void addLesson_succes() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setId(1L);
        lesson.setTitle("Week 1");

        Mockito.when(lessonRepository.save(Mockito.any())).thenReturn(lesson);
        this.mockMvc.perform(MockMvcRequestBuilders.
                post("/lesson")
                .content(objectToJsonString(lesson))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated())
                .andDo(mvcResult -> {
                    String jsonResponse = mvcResult.getResponse().getContentAsString();
                    JSONAssert.assertEquals(objectToJsonString(lesson), jsonResponse, false);
                });
    }
}
