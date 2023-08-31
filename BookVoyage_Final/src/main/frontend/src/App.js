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
import MyPageAuth from "./component/USER/MyPageAuth";
import BookListPage from "./pages/ListPage/index";
import BookDetailPage from "./pages/DetailPage/index";
import FilteredBookList from "./component/FilteredBookList";
import SearchResults from "./pages/SearchPage/index";
import MainPage from "./pages/MainPage/index";
<<<<<<< HEAD
import CartPage from './pages/CartPage';
import PurchasePage from "./pages/PurchasePage/PurchasePage";
import QnA_Page from "./pages/Board/QnA_Page";
import QnA_CreateBoard from "./pages/Board/QnA_CreateBoard";
import QnA_DetailBoard from "./pages/Board/QnA_DetailBoard";
import QnA_UpdateBoard from "./pages/Board/QnA_UpdateBoard";

=======
import QnA_CreateBoard from "./pages/board/QnA_CreateBoard";
import QnA_Page from "./pages/board/QnA_Page";
import QnA_DetailBoard from "./pages/board/QnA_DetailBoard";
import QnA_UpdateBoard from "./pages/board/QnA_UpdateBoard";
>>>>>>> 2ad0b09e9a1ff773062c6cc4a97723b9f2a5f9d8


function App() {

    return (
        <>
            <Header/>
            <CategoryHeader/>
            <TopBtn/>
            <Routes>
                <Route path={"/"} element={<Outlet/>}>
                    <Route path={"home/"} element={<Outlet/>}>
                        <Route index element={<MainPage />} />
                        <Route path={"login/"} element={<LogInPage/>}/>
                        <Route path={"signUp/"} element={<SignUpPage/>}/>
                        <Route path={"findId/"} element={<FindMyIdPage/>}/>
                        <Route path={"findPw/"} element={<FindMyPwPage/>}/>
                        <Route path={"myPage/"} element={<MyPageAuth/>}/>
                        <Route path={"board/"} element={<QnA_Page/>} />
                        <Route path={"board/create-board/"} element={<QnA_CreateBoard />} />
                        <Route path={"board/detail/:id"} element={<QnA_DetailBoard />} />
                        <Route path={"board/update-board/:id"} element={<QnA_UpdateBoard/>} />
<<<<<<< HEAD
                        <Route path="booklist" element={<BookListPage />}></Route>
                        <Route path="novels/" element={<FilteredBookList category="소설/시/희곡" />} />
                        <Route path="economics/" element={<FilteredBookList category="경제경영" />} />
                        <Route path="developments/" element={<FilteredBookList category="자기계발" />} />
                        <Route path="children/" element={<FilteredBookList category="어린이" />} />
                        <Route path="foreign/" element={<FilteredBookList category="외국어" />} />
                        <Route path="search/" element={<SearchResults />} />
                        <Route path="purchase/" element={<PurchasePage />} />
                        <Route path="bookdetail/:isbn13" element={<BookDetailPage />} />
                        <Route path="cart/" element={<CartPage />} />
=======
                        <Route path={"booklist/"} element={<BookListPage />}></Route>
                        <Route path={"novels/"} element={<FilteredBookList category="소설/시/희곡" />} />
                        <Route path={"economics/"} element={<FilteredBookList category="경제경영" />} />
                        <Route path={"developments/"} element={<FilteredBookList category="자기계발" />} />
                        <Route path={"children/"} element={<FilteredBookList category="어린이" />} />
                        <Route path={"foreign/"} element={<FilteredBookList category="외국어" />} />
                        <Route path={"search/"} element={<SearchResults />} />
                        <Route path={"bookdetail/:isbn13/"} element={<BookDetailPage />} />
>>>>>>> 2ad0b09e9a1ff773062c6cc4a97723b9f2a5f9d8
                    </Route>

                </Route>
            </Routes>
            <ScrollTop/>
            <Footer/>
        </>

    );
}

export default App;
