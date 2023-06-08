package controller;

import domain.AuthInfo;
import domain.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.BoardService;
import validator.BoardValidator;

import javax.servlet.http.HttpSession;
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
        if (result.size() != 0) {
            model.addAttribute("boardList", result);
        }
        return "board/boardList";
    }

    @GetMapping("/insert")
    public String showBoardForm(Board board, HttpSession session, Model model) {
        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
        if (authInfo == null) {
            return "redirect:/board";
        }
        model.addAttribute("authInfo", authInfo);
        return "board/boardForm";
    }

    @PostMapping("/insert")
    public String insertBoard(Board board, HttpSession session, Errors errors) {
        new BoardValidator().validate(board, errors);
        if (errors.hasErrors()) {
            return "board/boardForm";
        }
        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
        board.setBoardWriter(authInfo.getName());
        boardService.insertBoard(board);
        return "redirect:/board";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam String id, Model model) {
        Board boardDetail = boardService.searchBoardById(id);
        model.addAttribute("board", boardDetail);
        return "board/boardDetail";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam String id, Board board, Model model, HttpSession session) {
        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
        Board editBoard = boardService.searchBoardById(id);
        if (authInfo != null && authInfo.getName().equals(editBoard.getBoardWriter())) {
            model.addAttribute("board", editBoard);
            return "/board/boardEditForm";
        }
        return "redirect:/board/detail?id=" + editBoard.getBoardId();
    }

    @PostMapping("/edit")
    public String editBoardContent(Board board) {
        boardService.editBoardContent(board);
        return "redirect:/board/detail?id=" + board.getBoardId();
    }
}
