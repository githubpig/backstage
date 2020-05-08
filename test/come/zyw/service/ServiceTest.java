package come.zyw.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zyw.bean.AdminUser;
import com.zyw.bean.Content;
import com.zyw.bean.Permission;
import com.zyw.bean.Project;
import com.zyw.bean.Role;
import com.zyw.bean.RolePermission;
import com.zyw.bean.ZywParams;
import com.zyw.service.adminstat.IContentStatService;
import com.zyw.service.adminuser.IAdimUserService;
import com.zyw.service.content.IContentService;
import com.zyw.service.permission.IPermissionService;
import com.zyw.service.project.IProjectService;
import com.zyw.service.role.IRoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class ServiceTest {
	
	@Autowired
	private IAdimUserService adminUserService;
	@Autowired
	private IContentService contentService;
	@Autowired
	private IContentStatService contentStatService;
	@Autowired
	private IPermissionService  permissionService;
	@Autowired
	private IRoleService  roleService;
	
	@Autowired
	private IProjectService  projectService;
	
	@Test
	public void testQueryCon(){
		Project project = new Project();
		project.setProject_type(0);
		project.setName("体验");
		List<Project> lists = projectService.queryCondition(project);
		for(Project p:lists){
			System.out.println(p.toString());
		}
		
	}
	@Test
	public void testQueryId(){
		Project project = projectService.queryId(1);
		System.out.println(project.toString());
	}
	
	@Test
	public void testdelProject(){
		int flag = projectService.del(39);
		System.out.println(flag);
	}
	
	@Test
	public void testdeleteProject(){
		int [] arr = new int[]{34,33};
		int flag = projectService.delete(arr);
		System.out.println(flag);
	}
	
	@Test
	public void testAddProject(){
		Project project = new Project();
		project.setName("信条11");
		project.setRate(0.00671);
		project.setDuration(30);
		project.setStart_money(50000);
		project.setProjectrate(0.0234);
		project.setProject_type(1);
		project.setStatus(0);
		int flag = projectService.save(project);
		System.out.println(flag);
	}
	
	@Test
	public void testQueryProject(){
		List<Project> ps =projectService.queryProjects();
		for(Project p : ps){
			System.out.println(p.toString());
		}
	}
	
	@Test
	public void testCountPermission(){
		ZywParams params = new ZywParams();
		params.setIsDelete(0);
		int count = permissionService.countPermission(params);
		System.out.println(count);
	}
	
	@Test
	public void testQueryUserRole(){
		HashMap<String, Object> maps =  roleService.queryUserRole(1);
		System.out.println(maps);
	}
	
	@Test
	public void testRoleImpower(){
		List<RolePermission> rolePermissions = roleService.queryRolePermission();
		for(RolePermission r : rolePermissions){
			System.out.println(r.toString());
		}
		
	}
	
	@Test
	public void testRoleUpdate(){
		Role role = new Role();
		
		role.setIsDelete(1);
		roleService.update(role);
	}
	
	@Test
	public void testQueryRoot(){
		 List<Permission> pers = permissionService.queryRoot();
		for(Permission per : pers){
			System.out.println(per.getName());
		}
	}
	
	@Test
	public void testGetLogin(){
		AdminUser user = adminUserService.getLogin("pig", "123456");
		System.out.println(user.getUsername());
	}
	@Test
	public void testQueryContents(){
		ZywParams params = new ZywParams();
		params.setChannelId(2);
		params.setKeyWord("d");
		params.setPageNo(0);
		params.setPageSize(10);
		List<Content> contents = contentService.queryContents(params);
		for(Content content : contents){
			System.out.println(content.getTitle());
		}
	}
	@Test
	public void testSaveBatch(){
		List<AdminUser> adminUsers = new ArrayList<AdminUser>();
		AdminUser adminUser1 = new AdminUser();
		
		adminUser1.setUsername("pig1");
		adminUser1.setPassword("12345");
		adminUser1.setEmail("357076478@qq.com");
		adminUser1.setIsDelete(0);
		adminUsers.add(adminUser1);
		
		AdminUser adminUser2 = new AdminUser();
		adminUser2.setUsername("pig2");
		adminUser2.setPassword("12355");
		adminUser2.setEmail("357076@qq.com");
		adminUser2.setIsDelete(0);
		adminUsers.add(adminUser2);
		
	    adminUserService.saveBatch(adminUsers);
		
	}
	@Test
	public void testUpdateBatch(){
		List<AdminUser> adminUsers = new ArrayList<AdminUser>();
		AdminUser adminUser1 = new AdminUser();
		adminUser1 = new AdminUser();
		adminUser1.setId(10);
		adminUser1.setUsername("111");
		
		adminUsers.add(adminUser1);
		
		AdminUser adminUser2 = new AdminUser();
		adminUser2.setId(15);
		adminUser2.setUsername("222");
		adminUsers.add(adminUser2);
		adminUserService.updateBatch(adminUsers);
	}
	@Test
	public void testUpdate(){
		Content content = new Content();
		content.setId(79);
		//content.setIsDelete(1);
		content.setStatus(0);
		int count = contentService.update(content);
		System.out.println(count);
	}
	@Test
	public void testDelete(){
		ZywParams params = new ZywParams();
		params.setId(79);
		contentService.delete(params);
	}
	@Test
	public void testContentStat(){
		ZywParams params = new ZywParams();
		params.setYear("2015");
		List<HashMap<String, Object>> maps = contentStatService.contentStat(params);
		System.out.println(maps);
	}
	
}
