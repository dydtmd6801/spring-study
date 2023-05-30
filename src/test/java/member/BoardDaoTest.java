package member;

import config.DBConfig;
import domain.Board;
import model.BoardDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

public class BoardDaoTest {

    private BoardDao boardDao;

    @BeforeEach
    void setDao() {
        boardDao = new BoardDao(new DBConfig().dataSource());
    }

    @Test
    void insertTest() {
        Board board = new Board(
                "테스트",
                "내용 테스트",
                "ync",
                LocalDateTime.now());
        boardDao.BoardInsert(board);

        List<Board> results = boardDao.BoardList();

        assertThat(results.size()).isEqualTo(1);
    }
}
