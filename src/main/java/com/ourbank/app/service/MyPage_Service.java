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

//�������� - �� ����
public void updateBoard(FreeBoard_Bean boardBean) {
	boardMapper.updateBoard(boardBean.getBoard_idx(), boardBean.getSubject(),
			boardBean.getContent(), boardBean.getFilename(), boardBean.getFilesize());
	
}

//��ü�� ��
public int getTotalCnt() {
	int nCnt=0;
	nCnt=this.boardMapper.getTotalCnt();
	return nCnt;
	}

//�������� - �� ����
public void deleteRow(int board_idx) {
	this.boardMapper.deleteSpecificRow(board_idx);
	}



	





}