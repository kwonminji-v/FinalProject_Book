import {Outlet, Route, Routes} from 'react-router-dom'
import LogInPage from "./component/USER/LogInPage";
import SignUpPage from "./component/USER/SignUpPage";
import FindMyIdPage from "./component/USER/FindMyIdPage";
import FindMyPwPage from "./component/USER/FindMyPwPage";
import React from "react";
import Header from "./component/USER/Header";
import CategoryHeader from "./component/USER/CategoryHeader";
import TopBtn from "./js/jw_topBtn";
import ScrollTop from "./js/ScrollTop";
import Footer from "./component/USER/Footer";
import Main from "./component/USER/Main";
import MyPageAuth from "./component/USER/MyPageAuth";
import NotFound from "./js/NotFound";
import QnA_Page from "./page/QnA_Page";
import QnA_CreateBoard from "./page/QnA_CreateBoard";
import QnA_DetailBoard from "./page/QnA_DetailBoard";
import QnA_UpdateBoard from "./page/QnA_UpdateBoard";


function App() {

    return (
        <>
            <Header/>
            <CategoryHeader/>
            <TopBtn/>
            <Routes>
                <Route path={"/"} element={<Outlet/>}>
                    <Route path={"home/"} element={<Main/>}/>
                    <Route path={"home/"} element={<Outlet/>}>
                        <Route path={"board"} element={<QnA_Page/>} />
                        <Route path={"board/create-board/"} element={<QnA_CreateBoard />} />
                        <Route path={"board/detail/:id"} element={<QnA_DetailBoard />} />
                        <Route path={"board/update-board/:id"} element={<QnA_UpdateBoard/>} />
                        <Route path={"login/"} element={<LogInPage/>}/>
                        <Route path={"signUp/"} element={<SignUpPage/>}/>
                        <Route path={"findId/"} element={<FindMyIdPage/>}/>
                        <Route path={"findPw/"} element={<FindMyPwPage/>}/>
                        <Route path={"myPage/"} element={<MyPageAuth/>}/>
                    </Route>
                </Route>
            </Routes>
            <ScrollTop/>
            <Footer/>
        </>

    );
}

export default App;
