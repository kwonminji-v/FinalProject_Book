import {useEffect} from "react";

export default function AdminPageControl(){
    useEffect(()=>{
<<<<<<< HEAD
    if(document.getElementById("userOnly") && document.getElementById("adminOnly")){
=======
    if(document.getElementById("adminOnly") && document.getElementById("adminOnly")){
>>>>>>> 2ad0b09e9a1ff773062c6cc4a97723b9f2a5f9d8
        document.getElementById("adminOnly").remove()
    }
    },[])
}