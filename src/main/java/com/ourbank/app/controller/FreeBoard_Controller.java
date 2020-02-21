package com.ourbank.app.controller;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 029abcd43ddfc8ce09fdf531da8e2117ef4a1003
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.LineListener;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.javassist.expr.NewArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
<<<<<<< HEAD
=======

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
>>>>>>> f468c823fb38f81388f1f0cd521a2d8766679c8d
=======
>>>>>>> 029abcd43ddfc8ce09fdf531da8e2117ef4a1003
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

<<<<<<< HEAD
<<<<<<< HEAD
import com.ourbank.app.bean.FreeBoard_Bean;
import com.ourbank.app.service.FreeBoard_Service;
=======
>>>>>>> f468c823fb38f81388f1f0cd521a2d8766679c8d
=======
import com.ourbank.app.bean.FreeBoard_Bean;
import com.ourbank.app.service.FreeBoard_Service;
>>>>>>> 029abcd43ddfc8ce09fdf531da8e2117ef4a1003

import com.ourbank.app.bean.FreeBoard_Bean;
import com.ourbank.app.service.FreeBoard_Service;

@Controller
public class FreeBoard_Controller {
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 029abcd43ddfc8ce09fdf531da8e2117ef4a1003
	
	@Autowired
	FreeBoard_Service boardService;
	
	private static final Logger logger = 
			LoggerFactory.getLogger(FreeBoard_Controller.class); 
	
	
	//�۾��� ������
	@RequestMapping(value = "/free_show_write_fome.do", method = RequestMethod.GET)
	public String free_show_write_form(FreeBoard_Bean boardBean, Model model) {
		logger.info("free_show_write_form called");
		
		int ref=0;  //�׷�(������ �۹�ȣ ����)
		int step=0;  //�׷쳻 ����
		int depth=0; //����
		int re_idx=0;
		logger.info("ref:"+ref+" step: "+step+"depth: "+depth+" ");

		//�ӽ÷� �־��
		String id = "exId";
		
		model.addAttribute("id", id);
		model.addAttribute("re_idx", re_idx);
		model.addAttribute("step", step);
		model.addAttribute("ref", ref);
		model.addAttribute("depth", depth);
		model.addAttribute("boardBean", new FreeBoard_Bean());
		return "board_community/free/free_writeBoard";
	}
	
