package top.fycoding.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import top.fycoding.dao.UserDao;
import top.fycoding.domain.BuilderWhere;
import top.fycoding.domain.UserModel;
import top.fycoding.utils.JDBCUtil;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    @Override
    public boolean add(UserModel u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public boolean update(UserModel u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public UserModel findOne(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public List<UserModel> findAll(Map<String, String> searchFields) {
        String sql = "SELECT * FROM user ";
        BuilderWhere bw = new BuilderWhere(searchFields);
        sql += bw.getWhere();
        List<UserModel> result = template.query(
            sql, 
            new BeanPropertyRowMapper<UserModel>(UserModel.class),
            bw.getParams().toArray()
            );
        return result;
    }

    @Override
    public int getTotal(Map<String, String> searchFields) {
        BuilderWhere bw = new BuilderWhere(searchFields);
        String sql = "SELECT COUNT(*) FROM user ";
        sql += bw.getWhere();
        Integer total = template.queryForObject(
            sql, 
            Integer.class,
            bw.getParams().toArray());
        return total;
    }
    
}
