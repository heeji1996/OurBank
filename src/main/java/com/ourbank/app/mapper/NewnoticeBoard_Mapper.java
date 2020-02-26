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

import com.ourbank.app.bean.NewnoticeBoard_Bean;


@Repository
public interface NewnoticeBoard_Mapper {
	
	//�� �Է� ó��
	final String INSERT=
			"insert into newnotice_board(board_idx, best_idx, idx, id, subject, created_date, newnotice_case, "
					+"content, filename, filesize, step, ref, depth) "
					+"values (board_seq_idx.nextval, best_seq_idx.nextval, newnotice_seq.nextval,#{id},#{subject},SYSDATE, #{newnotice_case}, " 
					+"#{content},#{filename},#{filesize}, #{step}, #{ref}, #{depth})";	
	@Insert(INSERT)
	void insertBoard(NewnoticeBoard_Bean boardBean);
	
	//����Ʈ ���
	final String SELECT_PAGE =
			"SELECT * FROM (SELECT idx, SUBJECT, ID, CREATED_DATE, CONTENT, HITS, "
					+"step, ref, depth, ceil(rownum/ #{rowsPerPage}) as page "
					+"FROM (select * from newnotice_board ORDER BY ref desc, step asc)) "
					+"WHERE page=#{page}" ;
	@Select(SELECT_PAGE)
	@Results(value= {
			@Result(property = "id", column = "id"), 
			@Result(property = "idx", column = "idx"), 
			@Result(property = "subject", column = "subject"), 
			@Result(property = "content", column = "content"),
			@Result(property = "created_date", column = "created_date"),
			@Result(property = "hits", column = "hits"), 
			@Result(property = "filename", column = "filename"), 
			@Result(property = "step", column = "step"),
			@Result(property = "ref", column = "ref"), 
			@Result(property = "depth", column = "depth")
	})
	ArrayList<NewnoticeBoard_Bean>getList(@Param("page") int page,@Param("rowsPerPage") int rowsPerPage);
	// ���ະ���� �۰���
		final String SELECT_BANK_NOTICE_CNT = 
				"select count(1) from newnotice_board where newnotice_case='���ະ����'";
		@Select(SELECT_BANK_NOTICE_CNT)
		int getBankNoticeCnt();
		// ���ະ���� �Ѹ���
		final String SELECT_BANK_NOTICE_PAGE = 
				"SELECT * FROM (SELECT idx, SUBJECT, ID, CREATED_DATE, "
				+"CONTENT, HITS, ceil(rownum/ #{rowsPerPage}) as page " 
				+"FROM newnotice_BOARD WHERE newnotice_case='���ະ����' "
				+"ORDER BY CREATED_DATE DESC) WHERE page=#{page}";
		@Select(SELECT_BANK_NOTICE_PAGE)
		@Results(value = { 
				@Result(property = "idx", column = "idx"), 
				@Result(property = "subject", column = "subject"),
				@Result(property = "id", column = "id"), 
				@Result(property = "created_date", column = "created_date"),
				@Result(property = "content", column = "content"),
				@Result(property = "hits", column = "hits") })
		ArrayList<NewnoticeBoard_Bean> getBankNoticeList(@Param("page") int page, @Param("rowsPerPage") int rowsPerPage);

		// ��ǰ������ �۰���
		final String SELECT_PRODUCT_NOTICE_CNT = 
				"select count(1) from newnotice_board where newnotice_case='��ǰ������'";
		@Select(SELECT_PRODUCT_NOTICE_CNT)
		int getProductNoticeCnt();

		// ��ǰ������ ����Ʈ �Ѹ���
		final String SELECT_PRODUCT_NOTICE_PAGE = 
				"SELECT * FROM (SELECT idx, SUBJECT, ID, CREATED_DATE,"
				+ " CONTENT, HITS, ceil(rownum/ #{rowsPerPage}) as page" 
				+ " FROM newnotice_BOARD WHERE newnotice_case='��ǰ������' "
				+ " ORDER BY CREATED_DATE DESC) WHERE page=#{page}";
		@Select(SELECT_PRODUCT_NOTICE_PAGE)
		@Results(value = { 
				@Result(property = "idx", column = "idx"), 
				@Result(property = "subject", column = "subject"),
				@Result(property = "id", column = "id"), 
				@Result(property = "created_date", column = "created_date"),
				@Result(property = "content", column = "content"), 
				@Result(property = "hits", column = "hits") })
		ArrayList<NewnoticeBoard_Bean> getProductNoticeList(@Param("page") int page, @Param("rowsPerPage") int rowsPerPage);

		// ��Ÿ���� �۰���
			final String SELECT_ETC_CNT = 
					"select count(1) from newnotice_board where newnotice_case='��Ÿ����'";
			@Select(SELECT_ETC_CNT)
			int getEtcCnt();
		// ��Ÿ���� ����Ʈ �Ѹ���
			final String SELECT_ETC_PAGE = 
					"SELECT * FROM (SELECT idx, SUBJECT, ID, CREATED_DATE,"
					+ " CONTENT, HITS, ceil(rownum/ #{rowsPerPage}) as page" 
					+ " FROM newnotice_BOARD WHERE newnotice_case='��Ÿ����' "
					+ " ORDER BY CREATED_DATE DESC) WHERE page=#{page}";
			@Select(SELECT_ETC_PAGE)
			@Results(value = { 
					@Result(property = "idx", column = "idx"), 
					@Result(property = "subject", column = "subject"),
					@Result(property = "id", column = "id"),
					@Result(property = "created_date", column = "created_date"),
					@Result(property = "content", column = "content"), 
					@Result(property = "hits", column = "hits") })
			ArrayList<NewnoticeBoard_Bean> getEtcList(@Param("page") int page, @Param("rowsPerPage") int rowsPerPage);


