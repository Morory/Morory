package crud;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CrudMain {

	public static void main(String[] args) {
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("crudCTX.xml");
		
		CustomerSrvImpl svc = factory.getBean("cstSrv", CustomerSrvImpl.class);
		
		String gubun, msg;
		Scanner sc = new Scanner(System.in);
		
		while(true) 
		{
			System.out.println("1:조건조회, 2:입력, 3:전화번호변경, 4:삭제, 9:종료 = ");
			gubun = sc.next();
			
			if("9".equals(gubun))
			{
				System.out.println("종료합니다.");
				break;
			}
			if("1".equals(gubun))
			{
				System.out.println("조회할 코드를 입력하세요.");
				System.out.print(" 코드               >>");
				int code = sc.nextInt();
				
				msg = svc.getList(code);
				
				System.out.println(msg);
			}
			if("2".equals(gubun))
			{
				System.out.println("고객 정보를 입력하세요");
				System.out.print(" 코드               >>");
				int code = sc.nextInt();
				System.out.print(" 성명                >>");
				String name = sc.next();
				System.out.print(" 이메일             >>");
				String email = sc.next();
				System.out.print(" 전화번호          >>");
				String tel = sc.next();
				System.out.print(" 체중                >>");
				double weight = sc.nextDouble();
				
				CustomerDTO dto = new CustomerDTO();
				
				dto.setCode(code);
				dto.setEmail(email);
				dto.setName(name);
				dto.setTel(tel);
				dto.setWeight(weight);
				
				msg = svc.insert(dto);
				
				System.out.println(msg);
			}
			if("3".equals(gubun))
			{
				System.out.println("전화번호를 변경할 회원코드를 입력하세요");
				System.out.print(" 코드               >>");
				int code = sc.nextInt();
				System.out.print(" 전화번호          >>");
				String tel = sc.next();
				
				msg = svc.update(code, tel);
				
				System.out.println(msg);
			}
			if("4".equals(gubun))
			{
				System.out.println("삭제할 회원코드를 입력하세요");
				System.out.print(" 코드               >>");
				int code = sc.nextInt();
				
				msg = svc.delete(code);
				
				System.out.println(msg);
			}
			
		}
		sc.close();
		factory.close();
	}

}
