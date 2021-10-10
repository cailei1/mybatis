package com.cl.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRecord {

    private Integer pid;
    private Integer empno;

    private Emp emp;
}
