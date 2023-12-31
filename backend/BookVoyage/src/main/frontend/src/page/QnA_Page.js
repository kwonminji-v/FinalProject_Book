import { React, useEffect, useState} from "react";
import axios from "axios";
import {Link, useParams} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import '../css/board.module.css'


const QnA_Page = () => {

    const [data, setData] = useState([]);
    const [isCollapsed, setIsCollapsed] = useState(true);
    const [currentPage, setCurrentPage] = useState(0);
    const [totalPages, setTotalPages] = useState(0);
    console.log(totalPages, currentPage);



    const faqList = [
        { question: '질문 1', answer: '답변 1' },
        { question: '질문 2', answer: '답변 2' },
        { question: '질문 3', answer: '답변 3' },
        // 추가적인 질문과 답변
    ];

    const [expandedId, setExpandedId] = useState(null);

    const handleToggle = (index) => {
        if (expandedId === index) {
            setExpandedId(null);
        } else {
            setExpandedId(index);
        }
    };



    useEffect(() => {
        const getBoardList = async () => {
            console.log('게시글 목록 가져오는 메서드 실행');
            let response = await axios.get(`/api/board/board-list?page=${currentPage}&size=10&sort=id, DESC`);
            setData(response.data.data);
            setTotalPages(response.data.totalPages);
            console.log('board/response = ', response);
        };
        getBoardList();
    },[])




    useEffect(() => {
        fetchData(currentPage);
    }, [currentPage]);

    const fetchData = async (page) => {
        try {
            const response = await axios.get(`/api/board/board-list?page=${page}&size=10`);
            setData(response.data.content);
            setTotalPages(response.data.totalPages);
        } catch (error) {
            console.error("페이징 데이터", error);
        }
    };

/*    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get(`/api/board/board-list?page=${currentPage}&size=10`);
                setData(response.data.content);
                setTotalPages(response.data.totalPages);
            } catch (error) {
                console.error("페이징 데이터", error);
            }
        };
    }, [currentPage]);*/



    const handlePageChange = (page) => {
        setCurrentPage(page);
    };

    const QnA_BoardBox = (props) => {
        return (
            <tr>
                <td style={{ width: '5%' }}>{props.id}</td>
                <td style={{ width: '15%' }}>{props.category}</td>
                <td style={{ width: '18%' }}>
                    <Link
                        to={{
                            pathname: `/home/board/detail/${props.id}`,
                            state: { id: props.id }
                        }}
                    >
                        {props.title}
                    </Link>
                </td>
                <td style={{ width: '35%' }}>{props.content.includes('.') ? props.content.substring(0,props.content.indexOf('.')+1) : props.content}</td>
                <td>{props.writer}</td>
                <td>{props.view}</td>
                <td>{props.regDate}</td>
            </tr>

        );
    };


    const QnA_BoardList = (props) => {

        return (
            <div className="container text-center" style={{paddingTop:' 100px' , border:'2px solid black'}}>
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
                                        content={i.content}
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
                        <div className="mt-3 d-flex justify-content-center">
                            <button
                                className="btn btn-secondary mx-1"
                                onClick={() => handlePageChange(0)} // Go to first page
                            >
                                &lt;&lt; {/* prev 화살표 */}
                            </button>
                            {Array.from({ length: totalPages }, (_, index) => index).map((page) => (
                                <button
                                    key={page}
                                    className={`btn ${page === currentPage ? "btn-success" : "btn-secondary"} mx-1`}
                                    onClick={() => handlePageChange(page)}
                                    style={{ margin: "5px" }}
                                >
                                    {page + 1}
                                </button>
                            ))}
                            <button
                                className="btn btn-secondary mx-1"
                                onClick={() => handlePageChange(totalPages - 1)} // Go to last page
                            >
                                &gt;&gt; {/* next 화살표 */}
                            </button>
                        </div>
                    </div>
                </div>
                <Link to={"/home/board/create-board"}>
                    <input type="button" className="btn btn-success mt-4"  value="게시글 작성하기" />
                </Link>
            </div>
        );
    };


    return (
        <>
            <div style={{border:'2px solid red', width:'100vw', display:'flex', flexDirection:'column'}}>
            <div className="container mt-5" style={{paddingTop:' 100px', border:'2px solid black'}}>
                <h1 className="text-center">자주 묻는 질문</h1>
                <div className="accordion accordion-flush" id="faqAccordion" style={{display:'flex', justifyContent:'center'}}>
                <div className="col-md-8" style={{display:'flex',flexDirection:'column', border:'2px solid black'}}>
                    {faqList.map((faq, index) => (
                        <div className="accordion-item" key={index}>
                            <h2 className="accordion-header">
                                <button
                                    className={`accordion-button ${expandedId === index ? '' : 'collapsed'}`}
                                    type="button"
                                    onClick={() => handleToggle(index)}
                                >
                                    {faq.question}
                                </button>
                            </h2>
                            <div
                                id={`answer${index}`}
                                className={`accordion-collapse collapse ${expandedId === index ? 'show' : ''}`}
                                data-bs-parent="#faqAccordion"
                                style={{
                                    opacity: expandedId === index ? 1 : 0,
                                    height: expandedId === index ? 'auto' : 0,
                                    transition: 'opacity 0.3s ease-out, height 0.3s ease-out'
                                }}
                            >
                                <div className="accordion-body">
                                    {faq.answer}
                                </div>
                            </div>
                        </div>
                    ))}
                </div>
                </div>



                <QnA_BoardList data = {data} />

            <div className="container mt-4" style={{ border:'2px solid black', paddingTop: '100px', minHeight: 'calc(100vh - 100px)' }}>
                <div style={{border:"2px solid red", display: 'flex', justifyContent: 'center', flexDirection:"column", alignItems:"center"}}>
                <h2 className="mb-4 text-success">도서 구매 관련 공지사항</h2>
                <div className="col-md-6 mb-4">
                <div className="alert alert-info">
                    <h5 className="alert-heading">중요 공지</h5>
                    <p>도서 구매 시 할인 프로모션을 진행합니다. 기간: 2023년 8월 21일부터 8월 31일까지. 놓치지 마세요!</p>
                </div>
                </div>
                <div className="col-md-6 mb-4">
                <div className="alert alert-warning">
                    <h5 className="alert-heading">주의 사항</h5>
                    <p>예약 구매한 도서는 발매일에 자동으로 배송됩니다. 주문 취소는 발매일 전에만 가능합니다.</p>
                </div>
                </div>
                <div className="col-md-6 mb-4">
                <div className="alert alert-danger">
                    <h5 className="alert-heading">환불 정책 변경</h5>
                    <p>구매한 도서의 환불은 구매 후 7일 이내에만 가능합니다. 자세한 내용은 '환불 정책' 페이지에서 확인하세요.</p>
                </div>
                </div>
                <div className="col-md-6 mb-4">
                <div className="alert alert-success">
                    <h5 className="alert-heading">새로운 기능 추가</h5>
                    <p>이제부터 회원 리워드 프로그램을 시작합니다. 도서 구매 시 포인트가 적립되며, 다음 구매에 사용할 수 있습니다.</p>
                </div>
                </div>
                <button style={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}
                        className="btn btn-secondary mt-3"
                        onClick={() => setIsCollapsed(!isCollapsed)}
                        type="button"
                        data-toggle="collapse"
                        data-target="#collapseExample"
                        aria-expanded={!isCollapsed}
                        aria-controls="collapseExample"
                > 도움말 </button>
                <div className="col-md-6 mb-4">
                <div className={`collapse mt-3 ${isCollapsed ? '' : 'show'}`} id="collapseExample">
                    <div className="card card-body">
                        공지사항 이외에 도움 제공
                    </div>
                </div>
                </div>
                </div>
            </div>
            </div>
            </div>
        </>
    );
};



export default QnA_Page;