package com.ourbank.app.service;

import java.util.ArrayList;

import org.omg.CORBA.FREE_MEM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ourbank.app.bean.DepositBoard_Bean;
import com.ourbank.app.bean.FreeBoard_Bean;
import com.ourbank.app.bean.SavingBoard_Bean;
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
	this.boardMapper.updateMyInfo(userBean.getUser_name(), userBean.getUser_birth(),
			userBean.getUser_phone(), userBean.getUser_address(), userBean.getUser_email(),userBean.getId());
}
//����
public void deleteId(String id) {
	this.boardMapper.deleteId(id);
}
//��ǰ ���� ����
public void deleteProductData(String id) {
	this.boardMapper.deleteProductData(id);
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
//�̹� ����ߴ��� Ȯ��
public int selectCntExist(String id, String fin_prdt_cd) {
	return this.boardMapper.selectCntExist(id, fin_prdt_cd);
}

//������ ��ǰ  �ֱ�
public void insertMyDeposit(DepositBoard_Bean depositBean) {
	System.out.println( depositBean.getId());
	boardMapper.insertMyDeposit( depositBean.getId(),
								depositBean.getFin_co_no(),
								depositBean.getKor_co_nm(),
								depositBean.getFin_prdt_cd(),
								depositBean.getFin_prdt_nm());
}
//����-------------
//������ ���� ���� ����
public ArrayList<SavingBoard_Bean> getSavingBank() {
	return this.boardMapper.selectSavingBank();
}
//������ ���࿡ �´� ��ǰ �˻�
public ArrayList<SavingBoard_Bean> getSavingProduct() {
	return this.boardMapper.selectSavingProduct();
}
//��ǰ�ڵ忡 ��ġ�ϴ� ������ ��������
public SavingBoard_Bean getOneSaving(String fin_prdt_cd) {
	return this.boardMapper.selectOneSaving(fin_prdt_cd);
}

//������ ��ǰ  �ֱ�
public void insertMySaving(SavingBoard_Bean savingBean) {
	System.out.println(savingBean.getId());
	boardMapper.insertMySaving(savingBean.getId(),
			savingBean.getFin_co_no(),
			savingBean.getKor_co_nm(),
			savingBean.getFin_prdt_cd(),
			savingBean.getFin_prdt_nm());
}
public int selectCntMYProduct(String id) {
	return this.boardMapper.selectCntMyProduct(id);
}

//���Ի�ǰ ����Ʈ ���
public ArrayList<DepositBoard_Bean> selectAllProduct(String id,int current_page, int pageforList){
	return this.boardMapper.selectAllProduct(id,current_page,pageforList);
}

//���Ի�ǰ ����
public void deleteProduct(String id, String fin_prdt_cd) {
	 boardMapper.deleteProduct(id, fin_prdt_cd);
}
////��ٱ���///////////////////////////////////////////////
//���ϴ� ��ǰ �ߺ�Ȯ��
public int selectWantExist(String id, String fin_prdt_cd) {
	return boardMapper.selectWantExist(id, fin_prdt_cd);
}
//���ϴ� ��ǰ �ֱ�
public void insertMyWant(String fin_prdt_cd,DepositBoard_Bean depositBean, String dep_or_sav) {
	boardMapper.insertMyWant(fin_prdt_cd,
			depositBean.getFin_co_no(),
			depositBean.getKor_co_nm(),
			depositBean.getFin_prdt_cd(),
			depositBean.getFin_prdt_nm(),
			dep_or_sav);
}

//��� ���ϴ� ��ǰ ��
public int selectCntWant(String id) {
	return boardMapper.selectWantCnt(id);
}
//���ϴ� ��ǰ ����Ʈ
public ArrayList<DepositBoard_Bean> selectWantList(String id, int current_page, int pageforView){
	return boardMapper.selectWantList(id, current_page, pageforView);
}
public void deleteWant(String id, String fin_prdt_cd) {
	boardMapper.deleteMyWant(id, fin_prdt_cd);
}
/////////////////////////////////////////////////////////////////////////////////////////////////


}