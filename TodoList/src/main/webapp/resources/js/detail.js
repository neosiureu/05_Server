// 목록으로 버튼 클릭 시 "/"로 이동하겠다. get요청

const goToList= document.querySelector("#goToList");

// 목록으로 버튼이 클릭된 경우
goToList.addEventListener("click", () => {
  // 버튼이 클릭되면 그 때 get방식 요청을 보낸다.
  location.href = "/";
  // 기본 객체 중 자바스크립트 내장 객체가 location 객체에 href라는 필드가 있는데 특정 주소 값을 대입하면 그걸로 get방식으로 가게 함

  //JS를 통한 페이지 이동 방법


  // 할일 상세 조회 페이지에 대해서 쿼리스트링의 값을 반드시 얻어와야 한다

  // url에서 얻어오면 된다! (쿼리스트링 부분: ?로 시작하여 ?todoNo=6)
  // location.serach: 쿼리스트링만 얻을 수 있다


  // 수정이나 삭제, 할일 완료 버튼으로 처리하기 위해: 
  // ?todoNo=5기 꼭 필요하기 때문에 .serach가 필요하다. 하지만 여러 키값이 있을 수 있어서 만능이 아니다.

  //URLSerachParams(location.search) => 각각의 키와 값을 다 파악하여 
  // 가령 todoNo=6 name=3 과 같이 알아서 매핑해 줌
})


  const todoNo = new URLSearchParams(location.search).get("todoNo");
  // const todoNo = new URLSearchParams(location.search).get("todoNo");


  // .get("키") => 값

  console.log(todoNo);


  //완료여부 변경

  const completeBtn = document.querySelector("#completeBtn");

  completeBtn.addEventListener("click",() => {
    // 현재 보고 있는 Todo의 완료 여부를 O라면 X로 , X라면 O로 변경. 즉 GET요청을 보낸다
    // location.href = `/todo/complete?todoNo= ${todoNo}`;
    location.href = "/todo/complete?todoNo="+ todoNo;
  });


  const deleteBtn = document.querySelector('#deleteBtn');

  deleteBtn.addEventListener("click",()=>{
    location.href="/todo/deleteServlet";
  })