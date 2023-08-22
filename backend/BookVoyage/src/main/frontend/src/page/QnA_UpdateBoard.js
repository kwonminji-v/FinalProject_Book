import {React, useEffect, useState} from "react";
import axios from "axios";
import {useNavigate, useLocation, useParams} from "react-router-dom";

const QnA_UpdateBoard = () => {

    const [title, setTitle] = useState("");
    const [category, setCategory] = useState("");
    const [content, setContent] = useState("");
    const [regDate, setRegDate] = useState(new Date());
    let location = useLocation();
    let navigate = useNavigate();
    const { id} = useParams();
    console.log('업데이트 = ', id);
    console.log('UpdateBoard/location.state : ', location.state);

    /** 수정할 값들 / 수정하기 버튼을 누를 때의 값 */
    const pre_title = location.state.title;
    const pre_category = location.state.category;
    const pre_content = location.state.content;
    const pre_writer = location.state.writer;
    const pre_regDate = location.state.regDate;


    const resetInput = () => {
        setTitle("");
        setCategory("");
        setContent("");
        document.getElementById('title_input').value = ' ';
        document.getElementById('category_input').value = ' ';
        document.getElementById('content_text').value = ' ';
    }

    const handleEditClick = async (e) => {
        e.preventDefault();
        document.getElementById('title_input').value = ' ';
        document.getElementById('category_input').value = ' ';
        document.getElementById('content_text').value = ' ';
        console.log('게시글 작성')
        const request_data = {id: id, title:title, category:category, content:content, regDate:regDate};
        console.log("업데이트 아이디" + id);

        /** 수정하기 버튼을 누름과 동시에 api에 요청할 작업 */
         try {
             let response = await axios({
                method : 'put',
                url:`/api/board/update-board`,
                headers: {'Content-Type' : 'application/json'},
                data: JSON.stringify(request_data)

            });
             navigate(`/board/detail/${id}`);
             console.log("response 내놔 = " , response);
         } catch (err) {
             console.log("게시글 생성 에러",  err);
             resetInput();
         }
    }

    useEffect(() => {
        setTitle(pre_title);
        setCategory(pre_category);
        setContent(pre_content);
        setRegDate(pre_regDate);
    }, [])

    return (
        <>
            <div className="container mt-5">
                <div className="form">
                    <div className="col-md-6 mb-4">
                    <label htmlFor="title_input">글 제목</label>
                        <input
                        id="title_input"
                        type="text"
                        className="form-control"
                        placeholder="수정할 제목을 입력해주세요"
                        value={title}
                        onChange={(e) => {
                            setTitle(e.target.value)
                            console.log(title);}}
                    />

                    </div>
                    <div className="col-md-6 mb-4">
                    <label htmlFor="category_input">카테고리</label>
                        <select
                            id="category_input"
                            className="form-control"
                            value={category}
                            onChange={(e) => setCategory(e.target.value)}
                        >
                            <option value="">카테고리 선택</option>
                            <option value="주문 및 배송">주문 및 배송</option>
                            <option value="교환 및 환불">교환 및 환불</option>
                            <option value="회원 가입">회원 가입</option>
                            <option value="도서 예약">도서 예약</option>
                        </select>
                    </div>

                    <div className="col-md-6 mb-4">
                    <label htmlFor="content_text">글 내용</label>
                    <textarea
                        id="content_text"
                        className="form-control"
                        placeholder="수정할 내용을 입력하세요."
                        value={content}
                        onChange={(e) => setContent(e.target.value)}
                    />
                    </div>

                    <div className="col-md-6 mb-4">
                    <p>작성자: {pre_writer}</p>
                    <button
                        type="button"
                        className="btn btn-success"
                        onClick={handleEditClick}
                    >
                        게시글 수정
                    </button>
                    </div>
                </div>
            </div>
        </>
        )
    }

export default QnA_UpdateBoard;