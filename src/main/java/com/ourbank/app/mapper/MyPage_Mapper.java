package com.ourbank.app.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ourbank.app.bean.DepositBoard_Bean;
import com.ourbank.app.bean.UserBoard_Bean;
import com.ourbank.app.bean.FreeBoard_Bean;

@Repository
public interface MyPage_Mapper {

	final String SELECT_MY_INFO="select * from tlb_user_board where id=#{id}";
	
	@Select(SELECT_MY_INFO)
	@Results(value= {
			@Result(property="id",column="id"),
			@Result(property="passwd",column="passwd"),
			@Result(property = "user_name", column = "user_name"),
			@Result(property = "user_birth",column = "user_birth"),
			@Result(property = "user_phone",column = "user_phone"),
			@Result(property = "user_address",column = "user_address"),
			@Result(property = "user_email",column = "user_email")
		})
		UserBoard_Bean selectMyInfo(@Param("id") String id);
	
	final String UPDATE_MY_INFO="update tlb_user_board set passwd=#{passwd},"
			+ " user_name=#{user_name}, user_birth=#{user_birth}, user_phone=#{user_phone},"
			+ " user_address=#{user_address}, user_email=#{user_email} where id=#{id}";
	
	@Update(UPDATE_MY_INFO)
	void updateMyInfo(@Param("passwd") String passwd, @Param("user_name") String user_name,
			@Param("user_birth") String user_birth, @Param("user_phone") String user_phone,
			@Param("user_address") String user_address, @Param("user_email") String user_email,
			@Param("id") String id);
	
	//���� ����
	final String DELETE_ID="delete from tlb_user_board where id=#{id}";
	
	@Delete(DELETE_ID)
	void deleteId(@Param("id") String id);
	
	//���� ���� - ����Ʈ
	final String SELECT_MY_BOARDLIST =
			"select * from (select board_idx, id, subject, content, created_date, hits, filename, "
					+ "ceil(rownum / #{rowsPerPage}) as page "
					+ "from (select * from myboardview order by created_date desc))"
					+ "where page=#{page}";
			
	@Select(SELECT_MY_BOARDLIST)
	@Results(value = {
			@Result(property = "board_idx", column = "board_idx"),
			@Result(property = "id", column = "id"), 
			@Result(property = "subject", column = "subject"), 
			@Result(property = "created_date", column = "created_date"),
			@Result(property = "hits", column = "hits"), 
			@Result(property = "step", column = "step"),
			@Result(property = "ref", column = "ref")
	})
	ArrayList<FreeBoard_Bean> getBoardList(@Param("id") String id, @Param("page") int page,@Param("rowsPerPage") int rowsPerPage);
	
	//������ �� -�ۺ���
	final String SELECT_MY_BOARDVIEW =
			"select * from myboardview where board_idx=#{board_idx}";
	@Select(SELECT_MY_BOARDVIEW)
	@Results(value= {
			@Result(property = "board_idx",column="board_idx"),
			@Result(property="subject",column="subject"),
			@Result(property = "id",column="id"),
			@Result(property="created_date",column="created_date"),
			@Result(property="content",column="content"),
			@Result(property = "hits", column="hits"),
			@Result(property = "filename", column="filename")
	})
	FreeBoard_Bean getSpecificRow(@Param("board_idx") int board_idx);
	
	
	
	

}