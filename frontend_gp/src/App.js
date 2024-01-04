import HomePageComponent from "./Components/HomePageComponent/HomePageComponent";
import {Route, Routes} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import AboutUsComponent from "./Components/AboutUsComponent/AboutUsComponent";
import TalentsComponent from "./Components/TalentsComponent/TalentsComponent";
import LoginComponent from "./Components/LoginComponent/LoginComponent";
import RegisterComponent from "./Components/registerComponent/registerComponent";
import PortfolioCreation from "./Components/PortfolioComponent/PortfolioCreation";
import ProfilePage from "./Components/ProfileComponent/ProfilePage";


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
          <Route path="/portfolio-creation" element={<PortfolioCreation/>} />
          {/*<Route path="/your-portfolio" element={<ShowPortfolio/>} />*/}
          <Route path="/my-profile" element={<ProfilePage/>} />

      </Routes>

    </div>
  );
}

export default App;
