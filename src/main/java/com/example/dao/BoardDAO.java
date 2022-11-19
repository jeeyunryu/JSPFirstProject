package com.example.dao;

import com.example.bean.BoardVO;
import com.example.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BoardDAO {
	
	static Connection conn = null;
	static PreparedStatement stmt = null;
	static ResultSet rs = null;

	private final String BOARD_INSERT = "insert into playlist (songID, AlbumPhoto, Title, Singer, AlbumTitle, ReleasedDate, Ranking, runningTime, songWriter, lyrics) values (?,?,?,?,?,?,?,?,?,?)"; //-> prepared statement
	private final String BOARD_UPDATE = "update playlist set AlbumPhoto=?, Title=?, Singer=?, AlbumTitle=?, ReleasedDate=?, Ranking=?, runningTime=?, songWriter=?, lyrics=? where songID=?";
	private final String BOARD_DELETE = "delete from playlist  where songID=?";
	private static final String BOARD_GET = "select * from playlist  where songID=?";
	private final String BOARD_LIST = "select * from playlist order by songID desc";

	public static String getPhotoFileName(int id) {
		String filename = null;

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				filename = rs.getString("albumPhoto");
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("===> JDBC로 getPhotoFilename() 기능 처리");
		return filename;
	}

	public int insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection(); //데이타베이스 접속하는 함수
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setInt(1, vo.getSongID());
			stmt.setString(2, vo.getAlbumPhoto());
			stmt.setString(3, vo.getTitle());
			stmt.setString(4, vo.getSinger());
			stmt.setString(5, vo.getAlbumTitle());
			stmt.setString(6, vo.getReleasedDate());
			stmt.setInt(7, vo.getRanking());
			stmt.setString(8, vo.getRunningTime());
			stmt.setString(9, vo.getSongWriter());
			stmt.setString(10, vo.getLyrics());
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 글 삭제
	public void deleteBoard(int id) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);

			stmt.setString(1, vo.getAlbumPhoto());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, vo.getSinger());
			stmt.setString(4, vo.getAlbumTitle());
			stmt.setString(5, vo.getReleasedDate());
			stmt.setInt(6, vo.getRanking());
			stmt.setString(7, vo.getRunningTime());
			stmt.setString(8, vo.getSongWriter());
			stmt.setString(9, vo.getLyrics());
			stmt.setInt(10, vo.getSongID());
			
			
			System.out.println(vo.getAlbumPhoto() + "-" + vo.getTitle() + "-" + vo.getSinger() + "-" + vo.getAlbumTitle() +
			"-" + vo.getReleasedDate() + "-" + vo.getRanking() + "-" + vo.getRunningTime() + "-" + vo.getSongWriter() + "-"
			+ vo.getLyrics() + "-" + vo.getSongID());
			stmt.executeUpdate();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}	
	
	public BoardVO getBoard(int songID) {
		BoardVO one = null;
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, songID);
			rs = stmt.executeQuery();
			if(rs.next()) {
				one = new BoardVO();
				one.setSongID(rs.getInt("songID"));
				one.setAlbumPhoto(rs.getString("AlbumPhoto"));
				one.setTitle(rs.getString("Title"));
				one.setSinger(rs.getString("Singer"));
				one.setAlbumTitle(rs.getString("AlbumTitle"));
				one.setReleasedDate(rs.getString("ReleasedDate"));
				one.setRanking(rs.getInt("Ranking"));
				one.setRunningTime(rs.getString("runningTime"));
				one.setSongWriter(rs.getString("songWriter"));
				one.setLyrics(rs.getString("lyrics"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return one;
	}
	
	public List<BoardVO> getBoardList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO one = new BoardVO();

				one.setSongID(rs.getInt("songID"));
				one.setAlbumPhoto(rs.getString("AlbumPhoto"));
				one.setTitle(rs.getString("Title"));
				one.setSinger(rs.getString("Singer"));
				one.setAlbumTitle(rs.getString("AlbumTitle"));
				one.setReleasedDate(rs.getString("ReleasedDate"));
				one.setRanking(rs.getInt("Ranking"));
				one.setRunningTime(rs.getString("runningTime"));
				one.setSongWriter(rs.getString("songWriter"));
				one.setLyrics(rs.getString("lyrics"));

				list.add(one);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}

}
