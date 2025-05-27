package org.scoula.jdbc_ex;
import org.scoula.jdbc_ex.dao.UserDao;
import org.scoula.jdbc_ex.dao.UserDaoImpl;
import org.scoula.jdbc_ex.domain.UserVO;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
public class UserMain{
    static UserDao userDao= new UserDaoImpl();
    static final Scanner sc= new Scanner(System.in);
    public static void main(String[] args) throws SQLException{
        while (true) {
            System.out.println("원하는작업을선택하시오.");
            System.out.println("=====================");
            System.out.println("1. insert");
            System.out.println("2. selectList");
            System.out.println("3. selectOne");
            System.out.println("4. update");
            System.out.println("5. delete");
            System.out.println("6. exit");
            System.out.println("=====================");
            System.out.print("번호입력>> ");
            int choice = sc.nextInt();
            if (choice == 1) {
                insert();
            } else if (choice == 2) {
                selectList();
            } else if (choice == 3) {
                selectOne();
            } else if (choice == 4) {
                update();
            } else if (choice == 5) {
                delete();
            } else if (choice == 6) {
                System.out.println("프로그램을종료합니다.");
                JDBCUtil.close();
                System.exit(0); //프로그램종료
            } else {
                System.out.println("선택이올바르지않음.");
            }
        }
    }
    private static void printVO(UserVO userVO) {
        System.out.println("아이디: " + userVO.getId() + ", 패스워드: " + userVO.getPassword() + ", 이름: "
                + userVO.getName() + ", 역할: " + userVO.getRole());
    }
    public static void insert() throws SQLException {
        UserVO user = new UserVO();
        System.out.println("id, pw, name, role을 순서대로 입력하시오.");
        System.out.print("id(12글자이내) >> ");
        user.setId(sc.next());
        System.out.print("pw(12글자이내) >> ");
        user.setPassword(sc.next());
        System.out.print("name(30글자이내) >> ");
        user.setName(sc.next());
        System.out.print("role(6글자이내) >> ");
        user.setRole(sc.next());
        int result = userDao.create(user);
        if (result == 1) {
            System.out.println("insert 성공!");
        }
    }
    public static void selectList() throws SQLException{
        List<UserVO> list = userDao.getList();
        if (list.size() == 0) {
            System.out.println("검색실패, 데이터없음.");
        }else {
            for (UserVO userVO: list) {
                printVO(userVO);
            }
        }
    }
    public static void selectOne() throws SQLException{
        System.out.println("검색하고자 하는 id를 입력하시오.");
        System.out.print("id(12글자이내) >> ");
        String id = sc.next();
        UserVO userVO= userDao.get(id);
        if (userVO.getId() == null) {
            System.out.println("검색실패, 없는 id입니다.!");
        }else {
            printVO(userVO);
        }
    }
    public static void update() throws SQLException {
        //가방 만들고
        UserVO user = new UserVO();
        //입력받아 가방에 넣고
        System.out.println("name, role, id를 순서대로 입력하시오.");
        System.out.print("name(30글자이내) >> ");
        user.setName(sc.next());
        System.out.print("role(6글자이내) >> ");
        user.setRole(sc.next());
        System.out.print("id(12글자이내) >> ");
        user.setId(sc.next());
        //dao의 update 메서드 호출하면서 가방 전달하고
        int result = userDao.update(user);
        //결과처리
        if (result == 1) {
            System.out.println("update 성공!");
        }else {
            System.out.println("update 실패!");
        }
    }
    public static void delete() throws SQLException {
        System.out.println("삭제하고자 하는 id를 입력하시오.");
        System.out.print("id(12글자이내) >> ");
        String id = sc.next();
        int result = userDao.delete(id);
        //결과처리
        if (result == 1) {
            System.out.println("delete 성공!");
        }else {
            System.out.println("delete 실패!");
        }
    }
}