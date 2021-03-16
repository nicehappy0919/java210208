package constructor.step4;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
//생성자 파라미터 활용 연습
//인스턴스화 이전에 반드시 생성자 확인할 것. API(Application Programming Interface)를를 통해서
/* new JFrame();
 * new JFrame("타이틀"); 파라미터의 갯수가 다르거나 파라미터의 종류가 다른 경우에는 이름이 같더라도 서로다른 생성자가 가능하다.
 * new JComboBox();
 * new JComboBox(String[]);
 * new JComboBox(String); ==>>이것은 불법이다.
 * 대분류
 * 중분휴
 * 소분류
 */
public class JComboBoxTest1 extends JFrame implements ItemListener{
	//선언부
	JPanel      jp_north   = null;
	JComboBox   jcb_top    = null;
	JComboBox   jcb_mid    = null;
	JComboBox   jcb_bottom = null;
	String      totals[]        = {"전체"};
	String      top				= null;//가전|컴퓨터|모바일
	String      mid				= null;//가전이라면)) 주방가전, 생활가전, 계절가전
	String		bottom			= null;//주방가전이라면))냉장고,전기밥솥,에어프라이어
	String    	top_item[] 		= {"전체","가전","컴퓨터","모바일"};
	String 		mid_item0[] 	= {"전체","주방가전","생활가전","계절가전"};
	String 		mid_item1[] 	= {"전체","노트북","브랜드PC","모니터"};
	String 		mid_item2[] 	= {"전체","태블릿","휴대폰","스마트워치"};
	String 		bottom_item0[] 	= {"전체","냉장고","전기밥솥","에어프라이어"};
	String 		bottom_item1[] 	= {"전체","세탁기","옷건조기","청소기"};
	String 		bottom_item2[] 	= {"전체","온수매트","선풍기","에어컨"};
	//생성자
	public JComboBoxTest1() {
		jp_north = new JPanel();
		//super("대중소분류 실습"); //super -> JFrame 생성자의 가장 처음에 와야한다.
		jcb_top    = new JComboBox(top_item); //콤보박스안에 아직 생성자가 없다.
		jcb_mid    = new JComboBox(totals);
		jcb_bottom = new JComboBox(totals);
		initDisplay();
	}
	//화면 처리부
	public void initDisplay() {
		jcb_top.addItemListener(this);
		jcb_mid.addItemListener(this);
		jcb_bottom.addItemListener(this);
		jp_north.setBackground(Color.orange);
		jp_north.add(jcb_top);
		jp_north.add(jcb_mid);
		jp_north.add(jcb_bottom);
		this.add("North",jp_north);
		this.setTitle("대중소분류 실습");
		this.setSize(500,400);
		this.setVisible(true);
	}
	//메인메소드 선언
	public static void main(String[] args) {
		new JComboBoxTest1(); //생성자를 경유하고 생성자에서 화면처리 메소드 호출해보기 - 시점 문제에 대해 같이 고민.

	}
	//ItemListener라는 인터페이스에 정의된 추상메소드이다.
	//어떤 콤포넌트에 사용될지 모르므로 구현을 할 수 없다.
	//따라서 구현체 클래스에서 재정의 하여 사용한다.
	//인터페이스는 보통 공통 메소드를 정의하여 재사용성과 다형성을 지원함.
	//결합도를 낮추어서 단위테스트, 통합테스트를 가능하게 하고 그러면서도 재사용성은 높임.
	@Override
	public void itemStateChanged(ItemEvent ie) { //콜백메소드이다.-시스템레벨에서 이벤트가 감지되었을때 호출된다.
		//이벤트 감지된 컴포턴트의 주소번지를 얻는다.
		Object obj = ie.getSource();
		//이벤트가 감지된게 혹시 콤보박스야?
		if(obj == jcb_top) {
			//콤보박스에서 상태가 바뀐 선택된 인덱스 값이 같니?
			//if(ie.getStateChange() == 0) 이렇게 써도 값은 같으나 이렇게 쓰지 않는다.
			if(ie.getStateChange() == ItemEvent.SELECTED) {//타입.속성명 - 하나다.
				//그 선택된 인덱스 값으로 배열안에서 선탟된 문자열을 top에 저장함.
				top = top_item[jcb_top.getSelectedIndex()]; //0:가전 1:컴터 2:모바일
				jcb_mid.removeAllItems();//기존에 totals에 있던 전체를 삭제하고 새로운 아이템으로 변경 준비
				if("가전".contentEquals(top)) {
				//if(top.contentEquals("가전")) => 이렇게 쓰면 초짜.
					for(int i=0;i<mid_item0.length;i++) {
						jcb_mid.addItem(mid_item0[i]);
					}
				}
				else if("컴퓨터".contentEquals(top)) {
					for(int i=0;i<mid_item1.length;i++) {
						jcb_mid.addItem(mid_item1[i]);
					}
				}
				else if("모바일".contentEquals(top)) {
					for(int i=0;i<mid_item2.length;i++) {
						jcb_mid.addItem(mid_item2[i]);
					}
				}
			}
		}
		else if(obj == jcb_mid) {
			if(ie.getStateChange() == ItemEvent.SELECTED) {
				//top이 가전이니?
				if("가전".equals(top)) {
					mid = mid_item0[jcb_mid.getSelectedIndex()];
					if("주방가전".equals(mid)) {
						jcb_bottom.removeAllItems();
						for(int i=0;i<bottom_item0.length;i++) {
							jcb_bottom.addItem(bottom_item0[i]);
						}
					}
					else if("생활가전".equals(mid)) {
						jcb_bottom.removeAllItems();
						for(int i=0;i<bottom_item0.length;i++) {
							jcb_bottom.addItem(bottom_item1[i]);
						}
					}
					}
					else if("계절가전".equals(mid)) {
						jcb_bottom.removeAllItems();
						for(int i=0;i<bottom_item0.length;i++) {
							jcb_bottom.addItem(bottom_item2[i]);
						}
					}
			}
		}
		else if(obj == jcb_bottom) {
			
		}
	}//////////////////////end of itemStateChanged

}
