package com.hva.smalleducator.backend.smalleducator.integrationTests;

import com.hva.smalleducator.backend.smalleducator.Feature.course.Course;
import com.hva.smalleducator.backend.smalleducator.Feature.course.CourseController;
import com.hva.smalleducator.backend.smalleducator.Feature.course.CourseImpl;
import com.hva.smalleducator.backend.smalleducator.Feature.course.CourseRepository;
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
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseImpl lessonImpl;

    @Autowired
    private MockMvc mockMvc;

    /**
     * @return object
     */
    @Override
    protected Object getControllerUnderTest() {
        return new CourseController(lessonImpl);
    }

    /**
     * This is an integration test which will test whether the
     * teacher can save a new lesson into the database.
     *
     * @throws Exception
     */
    @Test
    public void lessonAdded_success() throws Exception {
        Course course = new Course();
        course.setId(1L);
        course.setLessonname("Architecture and design");

        Mockito.when(courseRepository.save(Mockito.any())).thenReturn(course);
        this.mockMvc.perform(MockMvcRequestBuilders.
                post("/course")
                .content(objectToJsonString(course))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated())
                .andDo(mvcResult -> {
                    String jsonResponse = mvcResult.getResponse().getContentAsString();
                    JSONAssert.assertEquals(objectToJsonString(course), jsonResponse, false);
                });

    }
}
