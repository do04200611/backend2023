package cs.dit.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JList;

public class BListService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. BoardDao를 생성합니다.
		BoardDao dao = new BoardDao();
		int count = dao.recordCount(); // 전체 레코드의 개수를 가져옵니다.
		int numOfRecords = 10;        // 한 번에 가져올 레코드의 개수를 설정합니다.
		int numOfPages = 5;           // 한 화면에 표시될 페이지의 개수를 설정합니다.

		String page = request.getParameter("p");
		int p = 1;  // 현재 페이지 번호를 초기화합니다.

		if (page != null && !page.equals("")) {
			p = Integer.parseInt(page);
		}

		int startNum = p - (p - 1) % numOfPages; // 현재 페이지 블록의 시작 페이지 번호를 계산합니다.
		int lastNum = (int) Math.ceil((float) count / (float) numOfRecords); // 전체 페이지 수를 계산합니다.

		// 2. dao의 해당 메소드를 호출하여 게시물 리스트를 가져옵니다.
		ArrayList<BoardDto> dtos = dao.list(p, numOfRecords);

		// 3. 호출 결과를 처리하여 request 객체에 저장합니다.
		request.setAttribute("dtos", dtos);
		request.setAttribute("p", p);
		request.setAttribute("startNum", startNum);
		request.setAttribute("lastNum", lastNum);
		request.setAttribute("numOfPages", numOfPages);

		System.out.println("p: " + p);
		System.out.println("startNum: " + startNum);
		System.out.println("lastNum: " + lastNum);
	}

	@Override
	public void execute11(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 아직 구현되지 않은 메소드입니다.

	}

	@Override
	public void execute111(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 아직 구현되지 않은 메소드입니다.

	}

	@Override
	public void execute1111(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 아직 구현되지 않은 메소드입니다.

	}

	@Override
	public void execute1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 아직 구현되지 않은 메소드입니다.

	}

	@Override
	public JList getAttachList(Long bno) {
		// 아직 구현되지 않은 메소드입니다.
		return null;
	}
}
