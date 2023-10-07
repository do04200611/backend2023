package cs.dit.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JList;

public interface BoardService<BoardAttachVO> {

    /**
     * 요청을 처리하는 메소드입니다.
     *
     * @param request  HTTP 요청 객체
     * @param response HTTP 응답 객체
     * @throws ServletException Servlet 예외
     * @throws IOException      입출력 예외
     */
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    /**
     * 추가 메소드 1
     *
     * @param <FileItem> 요청과 응답 객체를 처리하는 메소드
     * @param request     HTTP 요청 객체
     * @param response    HTTP 응답 객체
     * @throws ServletException Servlet 예외
     * @throws IOException      입출력 예외
     */
    <FileItem> void execute11(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    /**
     * 추가 메소드 2
     *
     * @param <FileItem> 요청과 응답 객체를 처리하는 메소드
     * @param request     HTTP 요청 객체
     * @param response    HTTP 응답 객체
     * @throws ServletException Servlet 예외
     * @throws IOException      입출력 예외
     */
    <FileItem> void execute111(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    /**
     * 추가 메소드 3
     *
     * @param <FileItem> 요청과 응답 객체를 처리하는 메소드
     * @param request     HTTP 요청 객체
     * @param response    HTTP 응답 객체
     * @throws ServletException Servlet 예외
     * @throws IOException      입출력 예외
     */
    <FileItem> void execute1111(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    /**
     * 추가 메소드 4
     *
     * @param <FileItem> 요청과 응답 객체를 처리하는 메소드
     * @param request     HTTP 요청 객체
     * @param response    HTTP 응답 객체
     * @throws ServletException Servlet 예외
     * @throws IOException      입출력 예외
     */
    <FileItem> void execute1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    /**
     * 첨부 파일 목록을 가져오는 메소드입니다.
     *
     * @param bno 게시물 번호
     * @return 첨부 파일 목록을 포함하는 JList 객체
     */
    JList<BoardAttachVO> getAttachList(Long bno);
}
