package daos;

import pojo.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jordan on 6/17/2017.
 */
public class JdbcUserDao implements UserDao {
    private String TABLE = "user";
    private String FIELD_ID = TABLE + ".id";
    private String FIELD_FIRSTNAME = TABLE + ".firstName";
    private String FIELD_LASTNAME = TABLE + ".lastName";
    private String FIELD_EMAIL = TABLE + ".email";
    private String FIELD_PASSWORD = TABLE + ".password";

    private DataSource dataSource;

    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
    }

    public User getUser(String email) {
        String sql = "SELECT * FROM " + TABLE + " WHERE " + FIELD_EMAIL + " = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            int a = 0;
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(++a, email);
            rs = ps.executeQuery();
            if(rs.next()) {
                Integer id = rs.getInt(FIELD_ID);
                String firstName = rs.getString(FIELD_FIRSTNAME);
                String lastName = rs.getString(FIELD_LASTNAME);
                String password = rs.getString(FIELD_PASSWORD);
                return new User(id, firstName, lastName, email, password);
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
