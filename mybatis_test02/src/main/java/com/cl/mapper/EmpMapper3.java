package com.cl.mapper;

import com.cl.pojo.Dept;
import com.cl.pojo.Emp;
import com.cl.pojo.Project;

import java.util.List;

public interface EmpMapper3 {


    List<Dept> findDeptToEmps(int deptno);


    List<Project> findEmpByProjectNo(int pid);


}