	//��ü�� ��
	final String SELECT_CNT_ALL =
			"select count(1) from newnotice_board";
	@Select(SELECT_CNT_ALL)
	int getTotalCnt();
	
	//��ȸ�� ����
	final String UPDATE_HITS="update newnotice_board set hits=#{hits}+1 where idx=#{idx}";
	@Update(UPDATE_HITS)
	void updateHits(@Param("hits") int hits, @Param("idx") int idx);
	
	
	//�ۺ���-�ۺ��⿡ �Ѹ� bean ��������: idx, subject, id, created_date, content, hits, filename
	final String SELECT_BY_ID=
			"select idx, subject, id, created_date, content, hits, filename,"
			+ " newnotice_case, depth "
			+ " from newnotice_board where idx=#{idx}";
	@Select(SELECT_BY_ID)
	//				output
	@Results(value= {
			@Result(property = "idx",column="idx"),
			@Result(property="subject",column="subject"),
			@Result(property = "id",column="id"),
			@Result(property="created_date",column="created_date"),
			@Result(property="content",column="content"),
			@Result(property = "hits", column="hits"),
			@Result(property = "filename", column="filename"),
			@Result(property = "newnotice_case", column="newnotice_case"),
			@Result(property = "depth", column="depth")
	})
	//						input
	NewnoticeBoard_Bean getSpecificRow(@Param("idx") int idx);
	
	//�� ����
	final String UPDATE_BY_ID=
			"update newnotice_board set subject = #{subject}, "
			+ "content=#{content}, filename=#{filename}, filesize=#{filesize}"
			+ "where idx=#{idx}";
	@Update(UPDATE_BY_ID)
	void updateBoard(@Param("idx") int idx, @Param("subject") String subject,
			@Param("content") String content, @Param("filename") String filename, 
			@Param("filesize") long filesize);
	
	//�� ����
	final String DELETE_BY_ID="delete from newnotice_board where idx=#{idx}";
	@Delete(DELETE_BY_ID)
	void deleteSpecificRow(@Param("idx") int idx);
	
	//�˻��� �� ��
	final String SELECT_CNT_BY_SUBJECT="select count(1) from newnotice_board where "
			+ " subject like '%'||'${searchThis}'||'%'";
	
	@Select(SELECT_CNT_BY_SUBJECT)
	int getTotalCntBySubject(@Param("searchThis") String includingThis);

	//�۰˻�
	final String SELECT_ROWS_BY_SUBJECT=
		"SELECT * FROM (SELECT idx, SUBJECT, ID, CREATED_DATE,"
					+ " CONTENT, HITS, ceil(rownum/ #{rowsPerPage}) as page"
					+ " FROM newnotice_board WHERE SUBJECT LIKE '%'||'${likeThis}'||'%' "
					+ " ORDER BY CREATED_DATE DESC) WHERE page=#{page}";
			
	@Select(SELECT_ROWS_BY_SUBJECT)
	@Results(value= {
			@Result(property="idx",column="idx"),
			@Result(property ="subject", column="subject"),
			@Result(property="id", column="id"),
			@Result(property = "created_date",column = "created_date"),
			@Result(property = "content",column="content"),
			@Result(property = "hits",column = "hits")
	})
	public ArrayList<NewnoticeBoard_Bean> getSearchedList(
			@Param("page") int page,
			@Param("rowsPerPage") int rowsPerPage,
			@Param("likeThis") String likeThis);
	
	////////////////////�亯�� �Խ���/////////////////////////////
	//idx���� ������Ʈ �մϴ�.
	final String UPDATE_RE_WRITE=
			"update newnotice_board set ref=#{idx} where idx=#{idx}";
	@Select(UPDATE_RE_WRITE)
	void updateRewrite(@Param("idx") int idx);
	
	//���� �ֱٱ��� �����ɴϴ�.
	final String RECENT_ID=
			"select max(idx) from newnotice_board";
	@Select(RECENT_ID)
	int recentID();

	// ���̵�� id, ref,step,depth,subject�� ����մϴ�.
	final String SELECT_STAIR_BOARD=
			"select idx, ref, step, depth, subject from newnotice_board where idx=#{idx}";
	@Select(SELECT_STAIR_BOARD)
	NewnoticeBoard_Bean stairBoard(@Param("idx") int idx);
	
	//�׷� step �� ������Ű�� ���� ���Ǻ��� ū �ֵ� �� +1���ݴϴ�.
	final String UPDATE_GROUP_STEP=
			"update newnotice_board set step=step+1 where ref=#{ref} and step>#{step}";
	@Update(UPDATE_GROUP_STEP)
	void updateGroupStep(@Param("ref") int ref, @Param("step") int step);
	
}
	
	