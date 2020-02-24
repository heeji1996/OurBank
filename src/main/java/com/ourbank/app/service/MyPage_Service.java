package com.ourbank.app.service;

import java.util.ArrayList;

import org.omg.CORBA.FREE_MEM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ourbank.app.bean.DepositBoard_Bean;
import com.ourbank.app.bean.FreeBoard_Bean;
import com.ourbank.app.bean.UserBoard_Bean;
import com.ourbank.app.mapper.MyPage_Mapper;

@Component
public class MyPage_Service {
@Autowired
private MyPage_Mapper boardMapper;

public UserBoard_Bean getUserInfo(String id) {
	return boardMapper.selectMyInfo(id);
}

//������ ����
public void updateUserInfo(UserBoard_Bean userBean) {
	this.boardMapper.updateMyInfo(userBean.getPasswd(), userBean.getUser_name(), userBean.getUser_birth(),
			userBean.getUser_phone(), userBean.getUser_address(), userBean.getUser_email(),userBean.getId());
}
//����
public void deleteId(String id) {
	this.boardMapper.deleteId(id);
}

//�������� - ����Ʈ����  / ��ü�۹�ȣ, ������, ��¥ , ��ȸ��, ���̵�
public ArrayList<FreeBoard_Bean> getUserBoardList(String id, int nStartPage, int list_num) {
	return boardMapper.getBoardList(id, nStartPage, list_num);
}

//�������� - �ۺ���
public FreeBoard_Bean getSpecificRow(int board_idx) {
	return this.boardMapper.getSpecificRow(board_idx);
}

//��ȸ�� �ø���
//����Խ���
public void updateReviewHits(int hits, int best_idx) {
	System.out.println("��ȸ�� �ö�");
	this.boardMapper.updateReviewHits(hits, best_idx);
}
//�����Խ��� 
public void updateFreeHits(int hits, int best_idx) {
	System.out.println("��ȸ�� �ö�");
	this.boardMapper.updateFreeHits(hits, best_idx);
}
//���ӹ�Խ��� 
public void updateMeetingHits(int hits, int best_idx) {
	System.out.println("��ȸ�� �ö�");
	this.boardMapper.updateMeetingHits(hits, best_idx);
}
//��й�Խ��� 
public void updateDebateHits(int hits, int best_idx) {
	System.out.println("��ȸ�� �ö�");
	this.boardMapper.updateDebateHits(hits, best_idx);
}
//����ũ���Ͽ�Խ��� 
public void updateInvestHits(int hits, int best_idx) {
	System.out.println("��ȸ�� �ö�");
	this.boardMapper.updateInvestHits(hits, best_idx);
}
//QnA�Խ��� 
public void updateQnaHits(int hits, int best_idx) {
	System.out.println("��ȸ�� �ö�");
	this.boardMapper.updateQnaHits(hits, best_idx);
}


//��ü�� ��
public int getTotalCnt(String id) {
	int nCnt=0;
	nCnt=this.boardMapper.getTotalCnt(id);
	return nCnt;
	}




	





}