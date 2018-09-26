package DAL;

import mybatis.Entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class UserMapperDAL  implements IMapper{
    //初始化
    InputStream stream=UserDAL.class.getClassLoader().getResourceAsStream("conf.xml");
    SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(stream);
    SqlSession session=ssf.openSession();

    //获得一个映射器
    IMapper mapper=session.getMapper(IMapper.class);


    public List<User> userlist() {
        List<User>userList=mapper.userlist();
        session.close();
        return userList;
    }

    public int insert(User user) {
        int result= mapper.insert(user);
        session.commit();
        session.close();
        return result;
    }

    public int update(User user) {
        int result= mapper.update(user);
        session.commit();
        session.close();
        return result;
    }

    public int delete(int uid) {
        int result= mapper.delete(uid);
        session.commit();
        session.close();
        return result;
    }
}
