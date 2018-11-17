### Buttons in button bars should be borderless..
경고를 해결하는 방법 2가지  

1. 경고 무시하고 경고 끄기   
AndroidStudio 사용자의 경우,  
파일 -> 설정 -> 편집기 -> 검사 -> Android Lint. "borderless"을 검색하고 심각도를 선택 취소하거나 변경  
  
2. 경고 해결하기  
button에 아래의 코드 추가  
```style="?android:attr/borderlessButtonStyle"```  

-> 2번째 방법을 선택했습니다.  
  
  
### HardCode 경고 해결   
Values의 strings.xml 파일에 (예시) ```<string name="botton1">7</string>``` 와 같이 작성한다.   
activity_main.xml 파일의 button의 text속성을 (예시) ``` "@string/botton1”``` 로 입력한다.  
문자열 리소스 파일을 사용한 이유 : [\[참고\] developer.android](https://developer.android.com/guide/topics/resources/localization)   
  
계산기 어플의 경우 text 변경사항이 크게 없지만 한가지 예를 들자면,  
다국어를 지원하는 앱의 경우 리소스의 소스 코드를 분리시키는 것이 관리에 효율적이다.  

 
### [EditText] 키보드 / 커서 숨기기  
Activity_main.xml 의 EditText 태그에 inputType 속성은 삭제하고 아래의 코드를 작성한다.  
```android:focusable="false"```  
```android:cursorVisible="false"```  
-> 사용자에게 키보드가 아닌 버튼으로 입력을 받고, 중간에 수정할 수 없도록하기 위함.  
(첫번째 코드만 작성하면 롱클릭 시 focus가 생긴다. 두 코드를 전부 작성해야 focus 자체가 생성되지 않는다.)   
  
* * *  
  
### Java   
        
```
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```
      
- onCreate()   
onCreate()는 Activity가 최초 생성할 때 호출됩니다.       
초기화 설정을 하는 곳으로 보관된 상태의 Activity가 있으면, 그 상태를 저장중인 Bundle객체를 받아서 사용합니다.        
onCreate()가 호출된 후에는 onStart()가 호출되는데 이 때에는 강제종료가 불가능합니다.       

- class Bundle      
 액티비티간에 데이터를 전달하기 위해 사용됩니다.      
 인텐트 안에 들어 있기 때문에 putXXX()와 getXXX()를 통해 데이터를 넣거나 얻을 수 있습니다.      
 이전 액티비티에서 새로운 액티비티로 전환되었을 때 이전 액티비티의 상태 정보를 가지고 있다.        
   
- 인텐트     
인텐트는 A Activity에서 어떤 동작이 발생하면, B Activity를 실행하는 화면 전환의 기능을 할 수 있다.    
A Activity에서 발생하는 어떤 형태의 데이터(int,String,char,float,array...etc)를 B Activity로 넘길 수 있다.     

- Activity  
안드로이드 Activity는 화면에 표시되는 UI구성을 위해 가장 기본이 되는 요소입니다.   
안드로이드 앱은 화면에 UI를 표시하기 위해 최소 하나의 Activity를 가져야 하며, 앱 실행 시 지정된 Activity를 실행하여 사용자에게 UI를 표시하게 됩니다.   

- findviewbyid  
Activity에서 XML의 View를 매칭하고자 할 때에는 findViewById를 사용합니다.  

* * *

### calculator 프로젝트에서 사용하는 위젯 : Button
이벤트를 처리하는 방법 
>1. XML 파일에 이벤트 처리 메소드를 등록하는 방법
>2. 이벤트를 처리하는 객체를 생성하여 이벤트를 처리하는 방법
>3. 뷰 클래스의 이벤트 처리 메소드를 재정의하는 방법 (커스텀 뷰를 작성하는 경우에만 사용가능)

#### (1) XML 파일에 이벤트 처리 메소드를 등록하는 방법
레이아웃안의 Button 요소에 onClick 속성을 추가한다.   
클릭 이벤트가 발생하면 onClick 속성에 저장된 메소드가 호출된다.     
버튼을 가지고 있는 액티비티는 이 메소드를 구현해야 한다.    

메소드 3가지 조건      
>1. Public 이어야 한다.    
>2. Void 반환형을 가진다.     
>3. View를 메소드의 인수로 가진다. 클릭된 view 객체가 전달된다.      
   
#### (2) 이벤트 처리 객체를 이용하여 이벤트 처리하기 
객체를 생성하여 위젯에 등록하는 방법이다.     
이벤트를 처리하는 객체는 이벤트를 처리하는 메소드를 가지고 있어야 한다.    

이벤트를 처리하는 메소드들이 정의된 인터페이스를 이벤트 리스너(event listener) 라고 부른다.   
이벤트가 발생하면 등록된 이벤트 리스너 안의 콜백 메소드가 자동적으로 호출된다.   


```
Class Listener implements OnClickListener{
      Public void onClick(View v){
                 // 생략
      }
}
// 생략                       
Listener lis = new Listener();
Button.setOnClickListener(lis);
```  
  
리스너 객체를 생성하는 방법   
>1. 리스너 클래스를 내부 클래스로 정의한다.   
>2. 리스너 클래스를 무명 클래스로 정의한다.   
>3. 리스너 인터페이스를 액티비티 클래스에 구현한다.   
>( 리스너 클래스를 내부 클래스로 정의할 수 있다. 내부 클래스란 클래스 안에 정의된 클래스를 의미한다.     
내부 클래스는 자신이 속해있는 클래스의 멤버들에 자유롭게 접근하여 사용할 수 있다는 장점이 있다. )   
  
   
### 버튼 클릭 시 EditText에 출력  
(Button)AC를 누르면 이전 결과(TextView)는 그대로 유지되고 입력했던 것 전부가 삭제된다.  
```
class MyListener implements View.OnClickListener{
        public void onClick(View v){
            final EditText e = (EditText)findViewById(R.id.e); 
            String buttonStr = ((Button)v).getText().toString(); // 버튼이 가진 문자열을 buttonStr에 저장

            if(buttonStr.equals("AC")) { // AC 누르면 전부 삭제
                e.setText(""); // EditText에 Hint만 나오게..
                s = ""; // s도 초기화 시켜준다. 
            }
            else {
                s += buttonStr; // s는 MainActivity 클래스의 private 인스턴스 변수로 선언했다. 
                e.setText(s); // EditText에 연산과정 전부 출력
            }
        }
    }
```      
   
### StringTokenizer
StringTokenizer는 긴 문자열을 지정된 구분자를 기준으로 문자열을 슬라이싱하는데 사용된다.  
 
Q. split과의 차이점은 ?   
Answer)   
split : String 클래스의 메소드로 추출한 문자를 배열로 저장  
StringTokeniser : 메소드가 아니라 java.util에 포함되어 있는 자체 클래스  
  
