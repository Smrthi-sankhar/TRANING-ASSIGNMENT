import AddUser from "./components/AddUser"
import EditUser from "./components/EditUser"
import UserList from "./components/UserList"
import { BrowserRouter, Route, Routes } from "react-router-dom"
function App(){
  return(
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<UserList />}></Route>
      <Route path="add-user" element={<AddUser />}></Route>
      <Route path ="user-list"  element={<UserList/>}></Route>
      <Route path ="edit-user/:id"  element={<EditUser/>}></Route>
    </Routes>
    </BrowserRouter>
  
  )
}
export default App
