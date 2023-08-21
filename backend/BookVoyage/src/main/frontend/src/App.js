import {Outlet, Route, Routes} from 'react-router-dom'
import MainPage from "./component/MainPage";
import LogInPage from "./component/LogInPage";
import SignUpPage from "./component/SignUpPage";
import MyPage from "./component/MyPage";
import MyPageAuth from "./component/MyPageAuth";
import FindMyIdPage from "./component/FindMyIdPage";
import FindMyPwPage from "./component/FindMyPwPage";
import {useEffect, useState} from "react";
import QnAPage from "./page/QnA_Page";
import QnA_CreateBoard from "./page/QnA_CreateBoard";

function App() {

  return (
      <Routes>
        <Route path={"/"} element={<MainPage/>}></Route>
        <Route path={"login/"} element={<LogInPage/>}></Route>
        <Route path={"signUp/"} element={<SignUpPage/>}></Route>
        <Route path={"findId/"} element={<FindMyIdPage/>}></Route>
        <Route path={"findPw/"} element={<FindMyPwPage/>}></Route>
        <Route path={"myPage/"} element={<MyPage/>}></Route>
        <Route path={"myPage/"} element={<MyPageAuth/>}></Route>
        <Route path={"QnAPage/"} element={<QnAPage/>}>
            <Route path={"QnA_CreateBoard"} element={<QnA_CreateBoard />}></Route>
        </Route>
      </Routes>

  );
}

export default App;
