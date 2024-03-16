package spring.core.springOrm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import spring.core.springOrm.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private HibernateTemplate template;
	@Transactional
	public int insertStudent(Student student) {
		// TODO Auto-generated method stub
		
		return (Integer) template.save(student);
	}
	public Student getStudent(int id) {
		return template.get(Student.class, id);
	}
	
	public List<Student> getAllStudent() {
		return  template.loadAll(Student.class);
	}
	@Transactional
	public void deleteStudent(int id) {
		template.delete(this.getStudent(id));
	}
	@Transactional
	public void updateStudent(Student student) {
		template.update(student);
	}

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	

}
