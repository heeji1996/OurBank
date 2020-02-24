package com.ourbank.app.mapper;


import java.util.ArrayList;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.ourbank.app.bean.InvestBoard_Bean;

@Repository
public interface InvestBoard_Mapper {
	//���Է�ó��
		final String INSERT=
				"insert into invest_board(board_idx, best_idx, id_x, id, subject, created_date, invest_case, "
				+"content, filename, filesize, step, ref, depth) "
				+"values (board_seq_idx.nextval, best_seq_idx.nextval, invest_seq.nextval,#{id},#{subject},SYSDATE, #{invest_case}, " 
				+"#{content},#{filename},#{filesize}, #{step}, #{ref}, #{depth})";	
		@Insert(INSERT)
		void insertBoard(InvestBoard_Bean boardBean);
		
		//��ü �۰���
		final String SELECT_CNT_ALL="select count(1) from invest_board";
		
		@Select(SELECT_CNT_ALL)
		int getTotalCnt();
		
		//��ȸ�� ����
		final String UPDATE_HITS="update invest_board set hits=#{hits}+1 where id_x=#{idx}";
		
		@Update(UPDATE_HITS)
		void updateHits(@Param("hits") int hits, @Param("idx") int idx);
		
		//����Ʈ �Ѹ���
		final String SELECT_PAGE=
				"SELECT * FROM (SELECT ID_X, SUBJECT, ID, CREATED_DATE, CONTENT, HITS, "
				+"step, ref, depth, ceil(rownum/ #{rowsPerPage}) as page "
				+"FROM (select * from invest_board ORDER BY ref desc, step asc)) "
				+"WHERE page=#{page}" ;
		
		@Select(SELECT_PAGE)
		@Results(value= {
				@Result(property="idx",column="id_x"),
				@Result(property = "id", column = "id"),
				@Result(property = "subject",column = "subject"),
				@Result(property = "content",column = "content"),
				@Result(property = "created_date",column = "created_date"),
				@Result(property = "hits",column = "hits"),
				@Result(property = "step", column = "step"),
				@Result(property = "ref", column = "ref"), 
				@Result(property = "depth", column = "depth")
		})
		ArrayList<InvestBoard_Bean>getList(@Param("page") int page,
				@Param("rowsPerPage") int rowsPerPage);
	
	//�׸� ����Ʈ ��� �Ѹ���
	// ������� �۰���
	final String SELECT_SUCCESS_CNT = 
			"select count(1) from invest_board where invest_case='�������'";
	@Select(SELECT_SUCCESS_CNT)
	int getSuccessCnt();
	// ������� ����Ʈ �Ѹ���
	final String SELECT_SUCCESS_PAGE = 
			"SELECT * FROM (SELECT ID_X, SUBJECT, ID, CREATED_DATE,"
			+ " CONTENT, HITS, ceil(rownum/ #{rowsPerPage}) as page" 
			+ " FROM invest_BOARD WHERE invest_case='�������' "
			+ " ORDER BY CREATED_DATE DESC) WHERE page=#{page}";
	@Select(SELECT_SUCCESS_PAGE)
	@Results(value = { 
			@Result(property = "idx", column = "id_x"), 
			@Result(property = "subject", column = "subject"),
			@Result(property = "id", column = "id"), 
			@Result(property = "created_date", column = "created_date"),
			@Result(property = "content", column = "content"), 
			@Result(property = "hits", column = "hits") })
	ArrayList<InvestBoard_Bean> getSuccessList(@Param("page") int page, @Param("rowsPerPage") int rowsPerPage);

	// ������ �� ����
	final String SELECT_FAIL_CNT = "select count(1) from invest_board where invest_case='���л��'";
	@Select(SELECT_FAIL_CNT)
	int getFailCnt();
	// ������ ����Ʈ �Ѹ���
	final String SELECT_FAIL_PAGE = 
			"SELECT * FROM (SELECT ID_X, SUBJECT, ID, CREATED_DATE,"
			+ " CONTENT, HITS, ceil(rownum/ #{rowsPerPage}) as page" 
			+ " FROM invest_BOARD WHERE invest_case='���л��' "
			+ " ORDER BY CREATED_DATE DESC) WHERE page=#{page}";
	@Select(SELECT_FAIL_PAGE)
	@Results(value = { 
			@Result(property = "idx", column = "id_x"), 
			@Result(property = "subject", column = "subject"),
			@Result(property = "id", column = "id"), 
			@Result(property = "created_date", column = "created_date"),
			@Result(property = "content", column = "content"), 
			@Result(property = "hits", column = "hits") })
	ArrayList<InvestBoard_Bean> getFailList(@Param("page") int page, @Param("rowsPerPage") int rowsPerPage);

