package org.zerock.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.zerock.command.BoardVO;
import org.zerock.dao.BoardDAO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	//DB로 가정할 리스트
	//List<BoardVO> DB = new ArrayList<>();
	// =
	//템플릿을 불러와서 구현
	@Autowired
	JdbcTemplate jdbcTemplate;
	//table 생성

	@Override
	public void boardInsert(String name, String title, String content) {
		System.out.println("-------- DAO 계층 --------");
		System.out.println(name);
		System.out.println(title);
		System.out.println(content);
		
//		BoardVO vo = new BoardVO();
//		vo.setName(name);
//		vo.setTitle(title);
//		vo.setContent(content);
//		
//		DB.add(vo);
		//System.out.println("현재 게시글 수 : "+DB.size());

		//쿼리로 사용할 sql 작성
		String sql = "insert into board01(num, name, title, content) "
				+ "values(board01_seq.nextval, ?, ?, ?)";
		
		//템플릿 사용법 2가지
		//1st.
//		int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setString(1, name);
//				ps.setString(2, title);
//				ps.setString(3, content);
//			}
//		});
		
		//2nd.
		int result = jdbcTemplate.update(sql, new Object[] {name, title, content});
		
		if(result ==1) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
	}

	@Override
	public List<BoardVO> boartSelect() {
		/*
		 * query()의 파라미터의 의미
		 * sql : sql 쿼리. ?를 사용하는 preparedStatement용 쿼리
		 * new Object[] {값, 값} : sql의 ?에 대한 세팅 값을 저장(바인딩)
		 * new RowMapper<Type>() : 조회 결과를 ResultSet에 저장. 
		 * 						ResultSet으로부터 데이터를 읽어와서 Type 데이터를 생성
		 * 						-> 익명 클래스로 동장, mapRow() 메서드에서 ResultSet에서 읽어온 값을 처리 후 리턴
		 */
		
		String sql = "select * from board01 order by num desc";
		//1st
//		List<BoardVO> list = jdbcTemplate.query(sql, new PreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				//sql의 slect 명령에 ps에 넣을 것이 없으므로 비워둔다.
//			}
//		}, new RowMapper<BoardVO>() {
//			@Override
//			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				BoardVO vo = new BoardVO();
//				vo.setNum(rs.getInt("num"));
//				vo.setName(rs.getString("name"));
//				vo.setTitle(rs.getString("title"));
//				vo.setContent(rs.getString("content"));
//				
//				return vo;
//			}
//		});
		
		//2nd
		//개선을 할 예정이라서 노란색 밑줄이 생김
		List<BoardVO> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				
				return vo;
			}
		});	
//		return DB;
		return list;
	}

	@Override
	public void boardDelete(String num) {
//		DB.remove(Integer.parseInt(num));
		System.out.println("지울 번호 : "+num);
		String sql = "delete from board01 where num=?";
		int result = jdbcTemplate.update(sql, new Object[] {num});
		
		if(result ==1) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}		
	}

}
