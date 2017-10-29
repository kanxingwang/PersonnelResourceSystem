package kan.dao.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.PreparedStatement.ParseInfo;

import kan.dao.PeopleDao;
import kan.entity.People;
import kan.utils.JdbcHelper;

public class PeopleDaoImpl implements PeopleDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<People> queryAllData() {
        List<People> peoples=new ArrayList<People>();
        @SuppressWarnings("rawtypes")
        ResultSet rs = null;
        try {
            rs=JdbcHelper.query("SELECT * FROM people");
            while (rs.next()) {
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                People people=new People();
                people.setId(rs.getInt(1));
                people.setName(rs.getString(2));
                people.setAge(rs.getInt(3));
                peoples.add(people);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //JdbcHelper.free(rs);
        }
        return peoples;
    }

    @Override
    public int insertData(People p) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(People p) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public People queryDataById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

}
