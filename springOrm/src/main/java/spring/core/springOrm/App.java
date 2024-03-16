package spring.core.springOrm;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import spring.core.springOrm.dao.StudentDao;
import spring.core.springOrm.dao.StudentDaoImpl;
import spring.core.springOrm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context= new ClassPathXmlApplicationContext("spring/core/springOrm/config.xml");
        StudentDao studentDao=context.getBean("studentDao",StudentDaoImpl.class);
        
        Scanner sc= new Scanner(System.in);
        boolean flag=true;
        System.out.println("Spring Application Running...");
        while(flag) {
        	
        	System.out.println("press 1 to add new student");
        	System.out.println("press 2 to fetch the details of a particular student");
        	System.out.println("press 3 to fetch details of all the studnts");
        	System.out.println("press 4 to delete a student");
        	System.out.println("press 5 to update details of a student");
        	System.out.println("press 6 to exit");
        	
        	try {
        		int input=sc.nextInt();
        		Student student= new Student();
        		switch (input){
        			
        		case 1:{
        			System.out.println("please enter Student id");
        			student.setId(sc.nextInt());
        			sc.nextLine();
        			System.out.println("please enter Student name");
        			student.setName(sc.nextLine());
        			System.out.println("please enter Student city");
        			student.setCity(sc.nextLine());
        			System.out.println("inserted student with id : "+studentDao.insertStudent(student));
        			break;
        		}
        		
        		case 2:{
        			System.out.println("please enter Student id whose details you want to fetch");
        			System.out.println(studentDao.getStudent(sc.nextInt()));    	
        			break;
        		}
        		
        		case 3:{
        			System.out.println(studentDao.getAllStudent());
        			break;
        		}

        		case 4:{
        			System.out.println("please enter Student id whose details you want to delete");
        			int x=sc.nextInt();
        			studentDao.deleteStudent(x);
        			System.out.println("student with id "+x+" deleted from database");  
        			break;
        		}

        		case 5:{
        			System.out.println("please enter Student id whose details you want to update");
        			int x=sc.nextInt();
        			student.setId(x);
        			System.out.println("please enter updated student name");
        			sc.nextLine();
        			student.setName(sc.nextLine());
        			System.out.println("please enter updated student city");
        			student.setCity(sc.nextLine());
        			studentDao.updateStudent(student);
        			System.out.println("student details with id "+x+" upadated in database");
        			break;
        		}

        		case 6:{
        			flag=false;
        			break;
        		}
        			
        		}
        		
        		
        		
        	}
        	catch(Exception e) {
        		System.out.println("Invalid Input");
        		System.out.println(e.getMessage());
        		
        	}
        }
        
        System.out.println("Application closed !!! Thanks for using our application.");
    }
}
