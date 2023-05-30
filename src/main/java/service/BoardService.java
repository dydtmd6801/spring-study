package service;

import domain.Board;
import model.BoardDao;

import java.util.Collections;
import java.util.List;

public class BoardService {

    private BoardDao boardDao;

    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public List<Board> BoardList() {
        List<Board> result = boardDao.BoardList();
        if(result == null) {
            return Collections.emptyList();
        }
        return result;
    }
}
