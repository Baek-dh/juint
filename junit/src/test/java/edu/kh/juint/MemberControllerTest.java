package edu.kh.juint;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

// JUnit에 내장된 Runner 대신 SpringJUnit4ClassRunner를 이용하여 테스트를 수행
@RunWith(SpringJUnit4ClassRunner.class)

//Controller 및 웹 환경에서 사용되는 bean들을 자동으로 생성해서 등록
// == web.xml의 역할
@WebAppConfiguration 

//설정 파일 경로
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
								"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) 
public class MemberControllerTest {

	private Logger logger = LoggerFactory.getLogger(MemberControllerTest.class);
	
	
	@Autowired
	private WebApplicationContext wac; // 현재 실행중인 애플리케이션의 구성을 제공하는 객체
	
	private MockMvc mockMvc;
	// 클라이언트의 요청 내용을 컨트롤러에서 받아서 처리하는 것과 같은 테스트를 진행하는 객체
	
	@Before // JUnit 테스트 진행 전 먼저 수행될 내용을 지정
	public void setup() {
		logger.info("=== 테스트 전 mockMvc 초기화 ===");
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	
	@Test // 테스트용 메소드임을 명시하는 어노테이션
	public void memberLoginTest() { // 로그인 테스트
		
		logger.info("=== 로그인 테스트 시작 ===");
		
		try {
			
			// mockMvc 객체를 이용해 매핑될 주소와 파라미터가 담기 가상의 요청을 작성
			mockMvc.perform( post("/member/login").param("inputId","user01")
												  .param("inputPw", "pass01!"))	
				   .andDo(print()) // 처리된 내용을 출력
				   .andExpect(status().isOk() ); // 응답 상태가 에러가 없는 정상 상태가 되도록 검증
					
			logger.info("=== 로그인 테스트 수행 성공 ===");
			
		}catch(Exception e){
			
			logger.error("=== 로그인 테스트 중 예외 발생 ===");
		}
	}
}







