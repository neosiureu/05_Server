// 제목이 작성되지 않은 경우 form의 제출을 막자. 
// 다만 상세내용인 textarea말고 title만 신경쓴다

// form태그에는 submit이라는 이벤트가 붙어있다

const addForm = document.querySelector("#addForm"); //form태그의 값을 얻어옴
const title = document.querySelector("[name='title']") // 제목 콜론 옆에 있던 놈

// addForm이 제출될 때 수행할 일

addForm.addEventListener("submit", (e)=>{
                // 이벤트 객체를 얻어오기 위한 e. submit 눌렀을 때의 모든 정보

  // 제목이 입력됐는지 여부를 가져옴. 다만 양쪽 공백을 제거 => 스페이스를 여러번 누르면 제출이 못되게 막기

  const input = title.value.trim();

  // 제목이 입력되지 않았을 때

  if(input.length===0){
    // form태그에서 일어나는 제출이라는 event를 막는다
    e.preventDefault();

    alert("제목을 필수적으로 입력해주세요")
    title.focus(); // 입력하기 좋게
  }
   
} );




