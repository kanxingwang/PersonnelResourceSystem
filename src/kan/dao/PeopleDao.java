package kan.dao;

import java.util.List;

import kan.entity.People;

public interface PeopleDao {
    //查询所有的数据
    public List<People> queryAllData();
    //新增数据
     public int insertData(People p);
     //修改数据
     public int update(People p); 
     //删除数据
     public int delete(int id);
     //查询一条数据通过ID
     public People queryDataById(int id);
}
