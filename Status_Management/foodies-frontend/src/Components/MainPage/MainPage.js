import React, { Component } from 'react';
import "./MainPage.css";
import Post from '../Post/Post';
import uploadImage from "../../images/upload.png";
// import {storage,auth} from "../firebase";


class MainPage extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            postArray:[],
            progressBar: "",
         }
    }

    componentDidMount(){
        this.getPost();
    }

    getPost=()=>{ //API
        const thisContext=this;
        let data=[
            {
                "postId":"123456",
                "userName":"Deneth Anjana",
                "postImageURL":"https://images.unsplash.com/photo-1590947132387-155cc02f3212?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
                "timeStamp":"12345",
                "likes":"1234"
            },
            {
                "postId":"123456",
                "userName":"aSathsara Sandaru",
                "postImageURL":"https://images.unsplash.com/photo-1586816001966-79b736744398?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTJ8fGJ1cmdlcnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                "timeStamp":"12345",
                "likes":"1234"
            },
            {
                "postId":"123456",
                "userName":"aPubudu Chathuranga",
                "postImageURL":"https://irixlens.com/new/wp-content/uploads/2018/11/IRX_5473.jpg",
                "timeStamp":"12345",
                "likes":"1234"
            }
        ];
        thisContext.setState({postArray: data});

        // fetch('http://localhost:8080/post')
        //     .then(response => response.json())
        //     .then(data => {
        //         thisContext.setState({postArray: data});
        // });
    }

    // upload=(event)=>{
    //     let image=event.target.files[0];
    //     const thisContext=this;
    //     if(image == null || image == undefined)
    //         return;

    //     var uploadTask = storage.ref("images").child(image.name).put(image);
    //     uploadTask.on(
    //       "state_changed",
    //       function (snapshot) {
    //         var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
    //         thisContext.setState({progressBar: progress});
    //       },
    //       function (error) {
    //       },
    //       function () {
    //         uploadTask.snapshot.ref.getDownloadURL().then(function (downloadURL) {
    //             console.log(downloadURL);

    //             let payload = {
    //                 "postId": Math.floor(Math.random()*100000).toString(),
    //                 "userId": JSON.parse(localStorage.getItem("users")).uid,
    //                 "postPath": downloadURL,
    //                 "timeStamp": new Date().getTime(),
    //                 "likeCount": 0
    //             }
    
    //             const requestOptions ={
    //                 method: "POST",
    //                 headers: { 'Content-Type': 'application/json' },
    //                 body : JSON.stringify(payload),
    //             }
    
    //             fetch("http://localhost:8080/post",requestOptions)
    //             .then(response => response.json())
    //             .then(data => {
    //                 console.log(data);
    //                 thisContext.getPost();
    //             })
    //             .catch(error =>{
    
    //             })
                
    //         })
    //         }
    //     );
    // }

    render() { 
        return ( 
            <div>
                <div className="mainpage__container">  
                    <div className="mainpage__divider"></div>
                    <div className="fileupload">
                        <label for="file-upload" >
                            <img className="mainpage__uploadicon" src={uploadImage} />
                        </label>
                         <input onChange={this.upload} id="file-upload" type="file"/>
                     </div>
                    <div className="mainpage__divider"></div>   
                </div>
                <div className="upload_text">{this.state.progressBar}</div>
                {
                    this.state.postArray.map((item,index)=>(
                        <Post id={item.postId} userName={item.userName} postImage={item.postImageURL} likes={item.likes} />
                    ))
                }
            </div>
         );
    }
}
 
export default MainPage;