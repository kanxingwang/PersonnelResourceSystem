package kan.service.impl;

import java.util.List;

import kan.dao.PeopleDao;
import kan.dao.impl.PeopleDaoImpl;
import kan.entity.People;
import kan.service.PeopleService;

public class PeopleServiceImpl implements PeopleService  {
    private PeopleDao peopleDao;
    
    @Override
    public List<People> queryAllData() {
        List<People> peoples =  peopleDao.queryAllData();
        return peoples;
    }

    @Override
    public boolean insertData(People p) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(People p) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public People queryDataById(int id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public PeopleServiceImpl() {
        this.peopleDao=new PeopleDaoImpl();
        
    }
    
    

}
