import './App.css';
import HomePageComponent from "./Components/HomePageComponent/HomePageComponent";
import {Route, Routes} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import AboutUsComponent from "./Components/AboutUsComponent/AboutUsComponent";
import TalentsComponent from "./Components/TalentsComponent/TalentsComponent";
import LoginComponent from "./Components/LoginComponent/LoginComponent";
import RegisterComponent from "./Components/registerComponent/registerComponent";


function App() {
  return (
    <div className="mb-3 app_color ">

      <Routes>
          <Route path="/" element={<HomePageComponent/>} />
          <Route path="/home" element={<HomePageComponent/>} />
          <Route path="/aboutUs" element={<AboutUsComponent/>}/>
          <Route path="/talentPool" element={<TalentsComponent/>}/>
          <Route path="/login" element={<LoginComponent/>}/>
          <Route path="/register" element={<RegisterComponent/>}/>
      </Routes>

    </div>
  );
}

export default App;
