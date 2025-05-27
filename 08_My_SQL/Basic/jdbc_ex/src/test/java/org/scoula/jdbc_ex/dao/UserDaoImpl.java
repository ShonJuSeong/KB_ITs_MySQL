package org.scoula.jdbc_ex.dao;

import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.domain.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao{
    Connection conn = JDBCUtil.getConnection();

    // USERS 테이블관련SQL 명령어
    private String USER_LIST = "select * from users";
    private String USER_GET = "select * from users where id = ?";
    private String USER_INSERT = "insert into users values(?, ?, ?, ?)";
    private String USER_UPDATE = "update users set name = ?, role = ? where id = ?";
    private String USER_DELETE = "delete from users where id = ?";
    // 회원등록
    @Override
    public int create(UserVO user) throws SQLException{
        PreparedStatement stmt= conn.prepareStatement(USER_INSERT);
        stmt.setString(1, user.getId());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getName());
        stmt.setString(4, user.getRole());
        int count = stmt.executeUpdate();
        stmt.close();
        return count;
    }
    // 회원목록조회
    @Override
    public List<UserVO> getList() throws SQLException{
        List<UserVO> userList= new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement stmt= conn.prepareStatement(USER_LIST);
        ResultSet rs= stmt.executeQuery();
        while (rs.next()) {
            UserVO user = new UserVO();
            user.setId(rs.getString("ID"));
            user.setPassword(rs.getString("PASSWORD"));
            user.setName(rs.getString("NAME"));
            user.setRole(rs.getString("ROLE"));
            userList.add(user);
        } //while
        rs.close();
        stmt.close();
        return userList;
    }
    // 회원정보조회
    @Override
    public UserVO get(String id) throws SQLException{
        UserVO user = new UserVO();
        PreparedStatement stmt= conn.prepareStatement(USER_GET);
        stmt.setString(1, id);
        ResultSet rs= stmt.executeQuery();
        if (rs.next()) {
            user.setId(rs.getString("ID"));
            user.setPassword(rs.getString("PASSWORD"));
            user.setName(rs.getString("NAME"));
            user.setRole(rs.getString("ROLE"));
        } //if
        rs.close();
        stmt.close();
        return user;
    }
    // 회원수정
    @Override
    public int update(UserVO user) throws SQLException{
        PreparedStatement stmt= conn.prepareStatement(USER_UPDATE);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getRole());
        stmt.setString(3, user.getId());
        int count = stmt.executeUpdate();
        stmt.close();
        return count;
    }
    // USERS 테이블관련CRUD 메소드
// 회원삭제
    @Override
    public int delete(String id) throws SQLException{
        PreparedStatement stmt= conn.prepareStatement(USER_DELETE);
        stmt.setString(1, id);
        int rows = stmt.executeUpdate();
        stmt.close();
        return rows;
    }
} //class
