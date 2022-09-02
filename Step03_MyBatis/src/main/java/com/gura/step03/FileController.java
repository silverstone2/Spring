package com.gura.step03;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileController {
   /*
    *  <input type="text" name="title" placeholder="설명입력..."/><br />
       <input type="file" name="myFile"/><br />
       
         위에서  name 속성의 값인 title 과 myFile 이라는 이름으로 매개변수명을 정하면 
         전송된  text 는  title 변수에 담기고 
         전송된  파일에 대한 정보(파일명, 파일의크기, 전송된 파일객체)는 myFile 객체에 담긴다. 
    */
	@RequestMapping("/file/upload")
	public ModelAndView upload(String title, MultipartFile myFile, HttpServletRequest request) {
   
		//원본 파일명
		String orgFileName=myFile.getOriginalFilename();
		//파일 사이즈
		long fileSize=myFile.getSize();
      
		//upload 폴더에 저장할 파일명을 직접구성한다.
		// 1234123424343xxx.jpg
		String saveFileName=System.currentTimeMillis()+orgFileName;
      
		// webapp/upload 폴더까지의 실제 경로 얻어내기 
		String realPath=request.getServletContext().getRealPath("/upload");
		// upload 폴더가 존재하지 않을경우 만들기 위한 File 객체 생성
		File upload=new File(realPath);
		if(!upload.exists()) {//만일 존재 하지 않으면
			upload.mkdir(); //만들어준다.
		}
		String savePath = null;
		try {
			//파일을 저장할 전체 경로를 구성한다.  
			savePath=realPath+File.separator+saveFileName;
			//임시폴더에 업로드된 파일을 원하는 파일을 저장할 경로에 전송한다.
			myFile.transferTo(new File(savePath));
		}catch(Exception e) {
			e.printStackTrace();
		}
      
		// 업로드된 파일의 정보를 원래는 DB 에 저장해야 하지만
		// 테스트중이니 그냥 ModelAndView 에 담고 view page에서 확인만 해보기
		ModelAndView mView=new ModelAndView();
		mView.addObject("title", title);
		mView.addObject("fileSize", fileSize);
		mView.addObject("orgFileName", orgFileName);
		mView.addObject("saveFileName", saveFileName);
		mView.addObject("savePath", savePath);
		mView.setViewName("file/upload");
      
		return mView;
	}
}