#### 생성자/메소드     
- StringTokeniser(String str, String delim) : 문자열을 지정된 구분자로 나누는 Stringtokennizer를 생성한다.   
- StringTokenizer(String str, String delim, boolean returnDelims) : 구분자도 토큰으로 간주  
- int countTokens() : 전체 토큰으로 간주   
- boolean hasMoreTokens() : 토큰이 남았는지 알려준다.  
- String nextToken() : 다음 토큰을 반환한다.  
   
   * * * 
      
### 계산기 로직
#### 수식의 표기법     
- 중위 표기법  - 피연산자 사이에 연산자가 존재 
- 전위 표기법  - 각 피연산자 왼쪽에 연산자가 존재
- 후위 표기법  -  피연산자 오른쪽에 연산자들이 존재  
  
프로젝트에서는 사용자에게 중위 표기법으로 입력받아 후위 표기법으로 변환 후 결과를 출력한다.   
   
#### (괄호없는) 중위 표기법 -> 후위 표기법 변환 과정  
1. 사용자에게 입력 받은 수식에서 맨 왼쪽부터 하나씩 처리한다.  
2. 피연산자는 일단 후위 표기법을 저장하는 곳에 순서대로 저장한다.   
3. 연산자는 연산자 대기 공간(스택)에 저장한다. 연산자를 스택에 넣을 때 기존 연산자가 존재하면 정의한 연산자 우선순위에 따라 다르게 처리한다.  
- 스택에 있는 기존 연산자가 우선순위가 높거나 같을 경우 - 기존 연산자는 스택에서 빠져나와 후위 표기법에 저장,새로운 연산자는 스택에 저장   
- 스택에 있는 기존 연산자의 우선순위가 낮을 경우 - 기존 연산자는 그대로 두고 새로운 연산자도 스택에 저장  
4. 더이상 수식이 없으면 스택에 있는 연산자를 후위 표기법에 저장   
<구현결과>  
![Alt text]()
