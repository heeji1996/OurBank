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

/////////////////////////////////////////////////////////////////////////////////////////////////
	
//������ ���� ���� ����
public ArrayList<DepositBoard_Bean> getDepositBank() {
	return this.boardMapper.selectDepositBank();
}
//������ ���࿡ �´� ��ǰ �˻�
public ArrayList<DepositBoard_Bean> getDepositProduct() {
	return this.boardMapper.selectDepositProduct();
}
//��ǰ�ڵ忡 ��ġ�ϴ� ������ ��������
public DepositBoard_Bean getOneDeposit(String fin_prdt_cd) {
	return this.boardMapper.selectOneDeposit(fin_prdt_cd);
}
//������ ��ǰ view�� �ֱ�
public void insertMyDeposit(DepositBoard_Bean depositBean) {
	System.out.println(depositBean.getId());
	boardMapper.insertMyDeposit(depositBean.getId(),
								depositBean.getFin_co_no(),
								depositBean.getKor_co_nm(),
								depositBean.getFin_prdt_cd(),
								depositBean.getFin_prdt_nm());
}
public int selectCntMYProduct(String id) {
	return this.boardMapper.selectCntMyProduct(id);
}

//���Ի�ǰ ����Ʈ ���
public ArrayList<DepositBoard_Bean> selectAllProduct(String id,int current_page, int pageforList){
	return this.boardMapper.selectAllProduct(id,current_page,pageforList);
}
/////////////////////////////////////////////////////////////////////////////////////////////////


}