package com.ourbank.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ourbank.app.bean.BestBoard_Bean;
import com.ourbank.app.mapper.BestBoard_Mapper;

@Component
public class BestBoard_Service {
	
	@Autowired 
	BestBoard_Mapper boardMapper;

	//�ε���, ����, �ۼ���, ��¥, ����, ��ȸ��  arraylist ����
	public ArrayList<BestBoard_Bean> getList(int nStartPage, int list_num) {
		return this.boardMapper.getList(nStartPage, list_num);
	}
	
	//��ȸ�� �ø���
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
	
	
	//�ۺ��⿡ �Ѹ� bean
	public BestBoard_Bean getSpecificRow(int best_idx) {
		return this.boardMapper.getSpecificRow(best_idx);
	}
	
	//���Ǵ� ī�װ� 
	//public BestBoard_Bean getCategoryNum(int category) {
	//	return this.boardMapper.getCategoryNum(category);
	//}
	
	
	

}