	//�۾���ó��
	@RequestMapping(value="/free_DoWriteBoard.do" , method = RequestMethod.POST)
	public String DofreeWriteBoard(@ModelAttribute("boardBean") FreeBoard_Bean boardBean, 
			Model model) {
		System.out.println("-----------------------------------------");
		logger.info("free_DoWriteBoard.do called");
		
		MultipartFile file=boardBean.getFile();

		// �ڷ�ǿ� file �ø���
		if(file!=null) {
			String fileName=file.getOriginalFilename();
			long fileSize= file.getSize();
<<<<<<< HEAD
=======
	@Autowired
	private FreeBoard_Service boardService;
	
	private static final Logger logger=LoggerFactory.getLogger(FreeBoard_Controller.class);
	
	//�۾�����
	@RequestMapping(value="/free_show_write_form.do", method=RequestMethod.GET)
	public String showWriteForm(Model model) {
		logger.info("show_write_form called!!");
		
		int id=0;
		
		model.addAttribute("id", id);
		model.addAttribute("boardBean", new FreeBoard_Bean());
		return "board_community/free/freeWriteForm";
		
	}
	//�۾���
	@RequestMapping(value="/free_write_form.do", method=RequestMethod.POST)
	public String DofreeWriteBoard(@ModelAttribute("boardBean") @Valid FreeBoard_Bean boardBean,
			BindingResult bindingResult,
			Model model) {
		System.out.println(boardBean.toString());
		MultipartFile file=boardBean.getFile();
		
		//��ȿ�� �˻�
		if(bindingResult.hasErrors()) {
			List<ObjectError> list=bindingResult.getAllErrors();
			for(ObjectError e:list) {
				logger.error("ObjectError"+e+"\n");
			}
			model.addAttribute("boardBean",boardBean);
			return "board_community/free/freeWriteForm";
		}
		
		//���� ó��
		if(file!=null) {
			String fileName=file.getOriginalFilename();
			long fileSize=file.getSize();
>>>>>>> f468c823fb38f81388f1f0cd521a2d8766679c8d
=======
>>>>>>> 029abcd43ddfc8ce09fdf531da8e2117ef4a1003
			boardBean.setFilename(fileName);
			boardBean.setFilesize(fileSize);
			logger.info(boardBean.getFilename());
			logger.info(boardBean.getFilesize()+"");
			
			try {
				byte[] fileData=file.getBytes();
<<<<<<< HEAD
<<<<<<< HEAD
				FileOutputStream output=
						new FileOutputStream("C:\\Users\\user\\Desktop\\OurBank\\src\\main\\webapp\\resources\\files\\"+fileName);
			
=======
				FileOutputStream output=new FileOutputStream("C:\\eclipse_ourBank\\OurBank\\src\\main\\resources\\files\\"+fileName);
>>>>>>> f468c823fb38f81388f1f0cd521a2d8766679c8d
=======
				FileOutputStream output=
						new FileOutputStream("C:\\Users\\user\\Desktop\\OurBank\\src\\main\\webapp\\resources\\files\\"+fileName);
			
>>>>>>> 029abcd43ddfc8ce09fdf531da8e2117ef4a1003
				output.write(fileData);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 029abcd43ddfc8ce09fdf531da8e2117ef4a1003
		
		String id = "exId";
		boardBean.setId(id);
		logger.info(boardBean.getId());

		//������ ���
		if(boardBean.getRe_idx()==0) {
			boardService.insertBoard(boardBean);
			int recent_id=boardService.recentID(); //�����ֱٰ�������
			logger.info("reid :"+recent_id);
			boardService.updateRewrite(recent_id);
			System.out.println("�����ۼ�");
		}
		else {//����� ���
			int ref=boardBean.getRef();
			System.out.println("ref"+ref);
			boardBean.setRef(ref); //������ �۹�ȣ�� ����
			boardService.updateGroupStep(ref, boardBean.getStep());
			boardBean.setStep(boardBean.getStep()+1);
			boardBean.setDepth(boardBean.getDepth()+1);
			boardBean.setRe_idx(0);
			boardService.insertBoard(boardBean);
			System.out.println("����ۼ�");
		} 
		
		  model.addAttribute("subject", boardBean.getSubject());
		  model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		  model.addAttribute("current_page", "1");
		  model.addAttribute("boardList",boardService.getList(1, 10));
		  System.out.println("ok");
		return "redirect:free_listSpecificPageWork.do"; 
	}
	
	//���
	@RequestMapping(value = "/free_show_rewrite_form.do", method = RequestMethod.GET)
	public String free_show_rewrite_from(
			@RequestParam("idx_num") String idx_num,
			@RequestParam("current_page") String current_page, 
			Model model) {
		logger.info("free_how_rewrite_form called!!");
		
		//�ش� idx_num�� ���� ���� 
		FreeBoard_Bean boardBean=boardService.stairBoard(Integer.parseInt(idx_num));
		
		logger.info("idx_num :"+boardBean.getIdx_num());
		logger.info("ref :"+boardBean.getRef()); //�׷�(������ �۹�ȣ ����)
		logger.info("step :"+boardBean.getStep()); //�׷쳻�μ���
		logger.info("depth"+boardBean.getDepth()); //����
		boardBean.setRe_idx(1); //���
		logger.info("re_idx :"+boardBean.getRe_idx());
		logger.info("subject :"+boardBean.getSubject());
		
		
		//ref=0�ΰ�� (��۱׷�)
		if(boardBean.getRef()==0) {
			model.addAttribute("ref", boardBean.getIdx_num());
			String re_subject = "Re:"+boardBean.getSubject()+"_�亯";
			logger.info("subject :"+re_subject);
			model.addAttribute("subject", re_subject);
		}
		else {
			model.addAttribute("ref", boardBean.getRef());
			String re_subject = "Re:"+boardBean.getSubject();
			logger.info("subject :"+re_subject);
			model.addAttribute("subject", re_subject);
		}
		model.addAttribute("idx_num", idx_num);
		model.addAttribute("re_idx", boardBean.getRe_idx());
		model.addAttribute("step", boardBean.getStep());
		model.addAttribute("depth", boardBean.getDepth());
		model.addAttribute("boardBean", new FreeBoard_Bean());
		
		return "board_community/free/free_writeBoard";
	} 
	
	//����Ʈ��
	@RequestMapping(value = "/free_listSpecificPageWork.do", method=RequestMethod.GET)
	public String free_listSpecificPageWork(
			@RequestParam("current_page") String pageForView, Model model) {
		System.out.println("-------------------------------");
		logger.info("free_listSpecificPageWork called");
		logger.info("current_page=["+pageForView+"]");
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", pageForView);
		model.addAttribute("boardList", boardService.getList(Integer.parseInt(pageForView),10));
		System.out.println("-------------------------------");
		
		return "board_community/free/free_listSpecificPage";
	}
	
	//�ۺ���
	@RequestMapping(value="/free_viewWork.do", method=RequestMethod.GET)
	public String free_viewWork(@RequestParam("idx_num") int idx_num,
						   @RequestParam("current_page") String current_page,
						   @RequestParam("searchStr") String searchStr,
						   Model model) {
		logger.info("free_viewWork called");
		logger.info("idx_num=["+idx_num+"] current_page=["+current_page+"] "
		+ "searchStr=["+searchStr+"]");
			
		FreeBoard_Bean boardData=boardService.getSpecificRow(idx_num);
		logger.info(boardData.getContent());
		logger.info("hits: "+boardData.getHits());
		//��ȸ�� ����
		boardService.updateHits(boardData.getHits(),boardData.getIdx_num());
		boardData.setHits(boardService.getSpecificRow(idx_num).getHits());;		
			
		model.addAttribute("idx_num", idx_num);
		model.addAttribute("current_page", current_page);
		model.addAttribute("searchStr", searchStr);
		model.addAttribute("boardData", boardData);
		model.addAttribute("filename", boardData.getFilename());
		System.out.println("zzzzzz");
		logger.info(boardData.getFilename());
		
			
		return "board_community/free/free_viewContent";
	}
	
	//���� �ٿ�ε�
	@RequestMapping(value = "/free_download.do", method=RequestMethod.GET)
	@ResponseBody
	public byte[] free_downProcess(HttpServletResponse response, @RequestParam String filename) 
			   throws IOException{
		System.out.println("�ٿ�ε�");
		String fn2=new String(filename);
		System.out.println(fn2);
	    File file = new File("C:\\Users\\user\\Desktop\\OurBank\\src\\main\\webapp\\resources\\files\\" + filename);
	    byte[] bytes = FileCopyUtils.copyToByteArray(file);
	    String fn = new String(file.getName().getBytes(),"iso_8859_1");
	      
	    response.setHeader("Content-Disposition", "attachment;filename=\"" + fn + "\"");
	    response.setContentLength(bytes.length);
	    return bytes;
	    }

	//�ۼ��� ������
	@RequestMapping(value="free_listSpecificPageWork_to_update.do",method=RequestMethod.GET)
	public String free_showUpdateForm(@RequestParam("idx_num") int idx_num,
								 @RequestParam("current_page") String current_page,
								 Model model) {
		logger.info("free_listSpecificPageWork_to_update called");
		logger.info("idx_num="+idx_num);
		model.addAttribute("idx_num", idx_num);
		model.addAttribute("current_page", current_page);
		model.addAttribute("boardData", boardService.getSpecificRow(idx_num));
		
		return "board_community/free/free_viewContentForUpdate";
	}
	//�ۼ��� ó��
	@RequestMapping(value="/free_DoUpdateBoard.do", method=RequestMethod.POST)
	public String free_Update(
			@ModelAttribute("boardBean")  FreeBoard_Bean boardBean,
			@RequestParam("idx_num") int idx_num,
<<<<<<< HEAD
=======
		String id="admin";
		boardBean.setId(id);
		logger.info(boardBean.getCategory()+" "+
					boardBean.getId()+" "+
					boardBean.getContent()+" "+
					boardBean.getSubject());
		boardService.insertBoard(boardBean);
		
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", 1);
		model.addAttribute("boardList", boardService.getList(1, 10));
		return "redirect:freeList.do";
	}
	
	//����Ʈ �Ѹ���
	@RequestMapping(value="/freeList.do", method=RequestMethod.GET)
	public String freeList(
			@RequestParam("current_page") String pageForView, Model model
			) {
		logger.info("freeList called !!");
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));//��ü �ۼ�
		model.addAttribute("current_page",pageForView);
		model.addAttribute("boardList", boardService.getList(Integer.parseInt(pageForView), 10)); //����Ʈ�Ѹ� ArrayList �޾ƿͼ� ����
		return "board_community/free/freeListSpecificPage";
	}
	//ȸ������ ����Ʈ �Ѹ���
	@RequestMapping(value="/freeSignUpList.do", method=RequestMethod.GET)
	public String freeSignUpList(
			@RequestParam("current_page") String pageForView, Model model
			) {
		logger.info("free signup List called !!");
		model.addAttribute("totalCnt", new Integer(boardService.getSignUpCnt()));//ȸ������ �ۼ�
		model.addAttribute("current_page",pageForView);
		model.addAttribute("boardList", boardService.getSignUpList(Integer.parseInt(pageForView), 10)); //����Ʈ�Ѹ� ArrayList �޾ƿͼ� ����
		return "board_community/free/freeListSpecificPage";
	}
	//������ ����Ʈ �Ѹ���
	@RequestMapping(value="/freeSavingsList.do", method=RequestMethod.GET)
	public String freeSavingList(
			@RequestParam("current_page") String pageForView, Model model
			) {
		logger.info("free saving List called !!");
		model.addAttribute("totalCnt", new Integer(boardService.getSavingsCnt()));//ȸ������ �ۼ�
		model.addAttribute("current_page",pageForView);
		model.addAttribute("boardList", boardService.getSavingsList(Integer.parseInt(pageForView), 10)); //����Ʈ�Ѹ� ArrayList �޾ƿͼ� ����
		return "board_community/free/freeListSpecificPage";
	}
	//��Ÿ ����Ʈ �Ѹ���
	@RequestMapping(value="/freeEtcList.do", method=RequestMethod.GET)
	public String freeEtcList(
			@RequestParam("current_page") String pageForView, Model model
			) {
		logger.info("free etc List called !!");
		model.addAttribute("totalCnt", new Integer(boardService.getEtcCnt()));//ȸ������ �ۼ�
		model.addAttribute("current_page",pageForView);
		model.addAttribute("boardList", boardService.getEtcList(Integer.parseInt(pageForView), 10)); //����Ʈ�Ѹ� ArrayList �޾ƿͼ� ����
		return "board_community/free/freeListSpecificPage";
	}

	//�ۺ���
	@RequestMapping(value="/freeView.do", method=RequestMethod.GET)
	public String viewWork(@RequestParam("idx") int idx,
						   @RequestParam("current_page") String current_page,
						   @RequestParam("searchStr") String searchStr,
						   Model model) {
		logger.info("viewWork called");
		logger.info("idx=["+idx+"] current_page=["+current_page+"] "
				+ "searchStr=["+searchStr+"]");
		FreeBoard_Bean boardData=boardService.getSpecificRow(idx);
		logger.info(boardData.getContent());
		boardService.updateHits(boardData.getHits(), boardData.getIdx());
		model.addAttribute("hits", boardData.getHits());
		logger.info(boardData.getCategory());
		
		model.addAttribute("idx", idx);
		model.addAttribute("current_page", current_page);
		model.addAttribute("searchStr", searchStr);
		model.addAttribute("boardData", boardService.getSpecificRow(idx));
		model.addAttribute("filename", boardData.getFilename());
		return "board_community/free/freeViewMemo";
	}
	
	//�ٿ�ε�
	@RequestMapping(value = "/free_download.do", 
	         method=RequestMethod.GET)
	   @ResponseBody
	   public byte[] downProcess(HttpServletResponse response, @RequestParam String filename) throws IOException{
	      File file = new File("C:\\eclipse_ourBank\\OurBank\\src\\main\\resources\\files\\" + filename);
	      byte[] bytes = FileCopyUtils.copyToByteArray(file);
	      String fn = new String(file.getName().getBytes(),"iso_8859_1");
	      
	      response.setHeader("Content-Disposition",
	                "attachment;filename=\"" + fn + "\"");
	        response.setContentLength(bytes.length);
	        return bytes;
	   }
	//�ۼ�����
	@RequestMapping(value="free_show_update_form.do",method=RequestMethod.GET)
	public String showUpdateForm(
			@RequestParam("idx") int idx,
			@RequestParam("current_page") String current_page,
			Model model
			) {
		
		logger.info("update form!!");
		logger.info(idx+"");
		model.addAttribute("idx", idx);
		model.addAttribute("current_page", current_page);
		model.addAttribute("boardData", boardService.getSpecificRow(idx));
		
		return "board_community/free/freeViewMemoForUpdate";
	}
	//�ۼ���
	@RequestMapping(value="/free_update.do", method=RequestMethod.POST)
	public String freeUpdate(
			@ModelAttribute("boardBean") @Valid FreeBoard_Bean boardBean,
			BindingResult bindingResult,
			@RequestParam("idx") int idx,
>>>>>>> f468c823fb38f81388f1f0cd521a2d8766679c8d
=======
>>>>>>> 029abcd43ddfc8ce09fdf531da8e2117ef4a1003
			@RequestParam("current_page") String current_page,
			Model model) {
		System.out.println(boardBean.toString());
		MultipartFile file=boardBean.getFile();
		
<<<<<<< HEAD
<<<<<<< HEAD
=======
		//��ȿ�� �˻�
		if(bindingResult.hasErrors()) {
			List<ObjectError> list=bindingResult.getAllErrors();
			for(ObjectError e:list) {
				logger.error("ObjectError"+e+"\n");
			}
			model.addAttribute("boardBean",boardBean);
			return "board_community/free/freeWriteForm";
		}
		
>>>>>>> f468c823fb38f81388f1f0cd521a2d8766679c8d
=======
>>>>>>> 029abcd43ddfc8ce09fdf531da8e2117ef4a1003
		//���� ó��
		if(file!=null) {
			String fileName=file.getOriginalFilename();
			long fileSize=file.getSize();
			boardBean.setFilename(fileName);
			boardBean.setFilesize(fileSize);
			logger.info(boardBean.getFilename());
			logger.info(boardBean.getFilesize()+"");
			
			try {
				byte[] fileData=file.getBytes();
<<<<<<< HEAD
<<<<<<< HEAD
				FileOutputStream output=new FileOutputStream("C:\\Users\\user\\Desktop\\OurBank\\src\\main\\webapp\\resources\\files\\"+fileName);
=======
				FileOutputStream output=new FileOutputStream("C:\\eclipse_ourBank\\OurBank\\src\\main\\resources\\files\\"+fileName);
>>>>>>> f468c823fb38f81388f1f0cd521a2d8766679c8d
=======
				FileOutputStream output=new FileOutputStream("C:\\Users\\user\\Desktop\\OurBank\\src\\main\\webapp\\resources\\files\\"+fileName);
>>>>>>> 029abcd43ddfc8ce09fdf531da8e2117ef4a1003
				output.write(fileData);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		//���ǿ��� ���;���
<<<<<<< HEAD
<<<<<<< HEAD
		String id="exId";
		boardBean.setId(id);
		logger.info(boardBean.getId()+" "+
					boardBean.getContent()+" "+
					boardBean.getSubject());
		
		boardBean.setIdx_num(idx_num);
		
		boardService.updateBoard(boardBean);
		boardBean=boardService.getSpecificRow(idx_num);
		
		model.addAttribute("idx_num", idx_num);
		model.addAttribute("current_page", current_page);
		model.addAttribute("searchStr", "None");
		model.addAttribute("boardData", boardService.getSpecificRow(idx_num));
		model.addAttribute("filename", boardBean.getFilename());
		
		return "board_community/free/free_viewContent";
	}
	
	//�� ����
	@RequestMapping(value="/free_DeleteSpecificRow.do", method=RequestMethod.GET)
	public String deleteSpecificRow(@RequestParam("idx_num") int idx_num,
									@RequestParam("current_page") int current_page,
									Model model) {
		logger.info("free_DeleteSpecificRow called!!");
		logger.info("idx_num=["+idx_num+"]  current_page=["+current_page+"]");
		boardService.deleteRow(idx_num);
=======
		String id="admin";
=======
		String id="exId";
>>>>>>> 029abcd43ddfc8ce09fdf531da8e2117ef4a1003
		boardBean.setId(id);
		logger.info(boardBean.getCategory()+" "+
					boardBean.getId()+" "+
					boardBean.getContent()+" "+
					boardBean.getSubject());
		
		boardBean.setIdx(idx);
		
		boardService.updateBoard(boardBean);
		boardBean=boardService.getSpecificRow(idx);
		
		model.addAttribute("idx", idx);
		model.addAttribute("current_page", current_page);
		model.addAttribute("searchStr", "None");
		model.addAttribute("boardData", boardService.getSpecificRow(idx));
		model.addAttribute("filename", boardBean.getFilename());
		
		return "board_community/free/freeViewMemo";
	}
	
	//�� ����
	@RequestMapping(value="/freeDeleteSpecificRow.do", method=RequestMethod.GET)
	public String deleteSpecificRow(@RequestParam("idx") int idx,
									@RequestParam("current_page") int current_page,
									Model model) {
<<<<<<< HEAD
		logger.info("DeleteSpecificRow called!!");
		logger.info("memo_id=["+idx+"]  current_page=["+current_page+"]");
		boardService.deleteRow(idx);
>>>>>>> f468c823fb38f81388f1f0cd521a2d8766679c8d
=======
		logger.info("free_DeleteSpecificRow called!!");
		logger.info("idx_num=["+idx_num+"]  current_page=["+current_page+"]");
		boardService.deleteRow(idx_num);
>>>>>>> 029abcd43ddfc8ce09fdf531da8e2117ef4a1003
		//�ٽ� �������� ��ȸ�Ѵ�.
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", current_page);
		model.addAttribute("boardList",boardService.getList(current_page, 10));
		
<<<<<<< HEAD
<<<<<<< HEAD
		return "redirect:free_listSpecificPageWork.do";
	}
	
	//�۰˻�
	@RequestMapping(value="/free_searchWithSubject.do", method=RequestMethod.POST)
	public String free_searchWithSubject (@RequestParam("searchStr") String searchStr, 
									Model model) {
		logger.info("free_searchWithSubject.do called");
		
		
		return free_listSearchedSpecificPageWork(1, searchStr,model);
	}

	//�˻��� �������� �̵�
	@RequestMapping(value="/free_listSearchedSpecificPageWork.do",method = RequestMethod.GET)
	public String free_listSearchedSpecificPageWork(
=======
		return "redirect:freeList.do";
=======
		return "redirect:free_listSpecificPageWork.do";
>>>>>>> 029abcd43ddfc8ce09fdf531da8e2117ef4a1003
	}
	
	//�۰˻�
	@RequestMapping(value="/freeSearch.do", method=RequestMethod.POST)
	public String searchWithSubject (@RequestParam("searchStr") String searchStr, 
									Model model) {
		
		
		return searchedList(1, searchStr,model);
	}

	//�˻��� �������� �̵�
<<<<<<< HEAD
	@RequestMapping(value="/freeSearchedList.do",method = RequestMethod.GET)
	public String searchedList(
>>>>>>> f468c823fb38f81388f1f0cd521a2d8766679c8d
=======
	@RequestMapping(value="/free_listSearchedSpecificPageWork.do",method = RequestMethod.GET)
	public String free_listSearchedSpecificPageWork(
>>>>>>> 029abcd43ddfc8ce09fdf531da8e2117ef4a1003
			@RequestParam("pageForView") int pageForView,
			@RequestParam("searchStr") String searchStr,
			Model model
			) {
<<<<<<< HEAD
<<<<<<< HEAD
		logger.info("free_listSearchedSpecificPageWork called");
=======
		logger.info("listSearchedSpecificPageWork called");
>>>>>>> f468c823fb38f81388f1f0cd521a2d8766679c8d
=======
		logger.info("free_listSearchedSpecificPageWork called");
>>>>>>> 029abcd43ddfc8ce09fdf531da8e2117ef4a1003
		logger.info("pageForView=["+pageForView+"]");
		logger.info("searchStr=["+searchStr+"]");
		
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCntBySubject(searchStr)));
		model.addAttribute("searchedList", boardService.getSearchedList(pageForView, 10, searchStr));
		model.addAttribute("pageForView", pageForView);
		model.addAttribute("searchStr", searchStr);

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 029abcd43ddfc8ce09fdf531da8e2117ef4a1003
		return "board_community/free/free_listSearchedPage";
	}
	
		
<<<<<<< HEAD
=======
		return "board_community/free/freeListSearchedPage";
	}

>>>>>>> f468c823fb38f81388f1f0cd521a2d8766679c8d
=======
>>>>>>> 029abcd43ddfc8ce09fdf531da8e2117ef4a1003
}
