package co.com.ath.fidelizacion.redencion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedencionApiApplicationTests {

    final private static Logger log = LoggerFactory.getLogger(RedencionApiApplicationTests.class);

    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void testEmployees() throws Exception {
        log.debug("[TEST] employees()");
        ResultActions resultActions = this.mvc.perform(post("/api/v1/restautnfilter").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        resultActions.andDo(print());
    }
}
