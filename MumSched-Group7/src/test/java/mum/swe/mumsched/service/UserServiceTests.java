package mum.swe.mumsched.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.mum.mumsched.dao.UserRepository;
import edu.mum.mumsched.enums.RoleEnum;
import edu.mum.mumsched.model.User;
import edu.mum.mumsched.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {


	@MockBean
    private UserRepository userRepository;

	@Autowired
    private UserService userService;
	@Test
	public void testFindAll() {
		List<User> users = new ArrayList<User>();
		
		User user = new User();
		user.setUsername("test_user1@mum.edu");
		user.setFirstName("User1");
		user.setLastName("Test");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setRole(RoleEnum.ROLE_STUDENT);
		
		users.add(user);
		PageRequest pageable = new PageRequest(0, 20);
		
		Page<User> userPage = new PageImpl<>(users, pageable, users.size()); 
		when(userRepository.findAll(pageable)).thenReturn(userPage);
		Page<User> page = userService.findAll(pageable);
		
		assertEquals(1, page.getContent().size());
	}


}
