import {Outlet, Route, Routes, useParams} from 'react-router-dom'
import QnAPage from "./page/QnA_Page";
import QnA_CreateBoard from "./page/QnA_CreateBoard";
import QnA_DetailBoard from "./page/QnA_DetailBoard";
import QnA_UpdateBoard from "./page/QnA_UpdateBoard";
import ScrollTop from "./js/ScrollTop";
import Footer from "./component/USER/Footer";
import Header from "./component/USER/Header";
import CategoryHeader from "./component/USER/CategoryHeader";
import TopBtn from "./js/jw_topBtn";
import React from "react";
import Main from "./component/USER/Main";


function App() {



    return (
        <>
        <Header/>
    <CategoryHeader/>
    <TopBtn/>
    <Routes>
        <Route path={"/"} element={<Outlet/>}>
            <Route path={"home"} element={<Main/>}/>
            <Route path={"/home/board"} element={<QnAPage/>} />
            <Route path={"/home/board/create-board/"} element={<QnA_CreateBoard />} />
            <Route path={"/home/board/detail/:id"} element={<QnA_DetailBoard />} />
            <Route path={"/home/board/update-board/:id"} element={<QnA_UpdateBoard/>} />
{/*            <Route path={"home"} element={<Outlet/>}>
                <Route path={"login/"} element={<LogInPage/>}/>
                <Route path={"signUp/"} element={<SignUpPage/>}/>
                <Route path={"findId/"} element={<FindMyIdPage/>}/>
                <Route path={"findPw/"} element={<FindMyPwPage/>}/>
                <Route path={"myPage/"} element={<MyPageAuth/>}/>
            </Route>*/}
        </Route>
    </Routes>
    <ScrollTop/>
    <Footer/>

{/*       <Routes>
            <Route path={"/home"} element={<MainPage/>}></Route>
            {/!*        <Route path={"login/"} element={<LogInPage/>}></Route>
        <Route path={"signUp/"} element={<SignUpPage/>}></Route>
        <Route path={"findId/"} element={<FindMyIdPage/>}></Route>
        <Route path={"findPw/"} element={<FindMyPwPage/>}></Route>
        <Route path={"myPage/"} element={<MyPage/>}></Route>
        <Route path={"myPage/"} element={<MyPageAuth/>}></Route>*!/}
            <Route path={"/board"} element={<QnAPage/>} />
            <Route path={"/board/create-board/"} element={<QnA_CreateBoard />} />
            <Route path={"/board/detail/:id"} element={<QnA_DetailBoard />} />
            <Route path={"/board/update-board/:id"} element={<QnA_UpdateBoard/>} />
        </Routes>*/}
    </>

);
}

export default App;
