import { useState } from "react"
import axios from "axios";
import { useNavigate } from "react-router-dom";


function AddUser() {
    const[name,setname] =useState("")
    const[email,setemail]=useState("")
    const[gender,setgender]=useState("")
    const[status,setstatus]=useState("")
    const[msg,setmsg]=useState("")
    const navigate = useNavigate();


    const adduser=async()=>{
        try{
         const response=  await axios.post("https://gorest.co.in/public/v2/users",
                {
                    'name':name,
                    'email':email,
                    'gender':gender,
                    'status':status
                }, {
                headers: {
                    "Authorization": 'Bearer ba0a9d986a2c34f766861933c33450bc8f9c23fccf098693b65c1da1ac7c3065',
                    
                }
        })
            console.log(response)
             setmsg("posted successfully")
             setTimeout(() => navigate("/user-list"), 1700);
        }catch(err){
            setmsg("error")
            
        }
            
    }
    return (
        <div>
            <div className="contanier">
                <br /> <br /> <br /> <br /> <br /> <br />
                <div className="row">

                    <div className="col-md-3"></div>
                    <div className="col-md-6">
                        <div className="card  shadow-lg border-0" >
                            <div className="card-header">Add user</div>
                            <div className="card-body">
                                 {
                                msg != "" ? <div className="mb-4">
                                    <div className="alert alert-primary">
                                        {msg}
                                    </div>
                                </div> : ""
                            }
                                <div className="md-2">
                                    <label>name</label>
                                    <input type="text" className="form-control"  onChange={$e=> {setname($e.target.value)}}/>
                                </div>
                                <div className="md-2">
                                    <label>email</label>
                                    <input type="text" className="form-control " onChange={$e=> {setemail($e.target.value)}} />
                                </div>
                                <div className="md-2">
                                    <label>gender</label>
                                    <input type="text" className="form-control" onChange={$e=> {setgender($e.target.value)}}/>
                                </div>
                                <div className="md-2">
                                    <label>status</label>
                                    <input type="text" className="form-control" onChange={$e=> {setstatus($e.target.value)}} />
                                </div>
                                <br/>
                                <div className="mb-4">
                                    <button className="btn btn-success "  onClick={()=>{adduser()}}>post</button>
                                </div>

                            </div>
                            <div className="card-footer">user management</div>
                        </div>
                    </div>
                    <div className="col-md-3"></div>


                </div>

            </div>

        </div>
    )
}
export default AddUser;