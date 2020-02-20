package com.ourbank.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

<<<<<<< HEAD
import com.ourbank.app.mapper.FreeBoard_Mapper;
import com.ourbank.app.bean.FreeBoard_Bean;
=======
import com.ourbank.app.bean.FAQBoard_Bean;
import com.ourbank.app.bean.FreeBoard_Bean;
import com.ourbank.app.mapper.FreeBoard_Mapper;
>>>>>>> f468c823fb38f81388f1f0cd521a2d8766679c8d

@Component
public class FreeBoard_Service {
	@Autowired
	private FreeBoard_Mapper boardMapper;
	
	//���Է� ó��
	public void insertBoard(FreeBoard_Bean boardBean) {
<<<<<<< HEAD
		boardMapper.insertBoard(boardBean);
	}
	
	//��ü�� ��
=======
		boardMapper.insertBoard(boardBean);	
		};

	// ��ȸ�� �ø���
	public void updateHits(int hits, int idx) {
		System.out.println("��ȸ�� �ö�");
		this.boardMapper.updateHits(hits, idx);
	}

	//��ü�ۼ�
>>>>>>> f468c823fb38f81388f1f0cd521a2d8766679c8d
	public int getTotalCnt() {
		int nCnt=0;
		nCnt=this.boardMapper.getTotalCnt();
		return nCnt;
	}

	//�ε���, ����, �ۼ���, ��¥, ����, ��ȸ��  arraylist ����
<<<<<<< HEAD
	public ArrayList<FreeBoard_Bean> getList(int nStartPage, int list_num) {
		return this.boardMapper.getList(nStartPage, list_num);
	}
	
	//��ȸ�� �ø���
	public void updateHits(int hits, int idx_num) {
		System.out.println("��ȸ�� �ö�");
		this.boardMapper.updateHits(hits, idx_num);
	}
	
	//�ۺ��⿡ �Ѹ� bean
	public FreeBoard_Bean getSpecificRow(int idx_num) {
		return this.boardMapper.getSpecificRow(idx_num);//-getSpecificRow(@Param("id") String id): return id, subject, name, created_date, mail, memo, hits
	}
	
	//�� ����
	public void updateBoard(FreeBoard_Bean boardBean) {
		boardMapper.updateBoard(boardBean.getIdx_num(), boardBean.getSubject(), 
				boardBean.getContent(), boardBean.getFilename(), boardBean.getFilesize());
	}
	
	//�� ����
	public void deleteRow(int idx_num) {
		this.boardMapper.deleteSpecificRow(idx_num);
	}
	
=======
	public ArrayList<FreeBoard_Bean> getList(int nStartPage, int list_num){
		return this.boardMapper.getList(nStartPage, list_num);
	}
	//ȸ������ �ۼ�
	public int getSignUpCnt() {
		int nCnt=0;
		nCnt=this.boardMapper.getSignUpCnt();
		return nCnt;
	}
	//ȸ������ arraylist
	public ArrayList<FreeBoard_Bean> getSignUpList(int nStartPage, int list_num){
		return this.boardMapper.getSignUpList(nStartPage, list_num);
	}
	//������
	public int getSavingsCnt() {
		int nCnt=0;
		nCnt=this.boardMapper.getSavingsCnt();
		return nCnt;
	}
	//������ arraylist
	public ArrayList<FreeBoard_Bean> getSavingsList(int nStartPage, int list_num){
		return this.boardMapper.getSavingsList(nStartPage, list_num);
	}
	//��Ÿ
	public int getEtcCnt() {
		int nCnt=0;
		nCnt=this.boardMapper.getEtcCnt();
		return nCnt;
	}
	//��Ÿ arraylist
	public ArrayList<FreeBoard_Bean> getEtcList(int nStartPage, int list_num){
		return this.boardMapper.getEtcList(nStartPage, list_num);
	}
	
	//�ۺ��⿡ �Ѹ� bean
	public FreeBoard_Bean getSpecificRow(int idx) {
		return this.boardMapper.getSpecificRow(idx);//-getSpecificRow(@Param("id") String id): return id, subject, name, created_date, mail, memo, hits
	}
	
	//�� �����ϱ�
	public void updateBoard(FreeBoard_Bean boardBean) {
		boardMapper.updateBoard(boardBean.getIdx(), boardBean.getSubject(), 
				boardBean.getCategory(), boardBean.getContent());
	}
	//�ۻ����ϱ�
	public void deleteRow(int idx) {
		this.boardMapper.deleteSpecificRow(idx);
	}
>>>>>>> f468c823fb38f81388f1f0cd521a2d8766679c8d
	//�˻��� �� ��
	public int getTotalCntBySubject(String search) {
		int nCnt=0;
		nCnt=this.boardMapper.getTotalCntBySubject(search);
		return nCnt;
	}
<<<<<<< HEAD
	
	//�˻��ϱ� -> ArrayList�� ���
	public ArrayList<FreeBoard_Bean> getSearchedList(int nStartPage, int list_num, String strSearchThis){
		return this.boardMapper.getSearchedList(nStartPage, list_num, strSearchThis);
	}
	
	//���
	public void updateRewrite(int idx_num) {
		boardMapper.updateRewrite(idx_num);
	}
	public int recentID() {
		int recent_id=0;
		recent_id=this.boardMapper.recentID();
		return recent_id;
	}
	public FreeBoard_Bean stairBoard(int idx_num) {
		return this.boardMapper.stairBoard(idx_num);
	}
	public void updateGroupStep(int ref, int step) {
		this.boardMapper.updateGroupStep(ref, step);
	}
	
	//���̵� ��������
	/*public FreeBoard_Bean getIdname(int idx_num) {
		return this.boardMapper.getIdname(idx_num);*/
	
=======
	//�˻��ϱ� => ArrayList �� ��� 
	public ArrayList<FreeBoard_Bean> getSearchedList(int nStartPage, int list_num, String strSearchThis){
		return this.boardMapper.getSearchedList(nStartPage, list_num, strSearchThis);
	}

>>>>>>> f468c823fb38f81388f1f0cd521a2d8766679c8d
}
