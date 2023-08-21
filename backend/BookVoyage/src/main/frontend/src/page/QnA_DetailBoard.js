import React, { useEffect, useState } from "react";
import axios from "axios";
import {Link, useNavigate, useParams} from "react-router-dom";


const QnA_DetailBoard = () => {

    const [title, setTitle] = useState("");
    const [category, setCategory] = useState("");
    const [content, setContent] = useState("");
    const [writer, setWriter] = useState("");
    const navigate = useNavigate();
    const id = useParams();
    /*const location = useLocation();*/
    /*const id = location.state.id;*/
    console.log('Detail/id = ', id);


    const handleDeleteBtnClick = async (e) => {
        e.preventDefault();
        if (window.confirm("게시글을 삭제하시겟습니까?")) {
            const request_data = {id: id};
            let response = await axios({
                method: 'delete',
                url:'/api/delete-board',
                headers:{'Content-Type': 'application/json'},
                data: JSON.stringify(request_data)
            });
            console.log("detail/event/response = ", response);
            navigate("/board", { });
            //확인을 누르는 순간 navigate를 통해서 Route로 설정된 board 페이지로 이동
            if(response.status === 204) {
                //게시물 삭제가 성공적으로 실행
                alert("게시물 삭제 완료")
            }
            if(response.status > 400) {
                alert("게시물 삭제 실패")
            }
        }else {
            return  // 취소 시 메서드가 취소되며, 페이지 이동은 하지 않습니다.
        }
    };
    /** useEffect 훅은 특정한 조건을 만족할 때만 실행되도록 도와주는 역할
     * 여기서 getDetailBoard 함수는 특정한 게시글의 내용을 가져오는 역할을 하죠
     * 그런데 이 함수가 호출되기 위해서는 어떤 게시글의 내용을 가져와야 할지를 알아야 합니다.
     * 이때 사용하는 것이 바로 id 값입니다.
     *
     * 그래서 useEffect의 두 번째 인자로 [id]를 전달하면, 만약 id 값이 변경되면, 즉 다른 게시글을 선택하거나 조회할 때마다,
     * getDetailBoard 함수를 호출해서 해당 게시글의 내용을 가져와서 보여줘야 합니다.
     * 즉, id 값이 바뀔 때마다 그에 맞는 게시글 내용을 가져오는 역할을 getDetailBoard 함수에 부여합니다. */
    useEffect(() => {
        const getDetailBoard = async () => {
            let response = await axios.get(`/api/board-detail/${id.id}`);
            console.log("Detail/response = ", response);
            console.log("detail/response/data = ", response.data);
            console.log("detail/response/data.data = ", response.data.data);
            setTitle(response.data.data.title);
            setCategory(response.data.data.category);
            setContent(response.data.data.content);
            setWriter(response.data.data.writer);

        }
        getDetailBoard();
    }, [id]);

    return (
        <>

            <div className="container mt-5">
                <div className="row">
                    <div className="col-md-8 offset-md-2">
                        <div className="card">
                            <div className="card-header bg-transparent">
                                <h1 className="card-title">{title}</h1>
                            </div>
                            <div className="card-body">
                                <h3 className="card-subtitle mb-2">분야: {category}</h3>
                                <p className="card-text">{content}</p>
                                <p className="card-text">작성자: {writer}</p>
                                <Link
                                    to={`/board/update-board/${id.id}`}
                                    className="btn btn-success mr-2"
                                    state={{
                                        id: id,
                                        title: title,
                                        category: category,
                                        content: content,
                                        writer: writer,
                                    }}
                                >
                                    수정하기
                                </Link>
                                <input
                                    type="button"
                                    onClick={handleDeleteBtnClick}
                                    className="btn btn-success mr-2"
                                    value="삭제하기"
                                />
                                <Link to="/board" className="btn btn-success mr-2">
                                    목록 보기
                                </Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )

}

export default QnA_DetailBoard;



