package model;

import domain.Board;
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
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement("insert into BOARD (title, content, writer, writeDate) " +
                        "values (?,?,?,?)", new String[] {"id"});
                pstmt.setString(1, board.getBoardTitle());
                pstmt.setString(2, board.getBoardContent());
                pstmt.setString(3, board.getBoardWriter());
                pstmt.setString(4, String.valueOf(board.getWriteDate()));
                return pstmt;
            }
        }, keyHolder);
        Number keyValue = keyHolder.getKey();
        board.setBoardId(keyValue.longValue());
    }
}
