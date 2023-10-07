package cs.dit.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 파일 업로드 설정을 위한 어노테이션을 사용합니다.
@MultipartConfig(
    maxFileSize = 1024 * 1024 * 5,  // 최대 파일 크기는 5MB로 제한됩니다.
    maxRequestSize = 1024 * 1024 * 50  // 최대 요청 크기는 50MB로 제한됩니다.
)

@WebServlet("*.do") // 확장자가 .do로 끝나는 URL 패턴을 처리하는 서블릿입니다.
public class BoardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI(); // 현재 요청의 URI를 가져옵니다.

        String viewPage = null; // 뷰 페이지 경로를 초기화합니다.

        // URI에서 커맨드 부분을 추출합니다.
        String com = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf(".do"));
        System.out.println(com);

        // 커맨드에 따라 작업을 분기합니다.
        if (com != null && com.trim().equals("list")) {
            // 게시물 목록을 가져오는 서비스를 실행합니다.
            BoardService service = new BListService();
            service.execute(request, response);
            viewPage = "/WEB-INF/view/list.jsp"; // 목록을 보여줄 JSP 페이지 경로를 설정합니다.
        } else if (com != null && com.trim().equals("insertForm")) {
            viewPage = "/WEB-INF/view/insertForm.jsp"; // 게시물 입력 폼을 보여줄 JSP 페이지 경로를 설정합니다.
        } else if (com != null && com.trim().equals("insert")) {
            // 게시물을 입력하는 서비스를 실행합니다.
            BoardService service = new BInsertService();
            service.execute(request, response);
            System.out.println("insert로 요청");
            viewPage = "/WEB-INF/view/list.do"; // 목록 페이지로 리다이렉트합니다.
        } else if (com != null && com.trim().equals("updateForm")) {
            // 게시물 수정 폼을 보여주는 서비스를 실행합니다.
            BoardService service = new BSelectOneService();
            service.execute(request, response);
            viewPage = "/WEB-INF/view/updateForm.jsp"; // 수정 폼을 보여줄 JSP 페이지 경로를 설정합니다.
        } else if (com != null && com.trim().equals("update")) {
            // 게시물을 수정하는 서비스를 실행합니다.
            BoardService service = new BUpdateService();
            service.execute(request, response);
            viewPage = "/WEB-INF/view/list.do"; // 목록 페이지로 리다이렉트합니다.
        }
        // delete
        else if (com != null && com.trim().equals("delete")) {
            // 게시물을 삭제하는 서비스를 실행합니다.
            BoardService service = new BDeleteService();
            service.execute(request, response);
            viewPage = "/WEB-INF/view/list.do"; // 목록 페이지로 리다이렉트합니다.
        } else if (com != null && com.trim().equals("index")) {
            viewPage = "/WEB-INF/view/index.jsp"; // 인덱스 페이지를 보여줄 JSP 페이지 경로를 설정합니다.
        }

        // 뷰 페이지로 포워드합니다.
        RequestDispatcher rd = request.getRequestDispatcher(viewPage);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
