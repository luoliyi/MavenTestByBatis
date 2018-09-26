package DAL;

import mybatis.Entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserMapperDALTest {

    @Test
    public void userlist() {
        UserMapperDAL dal=new UserMapperDAL();
        List<User> list=dal.userlist();
        for (User u:list){
            System.out.println(u.toString());
        }
    }

    @Test
    public void insert() {
        UserMapperDAL dal=new UserMapperDAL();
        dal.insert(new User("liyi",20,0,"my name is liyi!"));
    }

    @Test
    public void update() {
        UserMapperDAL dal=new UserMapperDAL();
        dal.update(new User(9,"lili2",19,1,"my name is lili2"));
    }

    @Test
    public void delete() {
        UserMapperDAL dal=new UserMapperDAL();
        dal.delete(9);
    }
}