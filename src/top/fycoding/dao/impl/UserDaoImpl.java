package top.fycoding.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import top.fycoding.dao.UserDao;
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
    public List<UserModel> findAll() {
        String sql = "select * from user";
        List<UserModel> result = template.query(sql, new BeanPropertyRowMapper<UserModel>(UserModel.class));
        return result;
    }

    @Override
    public int getTotal() {
        String sql = "select count(*) from user";
        return template.queryForObject(sql, Integer.class);
    }
    
}
