package net.sp4rkh.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles({"test"})
public class SpringbootApiApplicationTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("ContextLoad test")
	@Description("Verify if the context is well loaded before starting all the tests.")
	void contextLoads() {
		Assertions.assertNotNull(this.mockMvc);
	}

	@Test
	@DisplayName("Check /apiStatus")
	@Description("Verify if the endpoint \"/apiStatus\" can be reached.")
	void apiStatusReachCheck() {
		try {
			this.mockMvc
					.perform(MockMvcRequestBuilders.get("/apiStatus"))
					.andDo(MockMvcResultHandlers.print())
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("$").exists());
		} catch (final Exception e) {
			Assertions.fail("Error while checking \"/apiStatus\" accessibility", e);
		}
	}
}
