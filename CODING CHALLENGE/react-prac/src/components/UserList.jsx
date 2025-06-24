import { useState } from "react"
import { Button } from 'primereact/button';
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";


function UserList() {
    const [userlist, SetUserList] = useState([])
    const [msg, setMsg] = useState("")
    const navigate = useNavigate();

    useEffect(() => {
        const getuser = async () => {
            try {
                const response = await axios.get('https://gorest.co.in/public/v2/users')
                console.log(response)
                SetUserList(response.data)
            } catch (err) {
                console.log(err)

            }

        }
        getuser()
    }, [])



    const onDelete = async (userId) => {
        if (window.confirm("Are you sure you want to delete this user?")) {
            try {
                await axios.delete(`https://gorest.co.in/public/v2/users/${userId}`, {
                    headers: {
                        'Authorization': 'Bearer ba0a9d986a2c34f766861933c33450bc8f9c23fccf098693b65c1da1ac7c3065',
                    }
                });
                console.log("Token:", localStorage.getItem('token'));
                let temp = [...userlist];
                temp = temp.filter(u => u.id !== userId);
                SetUserList(temp);
                setMsg("User deleted successfully");
            } catch (err) {
                console.log(err);
                setMsg("Error in deleting user");
            }
        }
    };

    return (
        <div className='container-fluid' style={{ background: "linear-gradient(135deg,rgb(231, 236, 240),rgb(172, 188, 198))" }}>
            <div className="table-responsive">
                <br />  <br />  <br />  <br />

                <div className="d-flex justify-content-between align-items-center px-4">
                    <h1>List of Users</h1>
                    <button className="btn btn-success" onClick={() => navigate("/add-user")}>Add User</button>
                </div>
                {
                    msg !== "" ? <div className="row">
                        <div className="col-lg-12">
                            {msg}
                        </div>
                    </div> : ""
                }
                <table className="table table-striped table-bordered">
                    <thead className="table-dark">
                        <tr>
                            <th>s.no</th>
                            <th>name</th>
                            <th>email</th>
                            <th>gender</th>
                            <th>status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {userlist.map((u, index) => (
                            <tr key={index}>
                                <th scope="row">{index + 1}</th>
                                <td>{u.name}</td>
                                <td>{u.email}</td>
                                <td>{u.gender}</td>
                                <td>{u.status}</td>
                                <td>
                                    <Button
                                        label="Edit"
                                        icon="pi pi-pencil"
                                        className="btn btn-sm btn-primary me-2"
                                        onClick={() => navigate(`/edit-user/${u.id}`)}
                                    />
                                    <Button
                                        label="Delete"
                                        icon="pi pi-trash"
                                        className="btn btn-sm btn-danger"
                                        onClick={() => onDelete(u.id)}
                                    />
                                </td>

                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            <br /><br /><br /><br /><br />

        </div>


    )
}

export default UserList

