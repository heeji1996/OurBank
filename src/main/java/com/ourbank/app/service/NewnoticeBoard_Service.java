package com.ourbank.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ourbank.app.mapper.NewnoticeBoard_Mapper;
import com.ourbank.app.bean.NewnoticeBoard_Bean;
import com.ourbank.app.bean.NewsBoard_Bean;
import com.ourbank.app.bean.ReviewBoard_Bean;

@Component
public class NewnoticeBoard_Service {
	@Autowired
	private NewnoticeBoard_Mapper boardMapper;
	
	//���Է� ó��
	public void insertBoard(NewnoticeBoard_Bean boardBean) {
		boardMapper.insertBoard(boardBean);
	}
	
	//��ü�� ��
	public int getTotalCnt() {
		int nCnt=0;
		nCnt=this.boardMapper.getTotalCnt();
		return nCnt;
	}
	
	//List�� �Ѹ� arraylist ����
		public ArrayList<NewnoticeBoard_Bean> getList(int nStartPage, int list_num){
			return this.boardMapper.getList(nStartPage, list_num);
		}
		//���ະ���� �ۼ�
		public int getBankNoticeCnt() {
			int nCnt=0;
			nCnt=this.boardMapper.getBankNoticeCnt();
			return nCnt;
		}
		//���ະ���� arraylist
		public ArrayList<NewnoticeBoard_Bean> getBankNoticeList(int nStartPage, int list_num){
			return this.boardMapper.getBankNoticeList(nStartPage, list_num);
		}
		//��ǰ������
		public int getProductNoticeCnt() {
			int nCnt=0;
			nCnt=this.boardMapper.getProductNoticeCnt();
			return nCnt;
		}
		//��ǰ������ arraylist
		public ArrayList<NewnoticeBoard_Bean> getProductNoticeList(int nStartPage, int list_num){
			return this.boardMapper.getProductNoticeList(nStartPage, list_num);
		}
		//��Ÿ
		public int getEtcCnt() {
			int nCnt=0;
			nCnt=this.boardMapper.getEtcCnt();
			return nCnt;
		}
		//��Ÿ arraylist
		public ArrayList<NewnoticeBoard_Bean> getEtcList(int nStartPage, int list_num){
			return this.boardMapper.getEtcList(nStartPage, list_num);
		}
	

	
	//��ȸ�� �ø���
	public void updateHits(int hits, int idx) {
		System.out.println("��ȸ�� �ö�");
		this.boardMapper.updateHits(hits, idx);
	}
	
	//�ۺ��⿡ �Ѹ� bean
	public NewnoticeBoard_Bean getSpecificRow(int idx) {
		return this.boardMapper.getSpecificRow(idx);//-getSpecificRow(@Param("id") String id): return id, subject, name, created_date, mail, memo, hits
	}
	
	//�� ����
	public void updateBoard(NewnoticeBoard_Bean boardBean) {
		boardMapper.updateBoard(boardBean.getIdx(), boardBean.getSubject(), 
				boardBean.getContent(), boardBean.getFilename(), boardBean.getFilesize());
	}
	
	//�� ����
	public void deleteRow(int idx) {
		this.boardMapper.deleteSpecificRow(idx);
	}
	
	//�˻��� �� ��
	public int getTotalCntBySubject(String search) {
		int nCnt=0;
		nCnt=this.boardMapper.getTotalCntBySubject(search);
		return nCnt;
	}
	
	//�˻��ϱ� -> ArrayList�� ���
	public ArrayList<NewnoticeBoard_Bean> getSearchedList(int nStartPage, int list_num, String strSearchThis){
		return this.boardMapper.getSearchedList(nStartPage, list_num, strSearchThis);
	}
	
	//���
	public void updateRewrite(int idx) {
		boardMapper.updateRewrite(idx);
	}
	public int recentID() {
		int recent_id=0;
		recent_id=this.boardMapper.recentID();
		return recent_id;
	}
	public NewnoticeBoard_Bean stairBoard(int idx) {
		return this.boardMapper.stairBoard(idx);
	}
	public void updateGroupStep(int ref, int step) {
		this.boardMapper.updateGroupStep(ref, step);
	}
	
	
}
