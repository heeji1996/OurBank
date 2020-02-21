package com.ourbank.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.ourbank.app.bean.ReviewBoard_Bean;
import com.ourbank.app.mapper.ReviewBoard_Mapper;

@Component
public class ReviewBoard_Service {
	@Autowired
	private ReviewBoard_Mapper boardMapper;
	
	//���Է� ó��
	public void insertBoard(ReviewBoard_Bean boardBean) {
		boardMapper.insertBoard(boardBean);	
		};

	// ��ȸ�� �ø���
	public void updateHits(int hits, int idx) {
		System.out.println("��ȸ�� �ö�");
		this.boardMapper.updateHits(hits, idx);
	}

	//��ü�ۼ�
	public int getTotalCnt() {
		int nCnt=0;
		nCnt=this.boardMapper.getTotalCnt();
		return nCnt;
	}

	//List�� �Ѹ� arraylist ����
	public ArrayList<ReviewBoard_Bean> getList(int nStartPage, int list_num){
		return this.boardMapper.getList(nStartPage, list_num);
	}
	//ȸ������ �ۼ�
	public int getSignUpCnt() {
		int nCnt=0;
		nCnt=this.boardMapper.getSignUpCnt();
		return nCnt;
	}
	//ȸ������ arraylist
	public ArrayList<ReviewBoard_Bean> getSignUpList(int nStartPage, int list_num){
		return this.boardMapper.getSignUpList(nStartPage, list_num);
	}
	//������
	public int getSavingsCnt() {
		int nCnt=0;
		nCnt=this.boardMapper.getSavingsCnt();
		return nCnt;
	}
	//������ arraylist
	public ArrayList<ReviewBoard_Bean> getSavingsList(int nStartPage, int list_num){
		return this.boardMapper.getSavingsList(nStartPage, list_num);
	}
	//��Ÿ
	public int getEtcCnt() {
		int nCnt=0;
		nCnt=this.boardMapper.getEtcCnt();
		return nCnt;
	}
	//��Ÿ arraylist
	public ArrayList<ReviewBoard_Bean> getEtcList(int nStartPage, int list_num){
		return this.boardMapper.getEtcList(nStartPage, list_num);
	}
	
	//�ۺ��⿡ �Ѹ� bean
	public ReviewBoard_Bean getSpecificRow(int idx) {
		return this.boardMapper.getSpecificRow(idx);//-getSpecificRow(@Param("id") String id): return id, subject, name, created_date, mail, memo, hits
	}
	
	//�� �����ϱ�
	public void updateBoard(ReviewBoard_Bean boardBean) {
		boardMapper.updateBoard(boardBean.getIdx(), boardBean.getSubject(), 
				boardBean.getReview_case(), boardBean.getContent(),
				boardBean.getSatisfaction(), boardBean.getBanks(), boardBean.getRe_productname());
	}
	//�ۻ����ϱ�
	public void deleteRow(int idx) {
		this.boardMapper.deleteSpecificRow(idx);
	}
	//�˻��� �� ��
	public int getTotalCntBySubject(String search) {
		int nCnt=0;
		nCnt=this.boardMapper.getTotalCntBySubject(search);
		return nCnt;
	}
	//�˻��ϱ� => ArrayList �� ��� 
	public ArrayList<ReviewBoard_Bean> getSearchedList(int nStartPage, int list_num, String strSearchThis){
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
	public ReviewBoard_Bean stairBoard(int idx) {
		return this.boardMapper.stairBoard(idx);
	}
	public void updateGroupStep(int ref, int step) {
		this.boardMapper.updateGroupStep(ref, step);
	}
	
	// �������� ��������
	public String ReviewCase(int ref) {
		return this.boardMapper.ReviewCase(ref);
	}
	
	//���-������ �Ϻ� �� �ֱ�
	public String Satisfaction(int ref) {
		return this.boardMapper.Satisfaction(ref);
	}
	
	public String Banks(int ref) {
		return this.boardMapper.Banks(ref);
	}
	
	public String Re_productname(int ref) {
		return this.boardMapper.Re_productname(ref);
	}

	

}
