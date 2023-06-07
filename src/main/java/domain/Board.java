package domain;

import java.time.LocalDateTime;

public class Board {

    private Long boardId;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;
    private LocalDateTime writeDate;

    public Board(Long boardId, String boardTitle, String boardContent, String boardWriter, LocalDateTime writeDate) {
        this.boardId = boardId;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardWriter = boardWriter;
        this.writeDate = writeDate;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    public LocalDateTime getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(LocalDateTime writeDate) {
        this.writeDate = writeDate;
    }
}
