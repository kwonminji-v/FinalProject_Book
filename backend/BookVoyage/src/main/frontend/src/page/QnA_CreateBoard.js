import React, { useEffect, useState } from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";

const QnA_CreateBoard = () => {

    const [title, setTitle] = useState("");
    const [category, setCategory] = useState("");
    const [content, setContent] = useState("");
    const [writer, setWriter] = useState("");
    const [regDate, setRegDate] = useState(new Date());
    const [modDate, setModDate] = useState(new Date());
    const [isCollapsed, setIsCollapsed] = useState(true);

    let navigate = useNavigate();  // 다른 Component들로 이동 시에 사용 (Link는 a 태그 개념, Navigation은 함수 실행이 끝나면서, 이동 발생)

    //입력값을 초기화를 가능하게 해주는 메서드
    const resetInput = () => {
        // 입력 필드의 상태(state)를 초기화합니다.
        setCategory("");
        setTitle("");
        setContent("");
        setWriter("");
        // HTML 문서의 해당 요소에 빈 값을 설정하여 입력 필드를 초기화합니다.
        document.getElementById('category_input').value = ' ';
        document.getElementById('title_input').value = ' ';
        document.getElementById('content_text').value = ' ';
        document.getElementById('writer_input').value = ' ';

    }

    const handleInputCheck = async(e) => {
        e.preventDefault();
        /** 사용할 입력 필드 초기화 - 새 게시글 작성 시 기존의 입력 내용이 지워지고 새로운 데이터 입력*/
        document.getElementById('category_input').value = ' ';
        document.getElementById('title_input').value = ' ';
        document.getElementById('content_text').value = ' ';
        document.getElementById('writer_input').value = ' ';
        console.log('게시글 작성');

        /** 요청할 데이터 객체 생성 */
        const request_data = {title : title, category:category, content: content, writer:writer};
        console.log("요청한 데이터", request_data);

        try {
            /** 게시글 생성 요청 전송 */
            let response = await axios({
                method: 'post',
                url: '/api/create-board',
                headers : {"Content-Type": 'application/json'}, //JSON형식의 데이터 전송 명시
                data : JSON.stringify(request_data)
            });

            console.log("게시글 작성하기의 응답", response);
            console.log("게시글 작성하기 응답에 대한 상태" + response.status);

            /** 응답에 따라 알럿창으로 알림 */
            if (response.status >= 200 && response.status <= 300) {
                alert("게시글이 정상적으로 생성되었습니다.")
            }
            if (response.status >= 400) {
                alert("게시글 생성이 정상적으로 되지 않았습니다.");
            }
            /** 해당 메서드 실행 완료 후 페이지 전환 */
            navigate("/board", {});
        } catch (err) {
            console.log("게시글 작성하기를 동작하는 기능 에러", err);
            resetInput();
        }
    }

    return (
        <>
            <div className="container text-center">
                <h1 className="mt-5 text-success">글 작성</h1>
                <div className="row justify-content-center mt-5">
                    <div className="col-md-8">
                        <form onSubmit={handleInputCheck}>
                            <div className="form-group">
                                <label htmlFor="category">카테고리를 선택하세요</label>
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
                            <div className="form-group">
                                <label htmlFor="title">제목을 입력하세요</label>
                                <input
                                    type="text"
                                    id="title_input"
                                    className="form-control"
                                    value={title}
                                    onChange={(e) => setTitle(e.target.value)}
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="content">내용을 입력하세요</label>
                                <textarea
                                    id="content_text"
                                    className="form-control"
                                    rows="5"
                                    value={content}
                                    onChange={(e) => setContent(e.target.value)}
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="writer">이름을 입력하세요</label>
                                <input
                                    type="text"
                                    id="writer_input"
                                    className="form-control"
                                    value={writer}
                                    onChange={(e) => setWriter(e.target.value)}
                                />
                            </div>
                            <button type="submit" className="btn btn-success" onClick={handleInputCheck}>글 작성</button>
                        </form>
                    </div>
                </div>
            </div>
        </>
    )
}

export default QnA_CreateBoard;