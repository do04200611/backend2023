package cs.dit.board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {

    private Connection getConnection() throws Exception {
        // 데이터베이스 연결을 얻어오는 메소드입니다.
        InitialContext intCtv = new InitialContext();
        DataSource ds = (DataSource) intCtv.lookup("java:comp/env/jdbc/gh");
        Connection con = ds.getConnection();
        return con;
    }

    // 게시물을 추가하는 메소드입니다.
    public void insert(BoardDto dto) {
        String sql = "INSERT INTO board(SUBJECT, CONTENT, WRITER, FILENAME) VALUES(?, ?, ?, ?)";

        try (
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1, dto.getSubject());
            pstmt.setString(2, dto.getContent());
            pstmt.setString(3, dto.getWriter());
            pstmt.setString(4, dto.getFileName());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 게시물 목록을 가져오는 메소드입니다.
    public ArrayList<BoardDto> list(int p, int numOfRecords) {
        String sql = "SELECT BCODE, SUBJECT, CONTENT, WRITER, REGDATE, FILENAME FROM board ORDER BY BCODE DESC LIMIT ?, ?";
        ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();

        try (Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setInt(1, (p - 1) * numOfRecords);
            pstmt.setInt(2, numOfRecords);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int bcode = rs.getInt("bcode");
                String subject = rs.getString("subject");
                String content = rs.getString("content");
                String writer = rs.getString("writer");
                Date regDate = rs.getDate("regDate");
                String fileName = rs.getString("fileName");

                BoardDto dto = new BoardDto(bcode, subject, content, writer, regDate, fileName);
                dtos.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtos;
    }

    // 특정 게시물을 가져오는 메소드입니다.
    public BoardDto selectOne(int bcode) {
        String sql = "SELECT * FROM board WHERE bcode=?";
        BoardDto dto = new BoardDto();

        try (Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setInt(1, bcode);

            try (ResultSet rs = pstmt.executeQuery();) {
                rs.next();

                dto.setBcode(bcode);
                dto.setSubject(rs.getString("subject"));
                dto.setContent(rs.getString("content"));
                dto.setWriter(rs.getString("writer"));
                dto.setRegDate(rs.getDate("regDate"));
                dto.setFileName(rs.getString("fileName"));

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    // 게시물을 수정하는 메소드입니다.
    public BoardDto update(BoardDto dto) {
        String sql = "UPDATE board SET subject = ?, content = ?, writer = ?, fileName = ? WHERE bcode =?";

        try (
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1, dto.getSubject());
            pstmt.setString(2, dto.getContent());
            pstmt.setString(3, dto.getWriter());
            pstmt.setString(4, dto.getFileName());
            pstmt.setInt(5, dto.getBcode());

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    // 게시물을 삭제하는 메소드입니다.
    public void delete(int bcode) {
        String sql = "DELETE FROM board WHERE bcode =?";

        try (
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setInt(1, bcode);

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 게시물 레코드 개수를 반환하는 메소드입니다.
    public int recordCount() {
        int count = 0;

        String sql = "SELECT COUNT(BCODE) FROM board";

        try (Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            if (rs.next())
                count = rs.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
