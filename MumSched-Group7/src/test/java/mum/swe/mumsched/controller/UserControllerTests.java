package mum.swe.mumsched.controller;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import edu.mum.mumsched.dao.UserRepository;
import edu.mum.mumsched.enums.RoleEnum;
import edu.mum.mumsched.model.User;
import edu.mum.mumsched.service.UserService;



@RunWith(SpringRunner.class)
@SpringBootTest

public class UserControllerTests {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@MockBean
	private UserService userService;
	@MockBean
	private UserRepository userRepository;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity()) 
				.build();
		
	}
	
	@Test
	public void testView() throws Exception {

		User user = new User();
		user.setUsername("test_user1@mum.edu");
		user.setFirstName("User1");
		user.setLastName("Test");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setRole(RoleEnum.ROLE_STUDENT);
		
		
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(RoleEnum.ROLE_ADMIN.toString()));
	Mockito.when(userService.findOne(Matchers.anyLong())).thenReturn(user);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
					.get("/user/1")
					.with(SecurityMockMvcRequestPostProcessors.user("admin@mum.edu").password("1").roles("ADMIN"));

		mockMvc.perform(requestBuilder)
				
				.andExpect(status().isOk())
				.andExpect(model().attribute("user", user))
				.andExpect( view().name("user/edit"));
	}



}
