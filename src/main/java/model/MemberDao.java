package model;

import domain.Member;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MemberDao {

    JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Member findByUserId(String findId) {
        List<Member> result = jdbcTemplate.query("select * from USER where = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member(
                                rs.getString("USERID"),
                                rs.getString("PASSWORD"),
                                rs.getString("NAME"),
                                rs.getString("NICKNAME"),
                                rs.getString("PHONENUMBER"),
                                rs.getString("EMAIL"),
                                rs.getTimestamp("REQDATE").toLocalDateTime());
                        return member;
                    }
                }, findId);
        return result.isEmpty() ? null : result.get(0);
    }
}
