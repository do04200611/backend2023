package cs.dit.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JList;

public class BSelectOneService implements BoardService {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 데이터의 문자 인코딩을 UTF-8로 설정합니다.
        request.setCharacterEncoding("utf-8");

        // 요청에서 "bcode" 매개변수를 가져와 정수로 변환합니다.
        int bcode = Integer.parseInt(request.getParameter("bcode"));

        // BoardDto 객체와 BoardDao 객체를 생성합니다.
        BoardDto dto = new BoardDto();
        BoardDao dao = new BoardDao();

        // BoardDao의 selectOne 메소드를 호출하여 원하는 레코드를 dto에 저장합니다.
        dto = dao.selectOne(bcode);

        // request에 dto를 설정하여 특정 게시물 정보를 전달합니다.
        request.setAttribute("dto", dto);
    }

    @Override
    public void execute11(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    @Override
    public void execute111(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    @Override
    public void execute1111(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    @Override
    public void execute1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    @Override
    public JList getAttachList(Long bno) {
        // TODO Auto-generated method stub
        return null;
    }
}
