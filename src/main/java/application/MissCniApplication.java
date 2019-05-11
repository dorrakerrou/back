package application;

import java.io.InputStream;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

import application.model.Role;
import application.model.Utilisateur;
import application.repository.RoleRepository;
import application.repository.UserRepository;
import application.util.RoleEnum;
/*import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
*/
@SpringBootApplication
@EntityScan("application.*")
public class MissCniApplication {

	public static void main(String[] args) /* throws JRException */{
		
		
		ConfigurableApplicationContext ctx=SpringApplication.run(MissCniApplication.class, args);
     	RoleRepository roleRepository = ctx.getBean(RoleRepository.class);
		
     /*
			JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\ikram ben ahmed\\Documents\\workspace-spring-tool-suite-4-4.1.1.RELEASE\\miss_cni\\src\\Blank_A4.jrxml");
		
     	JRDataSource jrDataSource = new JREmptyDataSource() ; 
     	JasperPrint jasperPrint =JasperFillManager.fillReport(jasperReport, null , jrDataSource) ; 
     	
     	JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\ikram ben ahmed\\Documents\\workspace-spring-tool-suite-4-4.1.1.RELEASE\\miss_cni\\src\\Blank_A4.pdf") ; 
     	
     	
     	
     	
     	
     	*/
        Role roleOrd = new Role(RoleEnum.ROLE_ORD)  ; 
		Role roleUser = new Role(RoleEnum.ROLE_USER);
		Role roleAdmin = new Role(RoleEnum.ROLE_ADMIN);
		Role roleControl = new Role(RoleEnum.ROLE_CONTROL);
		Role rolePayeur = new Role(RoleEnum.ROLE_PAYEUR) ; 
		Role roleMinstr = new Role(RoleEnum.ROLE_MINSTR) ; 
		
		
		roleRepository.save(roleOrd) ; 
		roleRepository.save(roleControl) ;
		roleRepository.save(rolePayeur) ; 
		roleRepository.save(roleMinstr) ; 
		roleRepository.save(roleUser);
		roleRepository.save(roleAdmin);
		
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		
		Utilisateur user = new Utilisateur("user","password1", true);
		user.setRoles(Arrays.asList(roleUser));
		userRepository.save(user);

		Utilisateur use = new Utilisateur("98765432","Kerro","Dorra","pass3", true);
		use.setRoles(Arrays.asList(roleUser, roleControl));
		userRepository.save(use);

		
		Utilisateur admin = new Utilisateur("12345678","Sghaier","Jamila", "password2", true);
		admin.setRoles(Arrays.asList(roleUser));
		userRepository.save(admin);

		Utilisateur user1 = new Utilisateur("11406260","Ben ahmed","Ikram","ikram", true);
		user1.setRoles(Arrays.asList(roleOrd,roleUser));
		userRepository.save(user1);
		

	}

}
