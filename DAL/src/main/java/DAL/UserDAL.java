package DAL;

import mybatis.Entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
        Map<String,String> map=new HashMap<String, String>();
        List<User> userList=session.selectList("com.nf.mybatis.doAction.moSelect",uname);
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
}
