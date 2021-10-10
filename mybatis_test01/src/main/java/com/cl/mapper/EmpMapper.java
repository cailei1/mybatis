package com.cl.mapper;

import com.cl.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    List<Emp> findAll();


    Emp findEmpByNo(int empno);


    List<Emp> findBySalAndDeptno(Emp emp);

}
