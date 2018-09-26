package DAL;

import mybatis.Entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IMapper {
    @Select("select * from information")
    List<User> userlist();

    @Insert("insert into information(uname,uage,usex,udesc) values(#{uname},#{uage},#{usex},#{udesc})")
    int insert(User user);

    @Update("update information set uname=#{uname},uage=#{uage},usex=#{usex},udesc=#{udesc} where uid=#{uid}")
    int update(User user);

    @Delete("delete from information where uid=#{uid}")
    int delete(int uid);
}
