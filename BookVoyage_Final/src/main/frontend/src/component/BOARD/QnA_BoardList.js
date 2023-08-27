import {Link} from "react-router-dom";
import {React, useEffect, useState} from "react";
import QnA_BoardBox from "./QnA_BoardBox";
import axios from "axios";
import '../../css/board.css';


const QnA_BoardList = (props) => {

    const {data, currentPage, totalPages, handlePageChange} = props;

    const authenticate= ()=>{
        axios.get("/api/board/board-list/create-board/authenticate").then(()=>{
            window.location.href="board/create-board/"
        }).catch(e=>{
            alert("로그인이 필요한 서비스입니다.")
            window.location.href="/home/logIn"
            console.error(e);
        })
    }

    return (
        <>
            <div className="container text-center" style={{paddingTop: ' 100px', border: '2px solid black'}}>
                <h1 className="mt-5">문의 게시판</h1>
                <div className="row justify-content-center mt-5">
                    <div className="col-md-12">
                        <table className="table table-bordered table-hover shadow-lg">
                            <thead>
                            <tr>
                                <th>번호</th>
                                <th>카테고리</th>
                                <th>제목</th>
                                <th>내용</th>
                                <th>작성자</th>
                                <th>조회수</th>
                                <th>작성 일자</th>
                            </tr>
                            </thead>
                            <tbody>
                            {Array.isArray(props.data) && props.data.length !== 0 ? (
                                props.data.map((i, index) => (
                                    <QnA_BoardBox
                                        key={i.id}
                                        id={i.id} //게시글 번호 역순으로 생성
                                        title={i.title}
                                        category={i.category}
                                        content={i.content.replace(/<[^>]+>/g, '')}
                                        writer={i.writer}
                                        view={i.view}
                                        regDate={i.regDate.toLocaleString()}
                                    />
                                ))
                            ) : (
                                <tr>
                                    <td colSpan="8">존재하는 게시글이 없습니다.</td>
                                </tr>
                            )}
                            </tbody>
                        </table>
                        <div className="container text-center">
                            <div className="button-container mt-3 d-flex justify-content-center">
                                <button
                                    className="page-button"
                                    onClick={() => handlePageChange(0)} // Go to first page
                                >
                                    &lt;&lt; {/* prev 화살표 */}
                                </button>
                                <button
                                    className={`page-button ${currentPage === 0 ? 'disabled' : ''}`}
                                    onClick={() => handlePageChange(currentPage - 1)} // Go to previous page
                                >
                                    &lt; {/* prev 페이지 */}
                                </button>
                                {Array.from({ length: totalPages }, (_, index) => index).map((page) => (
                                    <button
                                        key={page}
                                        className={`page-button ${page === currentPage ? 'active' : ''}`}
                                        onClick={() => handlePageChange(page)}
                                    >
                                        {page + 1}
                                    </button>
                                ))}
                                <button
                                    className={`page-button ${currentPage === totalPages - 1 ? 'disabled' : ''}`}
                                    onClick={() => handlePageChange(currentPage + 1)} // Go to next page
                                >
                                    &gt; {/* next 페이지 */}
                                </button>
                                <button
                                    className="page-button"
                                    onClick={() => handlePageChange(totalPages - 1)} // Go to last page
                                >
                                    &gt;&gt; {/* next 화살표 */}
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

                    <input onClick={authenticate} type="button" className="btn btn-success mt-4" value="게시글 작성하기"/>

            </div>
        </>
    );
};

export default QnA_BoardList;
