import com.cl.mapper.DeptMapper;
import com.cl.mapper.EmpMapper;
import com.cl.mapper.EmpMapper1;
import com.cl.mapper.EmpMapper3;
import com.cl.pojo.Dept;
import com.cl.pojo.Emp;
import com.cl.pojo.Project;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {

    SqlSession sqlSession;

    @Before
    public void before(){

        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        sqlSession = sqlSessionFactory.openSession(true);

    }


    @Test
    public void test(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> all = mapper.findAll();
        for (Emp emp : all) {
            System.out.println(emp);
        }


    }

    @Test
    public void test1(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        Emp empByNo = mapper.findEmpByNo(7499);
        System.out.println(empByNo);



    }

    @Test
    public void test2(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setDeptno(20);
        emp.setSal(1500);
        List<Emp> bySalAndDeptno = mapper.findBySalAndDeptno(emp);
        for (Emp emp1 : bySalAndDeptno) {
            System.out.println(emp1);
        }
    }

    @Test
    public void test3(){
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDname("哈哈");
        dept.setLoc("圣地亚哥");
        int i = mapper.insertDept(dept);
        System.out.println("deptno:"+dept.getDeptno());

    }

    @Test
    public void test4(){
        // 动态sql 查询语句
        EmpMapper1 mapper = sqlSession.getMapper(EmpMapper1.class);
        Emp emp = new Emp();
        emp.setEname("R");
        List<Emp> byCondition = mapper.findByCondition(emp);
        for (Emp emp1 : byCondition) {
            System.out.println(emp1);
        }

    }

    @Test
    public void testByCondition2(){
        // 动态sql 查询语句
        EmpMapper1 mapper = sqlSession.getMapper(EmpMapper1.class);
        Emp emp = new Emp();
        emp.setEmpno(7521);
        emp.setEname("R");
        emp.setJob("salesman");
        List<Emp> byCondition = mapper.findByCondition2(emp);
        for (Emp emp1 : byCondition) {
            System.out.println(emp1);
        }

    }

    @Test
    public void testupdateByCondition(){
        // 动态sql 查询语句
        EmpMapper1 mapper = sqlSession.getMapper(EmpMapper1.class);
        Emp emp = new Emp();
        emp.setEmpno(7521);
        emp.setEname("Tom");
        emp.setJob("HELLO");
        mapper.updateByCondition(emp);

    }

    @Test
    public void testupdateByCondition2(){
        // 动态sql 查询语句
        EmpMapper1 mapper = sqlSession.getMapper(EmpMapper1.class);
        Emp emp = new Emp();
        emp.setEmpno(7521);
        emp.setEname("Tom");
        emp.setJob("HELLO");
        mapper.updateByCondition2(emp);
    }


    @Test
    public void findEmpByNos(){
        // 动态sql 查询语句
        EmpMapper1 mapper = sqlSession.getMapper(EmpMapper1.class);
        List<Emp> empBynos = mapper.findEmpBynos(new int[]{7521, 7369, 7499,});
        for (Emp empByno : empBynos) {
            System.out.println(empByno);
        }
    }


    @Test
    public void findJionTest() {
        // 动态sql 查询语句
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empJoinDept = mapper.findEmpJoinDept(7499);
        System.out.println(empJoinDept);

    }

    @Test
    public void findDeptJoinEmp() {
        // 动态sql 查询语句
        EmpMapper3 mapper = sqlSession.getMapper(EmpMapper3.class);
        List<Dept> deptToEmps = mapper.findDeptToEmps(20);
        for (Dept deptToEmp : deptToEmps) {
            System.out.println(deptToEmp);
        }

    }


    @Test
    public void findEmpByPid() {
        // 动态sql 查询语句
        EmpMapper3 mapper = sqlSession.getMapper(EmpMapper3.class);
        List<Project> projects = mapper.findEmpByProjectNo(2);
        for (Project project : projects) {
            System.out.println(project);

        }
    }
    @After
    public void after(){
        sqlSession.close();
    }
}
