# Buttons in button bars should be borderless..
경고를 해결하는 방법 2가지  

1. 경고 무시하고 경고 끄기   
AndroidStudio 사용자의 경우,  
파일 -> 설정 -> 편집기 -> 검사 -> Android Lint. "borderless"을 검색하고 심각도를 선택 취소하거나 변경  
  
2. 경고 해결하기  
button에 아래의 코드 추가  
```style="?android:attr/borderlessButtonStyle"```  

-> 2번째 방법을 선택했습니다.  
