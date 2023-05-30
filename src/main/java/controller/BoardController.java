package controller;

import domain.Board;
import model.BoardDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BoardService;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private BoardService boardService;

    public void setBoardDao(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    @PostMapping
    public String showBoard(Board board, Model model) {
        List<Board> result = boardService.BoardList();
        model.addAttribute("boardList", "empty");
        if(result.size() != 0) {
            model.addAttribute("boardList", result);
        }
        return "board/boardList";
    }

    @GetMapping("/insert")
    public String showBoardForm(Board board) {
        return "board/boardForm";
    }

    @PostMapping("/insert")
    public String insertBoard(Board board) {
        boardService.insertBoard(board);
        return "redirect:/board";
    }
}