	// ��Ÿ �� ����
		final String SELECT_ETC_CNT = 
				"select count(1) from invest_board where invest_case='��Ÿ'";
		@Select(SELECT_ETC_CNT)
		int getEtcCnt();
		// ��Ÿ ����Ʈ �Ѹ���
		final String SELECT_ETC_PAGE = 
				"SELECT * FROM (SELECT ID_X, SUBJECT, ID, CREATED_DATE,"
				+ " CONTENT, HITS, ceil(rownum/ #{rowsPerPage}) as page" 
				+ " FROM invest_BOARD WHERE invest_case='��Ÿ' "
				+ " ORDER BY CREATED_DATE DESC) WHERE page=#{page}";
		@Select(SELECT_ETC_PAGE)
		@Results(value = { 
				@Result(property = "idx", column = "id_x"), 
				@Result(property = "subject", column = "subject"),
				@Result(property = "id", column = "id"), 
				@Result(property = "created_date", column = "created_date"),
				@Result(property = "content", column = "content"), 
				@Result(property = "hits", column = "hits") })
		ArrayList<InvestBoard_Bean> getEtcList(@Param("page") int page, @Param("rowsPerPage") int rowsPerPage);

		//�ۺ���-�ۺ��⿡ �Ѹ� bean ��������: idx, subject, id, created_date, content, hits, filename
		final String SELECT_BY_ID="select id_x,subject, id, created_date, content, hits, filename, invest_case, depth"
				+ " from invest_board where id_x=#{idx}";
		
		@Select(SELECT_BY_ID)
		//				output
		@Results(value= {
				@Result(property = "idx",column="id_x"),
				@Result(property="subject",column="subject"),
				@Result(property = "id",column="id"),
				@Result(property="created_date",column="created_date"),
				@Result(property="content",column="content"),
				@Result(property = "hits", column="hits"),
				@Result(property = "filename", column="filename"),
				@Result(property = "invest_case", column="invest_case"),
				@Result(property = "depth", column="depth")
		})
		//						input
		InvestBoard_Bean getSpecificRow(@Param("idx") int idx);
		
		// ����
		final String UPDATE_BY_ID="update invest_board set subject = #{subject}, invest_case=#{invest_case}, "
				+ " content=#{content} where id_x=#{idx}";
		@Update(UPDATE_BY_ID)
		void updateBoard(@Param("idx") int idx, @Param("subject") String subject,
				@Param("invest_case") String invest_case, @Param("content") String content);
		
		//�� ����
		final String DELETE_BY_ID="delete from invest_board where id_x=#{idx}";
		
		@Delete(DELETE_BY_ID)
		void deleteSpecificRow(@Param("idx") int idx);
		
		// �˻��� �� ��
		final String SELECT_CNT_BY_SUBJECT="select count(1) from invest_board where "
				+ " subject like '%'||'${searchThis}'||'%'";
		
		@Select(SELECT_CNT_BY_SUBJECT)
		int getTotalCntBySubject(@Param("searchThis") String includingThis);

		//�۰˻�
		final String SELECT_ROWS_BY_SUBJECT=
			"SELECT * FROM (SELECT ID_X, SUBJECT, ID, CREATED_DATE,"
						+ " CONTENT, HITS, ceil(rownum/ #{rowsPerPage}) as page"
						+ " FROM invest_BOARD WHERE SUBJECT LIKE '%'||'${likeThis}'||'%' "
						+ " ORDER BY CREATED_DATE DESC) WHERE page=#{page}";
				
		@Select(SELECT_ROWS_BY_SUBJECT)
		@Results(value= {
				@Result(property="idx",column="id_x"),
				@Result(property ="subject", column="subject"),
				@Result(property="id", column="id"),
				@Result(property = "created_date",column = "created_date"),
				@Result(property = "content",column="content"),
				@Result(property = "hits",column = "hits")
		})
		public ArrayList<InvestBoard_Bean> getSearchedList(
				@Param("page") int page,
				@Param("rowsPerPage") int rowsPerPage,
				@Param("likeThis") String likeThis);
		
		
		//////////////////////�亯�� �Խ���/////////////////////////////
		//idx_num���� ������Ʈ �մϴ�.
		final String UPDATE_RE_WRITE=
				"update invest_board set ref=#{idx} where id_x=#{idx}";
		@Select(UPDATE_RE_WRITE)
		void updateRewrite(@Param("idx") int idx);
		
		//���� �ֱٱ��� �����ɴϴ�.
		final String RECENT_ID=
				"select max(id_x) from invest_board";
		@Select(RECENT_ID)
		int recentID();

		// ���̵�� id, ref,step,depth,subject�� ����մϴ�.
		final String SELECT_STAIR_BOARD=
				"select id_x, ref, step, depth, subject, invest_case from invest_board where id_x=#{idx}";
		@Select(SELECT_STAIR_BOARD)
		InvestBoard_Bean stairBoard(@Param("idx") int idx);
		
		//�׷� step �� ������Ű�� ���� ���Ǻ��� ū �ֵ� �� +1���ݴϴ�.
		final String UPDATE_GROUP_STEP=
				"update invest_board set step=step+1 where ref=#{ref} and step>#{step}";
		@Update(UPDATE_GROUP_STEP)
		void updateGroupStep(@Param("ref") int ref, @Param("step") int step);
		
		//
		final String SELECT_INVEST_CASE = 
				"select invest_case from invest_board where ref = #{ref}";
		@Select(SELECT_INVEST_CASE)
		String InvestCase(int ref);
		
		 
	
		
}
