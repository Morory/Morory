package basAnno;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) throws Exception {
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("basAnnoCTX.xml");
		MbrSrvImpl mbrSvc = (MbrSrvImpl)factory.getBean("mbrSrv");
		
		MemberDTO mbrDto = new MemberDTO();
		mbrDto.setId("sunday");
		mbrDto.setPw("sunday_pw");
		mbrDto.setName("sunday_name");
		mbrDto.setTel("sunday_tel");
		
		System.out.println(mbrSvc.insertMbr(mbrDto));
		
		mbrDto.setId("gold");
		mbrDto.setPw("gold_pw");
		mbrDto.setName("gold_name");
		mbrDto.setTel("gold_tel");
		
		System.out.println(mbrSvc.insertMbr(mbrDto));
		
		System.out.println("-----------------------------");
		MemberDTO dto3 = mbrSvc.getMbr("gold");
		System.out.println(dto3.getId());
		System.out.println(dto3.getPw());
		System.out.println(dto3.getName());
		System.out.println(dto3.getTel());
		System.out.println();
		System.out.println("------------------------------");
		
		dto3.setPw("금_pw");
		dto3.setName("금_name");
		dto3.setTel("금_tel");
		
		System.out.println(mbrSvc.updateMbr(dto3));
		
		List<MemberDTO> list = mbrSvc.getMbrList();
		for(int i=0; i < list.size(); i++)
		{
			MemberDTO dto2 = list.get(i);
			System.out.println(dto2.getId());
			System.out.println(dto2.getPw());
			System.out.println(dto2.getName());
			System.out.println(dto2.getTel());
			System.out.println();
		}
		System.out.println("------------------------------");
		
		System.out.println(mbrSvc.deleteMbr("sunday"));
		
		List<MemberDTO> lst = mbrSvc.getMbrList();
		for(int i=0; i < lst.size(); i++)
		{
			MemberDTO dto2 = lst.get(i);
			System.out.println(dto2.getId());
			System.out.println(dto2.getPw());
			System.out.println(dto2.getName());
			System.out.println(dto2.getTel());
			System.out.println();
		}

		factory.close();

	}

}
