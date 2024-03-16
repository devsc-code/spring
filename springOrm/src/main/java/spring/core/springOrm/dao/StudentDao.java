package spring.core.springOrm.dao;

import java.util.List;

import spring.core.springOrm.entities.Student;

public interface StudentDao {
	public int insertStudent(Student student);
	public Student getStudent(int id);
	public List<Student> getAllStudent();
	public void deleteStudent(int id);
	public void updateStudent(Student student);

}
