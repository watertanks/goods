package com.goods.mapper;


import org.apache.ibatis.annotations.Mapper;
import com.goods.vo.*;
import com.goods.vo.LoginInfo;
import com.goods.vo.MemberInfo;
import com.goods.vo.MemberPoint;

/*
@Mapper
public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;

	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public MemberInfo loginProc(LoginInfo li) {
		// 로그인 처리 후 회원정보를 MemberInfo형 인스턴스로 리턴하는 메소드
			String sql = "select * from t_member_info " + 
				" where mi_id = ? and mi_pw = ?";
			MemberInfo loginInfo = null;
			try {
				loginInfo = jdbcTemplate.queryForObject(sql, 
				new RowMapper<MemberInfo>() {
					@Override
					public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
						MemberInfo mem = new MemberInfo(
						rs.getString("mi_id"),rs.getString("mi_pw"),rs.getString("mi_gender"),
						rs.getString("mi_birth"),rs.getString("mi_name"),rs.getString("mi_nickname"),
						rs.getString("mi_email"),rs.getString("mi_phone"),rs.getString("mi_lastlogin"),
						rs.getString("mi_joindate"),rs.getString("mi_status"),rs.getString("mi_kind"),1000,
						0,0);
						
						return mem;
					}
				}, li.getMi_id(), li.getMi_pw());
				// queryForObject()는 반드시 하나의 결과 레코드가 있어야 하며, 
				// 만약 결과 레코드가 없거나, 두 개 이상이면 각각 
				// EmptyResultDataAccessException와 
				// IncorrectResultSizeDataAccessException을 발생시키므로 
				// 사용시 예외처리(try~catch)를 해야 함
			} catch (EmptyResultDataAccessException e) {
				e.printStackTrace();
			}
			return loginInfo;
		}

}
*/


@Mapper
public interface MemberMapper{
	
	public MemberInfo loginProc(LoginInfo li);
	
	public int emailChk(String email);
	
	public MemberInfo kakaoLogin(String email);
	
	public int kakaoJoin(MemberInfo mi);
	
	public int kakaoJoinPoint(MemberPoint mp);
	
	public int nickChk(String unick);
	
	public int idChk(String uid);
	
	public int emailChkJoin(String email);
	
	public int memberIn(MemberInfo mi);
	
	public int memberAddrIn(MemberAddr ma);
	
	public int memberPointIn(MemberPoint mp);
	
	public void memberProcdel();
}


