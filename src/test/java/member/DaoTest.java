package member;

import config.DBConfig;
import domain.Member;
import model.MemberDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
