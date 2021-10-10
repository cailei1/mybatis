import com.cl.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Test3 {

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


        System.out.println("查询单个对象");
        Emp emp = sqlSession.selectOne("findOne");
        System.out.println(emp);

    }


    @Test
    public void test1(){


        System.out.println("查询Map对象");

        // 将 EMPNO 这一列作为key
        Map<Integer, Emp> keyMap = sqlSession.selectMap("findMap", "EMPNO");

        Set<Integer> keyset = keyMap.keySet();

        for (Integer key : keyset) {
            System.out.println("key:"+key+keyMap.get(key));
        }


    }

    @Test
    public void test2(){


        System.out.println("测试参数");

        Emp emp = sqlSession.selectOne("findEmpByNo", 7521);

        System.out.println(emp);


    }

    @Test
    public void test3(){

        Map<String,Object> args = new HashMap<String, Object>();
        args.put("deptno",20);
        args.put("sal",1500);


        System.out.println("测试参数是map的对象");

        List<Emp> findEmpByNoAndSal = sqlSession.selectList("findEmpByNoAndSal", args);


        for (Emp emp : findEmpByNoAndSal) {
            System.out.println(emp);
        }
//        System.out.println(emp);


    }

    @Test
    public void test4(){

        Emp arg = new Emp();
        arg.setDeptno(10);
        arg.setSal(2000);


        System.out.println("测试参数是map的对象");

        List<Emp> findEmpByNoAndSal = sqlSession.selectList("findEmpByNoAndSal", arg);


        for (Emp emp : findEmpByNoAndSal) {
            System.out.println(emp);
        }


    }

    @Test
    public void test5(){
        Emp emp = new Emp(null,"cailei","SALEMAN",7521,new Date(),4000,200,10);
        int insertEmp = sqlSession.insert("insertEmp", emp);
        //提交事务
        sqlSession.commit();

    }

    @Test
    public void test6(){
        Emp emp = new Emp();
        emp.setEname("蔡磊");
        emp.setEmpno(7847);
        int updateEmp = sqlSession.insert("updateEmp", emp);

    }

    @Test
    public void test7(){

        int updateEmp = sqlSession.delete("deleteEmp",7847);

    }


    @After
    public void after(){
        sqlSession.close();
    }
}
