package cs.dit.board;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JList;

public class BUpdateService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 데이터의 문자 인코딩을 UTF-8로 설정합니다.
		request.setCharacterEncoding("utf-8");
		
		// 요청에서 "bcode", "subject", "content", "writer" 매개변수를 가져옵니다.
		int bcode = Integer.parseInt(request.getParameter("bcode"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		String fileName = null;
		String dir = null;
		
		String contentType = request.getContentType();
		System.out.println(contentType);
		if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
			// 파일 업로드 디렉토리를 설정합니다.
			dir = request.getServletContext().getRealPath("/uploadfiles");
			System.out.println(dir);
		}
		
		// 폴더가 만들어지지 않은 경우 폴더를 생성합니다.
		File f = new File(dir);
		if (!f.exists()) {
			f.mkdir();
		}
		
		Collection<Part> parts = request.getParts();
		for (Part p : parts) {
			System.out.println("p name = " + p.getName());
			if (p.getHeader("Content-Disposition").contains("filename=")) {
				if (p.getSize() > 0) {
					fileName = p.getSubmittedFileName();
					String filePath = dir + File.separator + fileName;
					p.write(filePath);
					p.delete();
				}
			}
		}
		
		// 게시물 정보를 업데이트하기 위한 BoardDto 객체를 생성합니다.
		BoardDto dto = new BoardDto(bcode, subject, content, writer, null, fileName);
		BoardDao dao = new BoardDao();
		
		// BoardDao의 update 메소드를 호출하여 게시물 정보를 업데이트합니다.
		dao.update(dto);		
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
