package com.entor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.entor.entity.Student;


public interface StudentMapper {
	@Insert("insert into student(name,username,password,sex,age,birthday,createTime)Values(#{name},#{username},#{passwrod},#{age},#{sex},#{birthday},now())")
	public void add(Student student);
	
	@Update("update student set name=#{name},username=#{username},passwrod=#{passwrod},sex=#{sex},age=#{age},birthday=#{birthday},createTime#{createTime}")
	public void update(Student student);
	
	@Delete("delete from student where id = #{id}")
	public void deleteById(int id);
	
	@Select("select * from student where id = #{id}")
	public Student queryById(int id);
	
	@Select("select * from student limit #{star},#{pageSize}")
	public List<Student> queryByPage(@Param("star")int currentPage,@Param("pageSize")int pageSize);
	
	@Select("select * from Student")
	public List<Student> queryAll();
}
