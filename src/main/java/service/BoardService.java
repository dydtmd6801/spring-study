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

    public void insertBoard(Board board) {
        boardDao.BoardInsert(board);
    }

    public Board searchBoardById(String id) {
        Board board = boardDao.BoardSearchById(id);
        return board;
    }

    public void editBoardContent(Board board) {
        board.setBoardId(board.getBoardId());
        board.setBoardContent(board.getBoardContent());
        boardDao.update(board);
    }
}
