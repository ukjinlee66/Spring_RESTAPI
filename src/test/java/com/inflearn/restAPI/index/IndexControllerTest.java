package com.inflearn.restAPI.index;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.inflearn.restAPI.common.BaseControllerTest;
import org.junit.jupiter.api.Test;

/**
 * Please explain the class
 *
 * @author : wookjin
 * @fileName : indexControllerTest
 * @since : 12/13/23
 */

public class IndexControllerTest extends BaseControllerTest {

    @Test
    public void index() throws Exception {
        this.mockMvc.perform(get("/api"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("_links.events").exists())
        ;
    }

}
