package model;

import domain.Member;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    private static final String findById = "select * from USER where USERID = ?";
    private static final String insert = "insert into USER (USERID, PASSWORD, NAME, NICKNAME, EMAIL, PHONENUMBER, REQTIME)";
    private static final String insertValue = "values (?,?,?,?,?,?,?)";

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Member findByUserId(String findId) {
        List<Member> result = jdbcTemplate.query(findById,
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member(
                                rs.getString("USERID"),
                                rs.getString("PASSWORD"),
                                rs.getString("NAME"),
                                rs.getString("NICKNAME"),
                                rs.getString("EMAIL"),
                                rs.getString("PHONENUMBER"),
                                rs.getTimestamp("REQTIME").toLocalDateTime());
                        return member;
                    }
                }, findId);
        return result.isEmpty() ? null : result.get(0);
    }

    public void insert(Member member) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(insert + insertValue, new String[]{"ID"});
                pstmt.setString(1, member.getUserId());
                pstmt.setString(2, member.getPassword());
                pstmt.setString(3, member.getName());
                pstmt.setString(4, member.getNickName());
                pstmt.setString(5, member.getEmail());
                pstmt.setString(6, member.getPhoneNumber());
                pstmt.setString(7, String.valueOf(member.getRegTime()));
                return pstmt;
            }
        }, keyHolder);
        Number keyValue = keyHolder.getKey();
        member.setId(keyValue.longValue());
    }

    public void update(Member member) {
        jdbcTemplate.update("update USER set NAME = ?, PHONENUMBER = ? where USERID = ?",member.getName(), member.getPhoneNumber(), member.getUserId());
    }
}
