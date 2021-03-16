/*package com.pattern;

import java.util.Vector;

import com.vo.DeptVO;
import com.vo.EmpVO;

public class SalaryMgrLogic {
	public void getEmpDetail(int pempno) {
		EmpVO  eVO = new EmpVO(); //여기부터 꼭 복습!!!!!!
		eVO.setEname("이순신");
		DeptVO dVO = new DeptVO();
		dVO.setDname("개발1팀");
		eVO.setdVO(dVO); //issue
		//java.util에서 제공되는 클래스로 타입에 대한 제약없이 늘었다 줄었다 함.
		//연관있는 레코드를 한번에 밀어넣기 위해서 사용함.
		Vector oneRow = new Vector();
		//oneRow.addElement(eVO.getEname());
		//oneRow.addElement(eVO.getdVO().getDname());
		oneRow.addElement("");
		oneRow.addElement("");
		dtm_sal.addRow(oneRow);
	}
}
*/

package com.pattern;

import java.util.Vector;

import com.vo.DeptVO;
import com.vo.EmpVO;

public class SalaryMgrLogic {
   SalaryMgrView smView = null;
   public SalaryMgrLogic(SalaryMgrView salaryMgrView) {
      this.smView = salaryMgrView;
   }

   public void getEmpDetail(int pempno) {
      EmpVO  eVO  = new EmpVO();
      eVO.setEname("김유신");
      DeptVO dVO  = new DeptVO();
      dVO.setDname("형상관리팀");
      eVO.setdVO(dVO);//issue
      Vector oneRow = new Vector();
      oneRow.addElement(eVO.getEname());
      oneRow.addElement(eVO.getdVO().getDname());///////////////////확인
      smView.dtm_sal.addRow(oneRow);   
   }///////////////////end of getEmpDetail
}
