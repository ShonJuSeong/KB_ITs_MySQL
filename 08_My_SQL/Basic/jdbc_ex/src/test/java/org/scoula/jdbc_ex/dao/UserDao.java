package org.scoula.jdbc_ex.dao;

import org.scoula.jdbc_ex.domain.UserVO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDao{
    // 회원등록
    int create(UserVO user) throws SQLException;
    // 회원목록조회
    List<UserVO> getList() throws SQLException;
    // 회원정보조회
    UserVO get(String id) throws SQLException;
    // 회원수정
    int update(UserVO user) throws SQLException;
    // 회원삭제
    int delete(String id) throws SQLException;
}
