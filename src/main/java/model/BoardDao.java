package model;

import domain.Board;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class BoardDao {

    private JdbcTemplate jdbcTemplate;

    public BoardDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Board> BoardList() {
        List<Board> results = jdbcTemplate.query("select * from BOARD", new RowMapper<Board>() {
            @Override
            public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                Board board = new Board(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writer"),
                        rs.getTimestamp("writeDate").toLocalDateTime()
                );
                return board;
            }
        });
        return results;
    }

    public void BoardInsert(Board board) {
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement("insert into BOARD (title, content, writer, writeDate) " +
                        "values (?,?,?,?)");
                pstmt.setString(1, board.getBoardTitle());
                pstmt.setString(2, board.getBoardContent());
                pstmt.setString(3, board.getBoardWriter());
                pstmt.setString(4, String.valueOf(LocalDateTime.now()));
                return pstmt;
            }
        });
    }

    public Board BoardSearchById(String id) {
        Board result = jdbcTemplate.queryForObject("select * from board where ID=?",
                (rs, rowNum) -> new Board(
                        rs.getLong("ID"),
                        rs.getString("TITLE"),
                        rs.getString("CONTENT"),
                        rs.getString("WRITER"),
                        rs.getTimestamp("WRITEDATE").toLocalDateTime()
                ),id);
        return result;
    }

}
