package daos;

import pojo.User;

import javax.sql.DataSource;

/**
 * Created by Jordan on 6/17/2017.
 */
public interface UserDao {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void setDataSource(DataSource ds);

    public User getUser(String email);
}
