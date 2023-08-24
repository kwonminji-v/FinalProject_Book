import React, {useEffect, useState} from "react";
import axios from "axios";
import {Link, useNavigate, useParams} from "react-router-dom";

const QnA_DetailBoard = () => {

    const [title, setTitle] = useState("");
    const [category, setCategory] = useState("");
    const [content, setContent] = useState("");
    const [writer, setWriter] = useState("");
    const [reply, setReply] = useState("");
    const [replies, setReplies] = useState([]);
    const [regDate, setRegDate] = useState(new Date());
    const navigate = useNavigate();
    const {id} = useParams();


    /** =========== 게시글 상세보기 위한 백엔드 통신 ==============  */
    useEffect(() => {
        const getDetailBoard = async () => {
            let response = await axios.get(`/api/board/board-detail/${id}`);
            console.log("Detail/response = ", response);
            console.log("detail/response/data.data = ", response.data.data);
            setTitle(response.data.data.title);
            setCategory(response.data.data.category);
            setContent(response.data.data.content);
            setWriter(response.data.data.writer);
        }
        getDetailBoard();
    }, [id]);

    /** =========== 게시글에 댓글 작성하기 위한 백엔드 통신 ==============  */
    const handleReplySubmit = async () => {

        if (reply.trim() === "") {
            alert("댓글 입력 바람.");
            return;
        }

        try {
            const response = await axios.post(
                `/api/board/board-detail/${id}/reply-list`, {reply: reply}
            );
            const newReply = response.data;
            console.log("댓글 작성 응답(newReply) = " + response);

            setReplies((prevReplies) => [...prevReplies, newReply]);
            setReply("");
        } catch (error) {
            console.log("댓글 작성 에러" + error);
        }
    }

    useEffect(() => {
        const getReplies = async () => {
            try {
                const response = await axios.get(
                    `/api/board/board-detail/${id}/reply-list`
                );
                const replyList = response.data;
                console.log("댓글 작성 응답(replyList) = " , replyList);
                setReplies(replyList);
            } catch (error) {
                console.log("댓글 목록 조회 에러", error);
            }
        };
        getReplies();
    }, [id]);


    /** =========== 게시글 삭제위한 백엔드 통신 ==============  */
    const handleDeleteBtnClick = async (e) => {
        e.preventDefault();
        if (window.confirm("게시글을 삭제하시겟습니까?")) {
            const request_data = {id: id};
            let response = await axios({
                method: 'delete',
                url: '/api/board/delete-board',
                headers: {'Content-Type': 'application/json'},
                data: JSON.stringify(request_data)
            });
            console.log("detail/event/response = ", response);
            navigate("/home/board", {});
            //확인을 누르는 순간 navigate를 통해서 Route로 설정된 board 페이지로 이동
            if (response.status === 204) {
                //게시물 삭제가 성공적으로 실행
                alert("게시물 삭제 완료")
            }
            if (response.status > 400) {
                alert("게시물 삭제 실패")
            }
        } else {
            // 취소 시 메서드가 취소되며, 페이지 이동은 하지 않습니다.
        }
    };

    /* useEffect 훅은 특정한 조건을 만족할 때만 실행되도록 도와주는 역할
     * 여기서 getDetailBoard 함수는 특정한 게시글의 내용을 가져오는 역할을 하죠
     * 그런데 이 함수가 호출되기 위해서는 어떤 게시글의 내용을 가져와야 할지를 알아야 합니다.
     * 이때 사용하는 것이 바로 id 값입니다.
     *
     * 그래서 useEffect의 두 번째 인자로 [id]를 전달하면, 만약 id 값이 변경되면, 즉 다른 게시글을 선택하거나 조회할 때마다,
     * getDetailBoard 함수를 호출해서 해당 게시글의 내용을 가져와서 보여줘야 합니다.
     * 즉, id 값이 바뀔 때마다 그에 맞는 게시글 내용을 가져오는 역할을 getDetailBoard 함수에 부여합니다. */


    /** =========== 게시글 상세보기 및 댓글작성, 삭제기능 구현 view(리액트) ==============  */
    return (
        <>
            <div className="containert
            " style={{border: "2px solid black", marginBottom: "100px"}}>
                <div className="row justify-content-center">
                    <div className="col-md-8">
                        <div className="card">
                            <div className="card-header bg-transparent">
                                <h2 className="card-subtitle mb-2">분야: {category}</h2>
                            </div>
                            <div className="card-body">
                                <h4 className="card-title">{title}</h4>
                                <p className="card-text">{content}</p>
                                <p className="card-text">작성자: {writer}</p>
                                <p className="card-text">작성 일자 : {regDate.toLocaleDateString().replace(/\.$/, '')}</p>
                                {/*replace() 메서드를 사용하여 이 마침표를 빈 문자열로 대체하여 제거*/}
                                <div className="card-footer">
                                    <div className="btn-group">
                                        <Link
                                            to={`/home/board/update-board/${id}`}
                                            className="btn btn-success mr-2"
                                            state={{
                                                id: id,
                                                title: title,
                                                category: category,
                                                content: content,
                                                writer: writer,
                                                regDate: regDate,
                                            }}
                                        >
                                            수정하기
                                        </Link>
                                        <input
                                            type="button"
                                            onClick={handleDeleteBtnClick}
                                            className="btn btn-danger mr-2"
                                            value="삭제하기"
                                        />
                                        <Link to="/home/board" className="btn btn-secondary mr-2">
                                            목록 보기
                                        </Link>
                                    </div>
                                </div>
                            </div>
                            <div className="card-header bg-transparent  bi bi-chat-dots">
                                <h5>{replies.length > 0 && `${replies.length} 개의 댓글`}</h5>
                            </div>
                            <div className="col-md-6 mb-4">
                                <div className="card-body">

                                </div>
                                <ul className="comment-list" id="commentList">
                                    {replies.map((reply) => (
                                        <li key={reply.id}>
                                            <span>{reply.nickname}</span>
                                            <span>{reply.regDate}</span>
                                            <div>{reply.reply}</div>
                                        </li>
                                    ))}
                                </ul>
                            </div>

                            <div className="card-body">
                                <div className="col-md-6 mb-4">
                                    <div className="comment-form">
                                        <h4>댓글 작성</h4>
                                        <input
                                            type="text"
                                            value={reply}
                                            id="commentInput"
                                            className="form-control mb-2"
                                            placeholder="댓글을 입력하세요"
                                            onChange={(e) => setReply(e.target.value)}
                                        />
                                        <button
                                            type="submit"
                                            id="commentSubmit"
                                            className="btn btn-primary"
                                            onClick={handleReplySubmit}
                                        >
                                            댓글 작성
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );

}

export default QnA_DetailBoard;



