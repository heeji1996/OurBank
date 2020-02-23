package com.ourbank.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ourbank.app.bean.InvestBoard_Bean;
import com.ourbank.app.mapper.InvestBoard_Mapper;

@Component
public class InvestBoard_Service {
	@Autowired
	private InvestBoard_Mapper boardMapper;
	
	//���Է� ó��
	public void insertBoard(InvestBoard_Bean boardBean) {
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

	//�ε���, ����, �ۼ���, ��¥, ����, ��ȸ��  arraylist ����
	public ArrayList<InvestBoard_Bean> getList(int nStartPage, int list_num){
		return this.boardMapper.getList(nStartPage, list_num);
	}
	
	//�׸� �۸��
	//������� �� ��
	public int getSuccessCnt() {
		int nCnt=0;
		nCnt=this.boardMapper.getSuccessCnt();
		return nCnt;
	}
	//�������arraylist
	public ArrayList<InvestBoard_Bean> getSuccessList(int nStartPage, int list_num){
		return this.boardMapper.getSuccessList(nStartPage, list_num);
	}
	
	//������
	public int getFailCnt() {
		int nCnt=0;
		nCnt=this.boardMapper.getFailCnt();
		return nCnt;
	}
	//������ arraylist
	public ArrayList<InvestBoard_Bean> getFailList(int nStartPage, int list_num){
		return this.boardMapper.getFailList(nStartPage, list_num);
	}
	//��Ÿ
	public int getEtcCnt() {
		int nCnt=0;
		nCnt=this.boardMapper.getEtcCnt();
		return nCnt;
	}
	//��Ÿ arraylist
	public ArrayList<InvestBoard_Bean> getEtcList(int nStartPage, int list_num){
		return this.boardMapper.getEtcList(nStartPage, list_num);
	}
	
	//�ۺ��⿡ �Ѹ� bean
	public InvestBoard_Bean getSpecificRow(int idx) {
		return this.boardMapper.getSpecificRow(idx);//-getSpecificRow(@Param("id") String id): return id, subject, name, created_date, mail, memo, hits
	}
	
	//�� �����ϱ�
	public void updateBoard(InvestBoard_Bean boardBean) {
		boardMapper.updateBoard(boardBean.getIdx(), boardBean.getSubject(), 
				boardBean.getInvest_case(), boardBean.getContent());
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
	public ArrayList<InvestBoard_Bean> getSearchedList(int nStartPage, int list_num, String strSearchThis){
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
	public InvestBoard_Bean stairBoard(int idx) {
		return this.boardMapper.stairBoard(idx);
	}
	
	public void updateGroupStep(int ref, int step) {
		this.boardMapper.updateGroupStep(ref, step);
	}

	//�������� ��������
	public String InvestCase(int ref) {
		return this.boardMapper.InvestCase(ref);
	}
	

}
