package cs.dit.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JList;

public interface BoardService<BoardAttachVO> {

	public void execute(HttpServletRequest	request, HttpServletResponse response) throws ServletException, IOException;

	/**
	 * @param <FileItem>
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	<FileItem> void execute11(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * @param <FileItem>
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	<FileItem> void execute111(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * @param <FileItem>
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	<FileItem> void execute1111(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * @param <FileItem>
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	<FileItem> void execute1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * @param bno
	 * @return
	 */
	JList<BoardAttachVO> getAttachList(Long bno);
}
