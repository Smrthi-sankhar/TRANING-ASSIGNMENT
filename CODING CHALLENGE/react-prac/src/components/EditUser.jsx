import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import axios from "axios";

function EditUser() {
    const { id } = useParams();
    const navigate = useNavigate();
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [gender, setGender] = useState("");
    const [status, setStatus] = useState("");
    const [msg, setMsg] = useState("");

    // Fetch existing user data
    useEffect(() => {
        const fetchUser = async () => {
            try {
                const response = await axios.get(`https://gorest.co.in/public/v2/users/${id}`, {
                    headers: {
                        Authorization: 'Bearer ba0a9d986a2c34f766861933c33450bc8f9c23fccf098693b65c1da1ac7c3065'
                    }
                });
                const u = response.data;
                setName(u.name);
                setEmail(u.email);
                setGender(u.gender);
                setStatus(u.status);
            } catch (err) {
                console.log(err);
                setMsg("Failed to fetch user");
            }
        };
        fetchUser();
    }, [id]);
    //update the user
    const updateUser = async () => {
        try {
            const response = await axios.put(`https://gorest.co.in/public/v2/users/${id}`,
                {
                    name,
                    email,
                    gender,
                    status
                },
                {
                    headers: {
                           Authorization: 'Bearer ba0a9d986a2c34f766861933c33450bc8f9c23fccf098693b65c1da1ac7c3065'
                    }
                }
            );
            console.log(response);
            setMsg("User updated successfully");
            setTimeout(() => navigate("/user-list"), 1500);
        } catch (err) {
            
            setMsg("Update failed");
        }
    };

    return (
        <div className="container">
            <br /><br />
            <h3>Edit User</h3>
            {msg && <div className="alert alert-info">{msg}</div>}

            <div className="mb-3">
                <label>Name</label>
                <input type="text" className="form-control" value={name} onChange={e => setName(e.target.value)} />
            </div>
            <div className="mb-3">
                <label>Email</label>
                <input type="text" className="form-control" value={email} onChange={e => setEmail(e.target.value)} />
            </div>
            <div className="mb-3">
                <label>Gender</label>
                <input type="text" className="form-control" value={gender} onChange={e => setGender(e.target.value)} />
            </div>
            <div className="mb-3">
                <label>Status</label>
                <input type="text" className="form-control" value={status} onChange={e => setStatus(e.target.value)} />
            </div>

            <button className="btn btn-primary" onClick={updateUser}>Update</button>
        </div>
    );
}

export default EditUser;
