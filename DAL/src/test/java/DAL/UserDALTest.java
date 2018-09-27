package DAL;

import mybatis.Entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<User>users=dal.moSelect("z");
        for (User u:users){
            System.out.println(u.toString());
        }
    }

    @Test
    public void moSelect2(){
        List<User>users=dal.moSelect2("i");
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

    @Test
    public void addUserReturnInfo() {
        dal.addUserReturnInfo(new User("jetty", 19, 0, "my name is jetty!"));
    }

    @Test
    public void selectWithIf(){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("uname","i");
//        map.put("usex",1);
        map.put("uage",19);
        List<User>userList=dal.selectWithIf(map);
        for (User u:userList){
            System.out.println(u.toString());
        }
    }

    @Test
    public void selectByLimit(){
        Map<String,Object>map=new HashMap<String, Object>();
       // map.put("uname","");
        map.put("usex",1);
        List<User>userList=dal.selectByLimit(map);
        for (User u:userList){
            System.out.println(u.toString());
        }
    }

    @Test
    public void  selectWithIn(){
        List<Integer> list=new ArrayList<Integer>();
       // list.add(1); list.add(3); list.add(4); list.add(5);
        List<User> userList= dal.selectWithIn(list);
        for (User u:userList){
            System.out.println(u.toString());
        }
    }

    @Test
    public  void selectWithInAndMoreLimit(){
        ArrayList<Integer> arr=new ArrayList<Integer>();
        arr.add(16);arr.add(17);arr.add(18);arr.add(19);arr.add(20);
        String uname="i";
        int uage=19;
        int usex=1;
       List<User> userList=dal.selectWithInAndMoreLimit(arr,uname,uage,usex);
       for (User u:userList){
           System.out.println(u.toString());
       }
    }
}