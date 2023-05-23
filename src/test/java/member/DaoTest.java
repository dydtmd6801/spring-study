package member;

import config.DBConfig;
import domain.Member;
import model.MemberDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class DaoTest {

    private MemberDao memberDao;

    @BeforeEach
    void setDataSource() {
        memberDao = new MemberDao(new DBConfig().dataSource());
    }

    @Test
    void findByUserIdNullTest() {
        String findId = "test";

        Member member = memberDao.findByUserId(findId);

        assertThat(member).isNull();
    }

    @Test
    void insertUser() {
        String userId = "test";
        String password = "1234";
        String name = "홍길동";
        String nickName = "신출귀몰";
        String email = "hong@google.com";
        String phoneNumber = "010-1234-4321";

        Member member = new Member(userId, password, name, nickName, phoneNumber, email, LocalDateTime.now());
        memberDao.insert(member);
        Member result = memberDao.findByUserId(userId);

        assertThat(result.getUserId()).isEqualTo(member.getUserId());
    }
}
