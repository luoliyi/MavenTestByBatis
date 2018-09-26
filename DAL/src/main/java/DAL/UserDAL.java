package DAL;

import com.sun.corba.se.spi.ior.ObjectKey;
import mybatis.Entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.omg.CORBA.OBJ_ADAPTER;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAL {
    //初始化
    InputStream stream=UserDAL.class.getClassLoader().getResourceAsStream("conf.xml");
    SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(stream);
    SqlSession session=ssf.openSession();

    public User getOneUserByUid(int uid){
        User user=session.selectOne("com.nf.mybatis.doAction.selectUserByUid",uid);
        session.close();
        return user;
    }
    public User getOneUserByUname(String uname){
        User user=session.selectOne("com.nf.mybatis.doAction.selectUserByName",uname);
        session.close();
        return user;
    }
    public List<User>getAllUser(){
        List<User>userList=session.selectList("com.nf.mybatis.doAction.selectAll");
        session.close();
        return userList;
    }
    public List<User>simpleSelectAll(){
        List<User> userList=session.selectList("com.nf.mybatis.doAction.simpleSelectAll");
        return userList;
    }

    List<User> selectByPage(@Param("pageno") int pageno, @Param("limit") int limit){
        Map<String,Integer>map=new HashMap<String,Integer>();
        map.put("pageno",(pageno-1)*limit);
        map.put("limit",limit);
        List<User> userList=session.selectList("com.nf.mybatis.doAction.selectByPage",map);
        return userList;
    }

    public List<User> moSelect(String uname){
        List<User> userList=session.selectList("com.nf.mybatis.doAction.moSelect",uname);
        return userList;
    }

    public List<User> moSelect2(String uname){
        List<User> userList=session.selectList("com.nf.mybatis.doAction.moSelect2",uname);
        return userList;
    }

    public int insert(User u){
        int result= session.insert("com.nf.mybatis.doAction.addUser",u);
        session.commit();
        session.close();
        return result;
    }
    public int delete(int uid){
        int result= session.delete("com.nf.mybatis.doAction.deleteUser",uid);
        session.commit();
        session.close();
        return result;
    }
    public int update(User user){
        int result= session.delete("com.nf.mybatis.doAction.updateUser",user);
        session.commit();
        session.close();
        return result;
    }


    /*复杂操作,返回新增id*/
    public int addUserReturnInfo(User user){
        System.out.println("插入前的id:"+user.getUid());
        session.insert("com.nf.mybatis.doAction.addUserReturnInfo",user);
       session.commit();
       session.close();
        System.out.println("插入后的id:"+user.getUid());
       return user.getUid();
    }

    /*复杂操作，条件查询*/
    public List<User> selectWithIf(Map<String,Object> map){
        List<User> userList=session.selectList("com.nf.mybatis.doAction.selectWithIf",map);
        return userList;
    }

    //复杂操作，条件查询2
    public List<User> selectByLimit(Map<String,Object> map){
        return session.selectList("com.nf.mybatis.doAction.selectByLimit",map);
    }
}
