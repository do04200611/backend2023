package cs.dit.board;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JList;

public class BInsertService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 데이터의 문자 인코딩을 UTF-8로 설정합니다.
		request.setCharacterEncoding("utf-8");

		// 7. insertForm에서 입력한 subject, content, writer를 받아와 알맞는 변수에 입력합니다.
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		String filename = null;
		String dir = null;

		System.out.println("insert service");

		String contentType = request.getContentType();
		System.out.println(contentType);
		if (contentType != null && contentType.startsWith("multipart/")) {
			dir = request.getServletContext().getRealPath("/uploadfiles");
			System.out.println(dir);
		}

		// 폴더가 만들어지지 않은 상태라면 폴더를 생성합니다.
		File f = new File(dir);
		if (!f.exists()) {
			f.mkdir();
		}

		Collection<Part> parts = request.getParts();
		for (Part p : parts) {
			if (p.getHeader("Content-Disposition").contains("filename=")) {
				if (p.getSize() > 0) {
					filename = p.getSubmittedFileName();
					String filepath = dir + File.separator + filename;
					p.write(filepath);

					p.delete();
				}
			}
		}

		// BoardDto 객체를 생성하여 입력받은 데이터를 담습니다.
		BoardDto dto = new BoardDto(0, subject, content, writer, null, filename);
		BoardDao dao = new BoardDao();

		// 데이터베이스에 새로운 게시물을 추가합니다.
		dao.insert(dto);
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
