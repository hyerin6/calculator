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
문자열 리소스 파일을 사용한 이유 :   
[\[참고\] developer.android](https://developer.android.com/guide/topics/resources/localization)   
  
계산기 어플의 경우 text 변경사항이 크게 없지만 한가지 예를 들자면,  
다국어를 지원하는 앱의 경우 리소스의 소스 코드를 분리시키는 것이 관리에 효율적이다.  

 
### [EditText] 키보드 / 커서 숨기기  
Activity_main.xml 의 EditText 태그에 inputType 속성은 삭제하고 아래의 코드를 작성한다.  
```android:focusable="false"```  
```android:cursorVisible="false"```  
-> 사용자에게 키보드가 아닌 버튼으로 입력을 받고, 중간에 수정할 수 없도록하기 위함.  
(첫번째 코드만 작성하면 롱클릭 시 focus가 생긴다. 두 코드를 전부 작성해야 focus 자체가 생성되지 않는다.)   


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


