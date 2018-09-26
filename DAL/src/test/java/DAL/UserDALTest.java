package DAL;

import mybatis.Entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserDALTest {
    UserDAL dal=null;
    @Before
    public  void  before(){
        dal=new UserDAL();
    }

    @Test
    public void getOneUserByUid() {
        User user=dal.getOneUserByUid(2);
        System.out.println(user.toString());
    }

    @Test
    public void getOneUserByUname() {
        User u=dal.getOneUserByUname("julia");
        System.out.println(u.toString());
    }

    @Test
    public void getAllUser() {
        List<User>userList=dal.getAllUser();
        for (User u:userList){
            System.out.println(u.toString());
        }
    }

    @Test
    public void simpleSelectAll(){
        List<User>userList=dal.simpleSelectAll();
        for (User u:userList){
            System.out.println(u.toString());
        }
    }

    @Test
    public void moSelect(){
        List<User>users=dal.moSelect("i");
        for (User u:users){
            System.out.println(u.toString());
        }
    }

    @Test
    public void selectByPage(){
        List<User>users=dal.selectByPage(2,3);
        for (User u:users){
            System.out.println(u.toString());
        }
    }

    @Test
    public void delete() {
        System.out.println(dal.delete(5));
    }

    @Test
    public void update() {
        System.out.println(dal.update(new User(5,"tom1",19,0,"my name is tom1!")));
    }

    @Test
    public void  hello(){
        System.out.println("hello mybatis!");
    }
}