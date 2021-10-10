package com.cl.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.AutomapConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    private Integer pid;
    private String pname;
    private Integer money;

    private List<ProjectRecord> projectRecords;


}
