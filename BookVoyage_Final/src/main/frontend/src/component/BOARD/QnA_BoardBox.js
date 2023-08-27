import {Link} from "react-router-dom";
import {React} from "react";


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

export default QnA_BoardBox;
