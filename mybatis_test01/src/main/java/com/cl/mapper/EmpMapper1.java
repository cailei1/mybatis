package com.cl.mapper;

import com.cl.pojo.Emp;

import java.util.List;

public interface EmpMapper1 {
    List<Emp> findByCondition(Emp emp);

    List<Emp> findByCondition2(Emp emp);


    int updateByCondition(Emp emp);

    int updateByCondition2(Emp emp);


    List<Emp> findEmpBynos(int[] empnos);

}
