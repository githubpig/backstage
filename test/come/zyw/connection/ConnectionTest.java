package come.zyw.connection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.druid.pool.DruidDataSource;
import com.zyw.bean.AdminUser;
import com.zyw.dao.adminuser.IAdminUserMapper;
/**
 * 
 * 作用: spring框架： 测试applicationContext.xml中配置的数据库连接
 * ConnectionTest
 * 创建人:piggy
 * 时间:2017年5月6日-下午6:27:38
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class ConnectionTest {
	
	//数据库连接测试
	@Test
	public void testConnection(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		DruidDataSource dataSource = context.getBean(DruidDataSource.class);
		System.out.println(dataSource);
	}
	//dao层 数据查询测试
	@Test
	public void testQueryUser(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		IAdminUserMapper mapper = context.getBean(IAdminUserMapper.class);
		//System.out.println(mapper);
		AdminUser adimUser = mapper.getLogin("357076478@qq.com","4QrcOUm6Wau+VuBX8g+IPg==");
		System.out.println(adimUser.getCreateTime());
	}
	
	@Test
	public void testSaveBatch(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		IAdminUserMapper mapper = context.getBean(IAdminUserMapper.class);
		//System.out.println(mapper);
		List<AdminUser> adminUsers = new ArrayList<AdminUser>();
		AdminUser adminUser1 = new AdminUser();
		
		adminUser1.setUsername("pig1");
		adminUser1.setPassword("12345");
		adminUser1.setEmail("357076478@qq.com");
		adminUsers.add(adminUser1);
		
		AdminUser adminUser2 = new AdminUser();
		adminUser2.setUsername("pig2");
		adminUser2.setPassword("12355");
		adminUser2.setEmail("357076@qq.com");
		adminUsers.add(adminUser2);
		
		int mark = mapper.saveBatch(adminUsers);
		
		System.out.println(mark);
		
	}
	
}
