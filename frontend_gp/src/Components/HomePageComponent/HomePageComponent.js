import "./HomePageComponent.css";
import React, {useState} from "react";
import HeaderComponent from "../HeaderComponent/HeaderComponent";
import {Button, Col, Row} from "antd";
import {Link, useNavigate} from "react-router-dom";
import p1 from "../../assets/images/p1.png";
import p2 from "../../assets/images/p2.png";
import p3 from "../../assets/images/p3.jpg";
import LOGO from "../../assets/images/LOGO.jpg";
import flag from "../../assets/images/flag.png";
import EmailModal from "./EmailModal";
function HomePageComponent() {
   const navigate = useNavigate();
    const [isModalVisible, setIsModalVisible] = useState(false);

    const openModal = () => {
        setIsModalVisible(true);
    };

    const closeModal = () => {
        setIsModalVisible(false);
    };

    const handleLinkClick = () => {
        // Scroll to the top when the link is clicked
        window.scrollTo({ top: 0, behavior: 'smooth' });
    };
    const handleTalents=() => {
        navigate("/talentPool");
        window.scrollTo({ top: 0, behavior: 'smooth' });
    }

    const handleRegister=()=>{
        navigate("/register");
        window.scrollTo({ top: 0, behavior: 'smooth' });
    }
    const handlePortfolio=() => {
        navigate("/portfolio-creation");
        window.scrollTo({ top: 0, behavior: 'smooth' });
    }





  return (
    <div className="home-page-component">
      <HeaderComponent defaultSelectedKeys={['1']}/>

      <h2> Generic portfolio</h2>
      <p> the easiest and fastest way to Show off Your Work
           Free trial. No credit card required</p>

      <Button className="start-btn" onClick={handlePortfolio}>TRY IT FOR FREE </Button>
      <img src={p1} className="p1"/>

        <br/>

        <Row justify="center" align="middle">
            <Col className="col1">
                <p>
                    This website empowers individuals to put their best foot forward and helps businesses find their perfect hires efficiently
                </p>
            </Col>
            <Col>
                <img src={p2} className="p2"/>

            </Col>
        </Row>

        <Row justify="center" align="middle">
            <Col>
                <img src={p3} className="p3"/>
            </Col>
            <Col  className="col2">
                <p>
                    Perfect for image-heavy sites. Drag & drop images from your
                    desktop, add captions and you're done.
                </p>
                <p>✓ Unlimited photos & galleries</p>
                <p>✓ Easy image upload & cropping</p>
                <p>✓ Photo grids & sliders</p>
                <p>   ✓ No file size limit</p>
                <p>   ✓ Custom photo blocks</p>
                <Button className="signUp-btn" onClick={handleRegister}>SIGN UP FIRST</Button>
            </Col>
        </Row>

            <div className="c">
                <Row justify="center" align="middle">
                    <Col style={{width:550,marginLeft:250}}>
                <h4>Connect your portfolio to our Talent Pool for
                    recruiters & companies to find & hire you.</h4>
                        <br/>
                        <br/>
                        <Button className="talent-btn" onClick={handleTalents}>Visit Talent Pool</Button>
                    </Col>

                    <img src={LOGO} className="p4"/>
                </Row>
            </div>

        <br/><br/>
        <div className="c1">
            <br/>
            <h3  className="kk">
                Made for all creatives who want an
                easy, personalized way to launch their portfolio.
            </h3>
            <Row justify="center" align="middle">
                <Col style={{marginTop:50}}>
                    <h5>✓ Animators</h5>
                    <h5>✓ Architects</h5>
                    <h5>✓ Apparel designers</h5>
                    <h5>✓ Character designers</h5>
                    <h5>✓ Concept designers</h5>
                    <h5>✓ Character designers</h5>
                    <h5>✓ Art directors</h5>
                    <h5>✓ Painters</h5>
                </Col>

                <Col style={{marginLeft:300,marginTop:50}}>
                    <h5>✓ Engineers</h5>
                    <h5>✓ Editorial designers</h5>
                    <h5>✓ Fashion designers</h5>
                    <h5>✓ Fashion photographers</h5>
                    <h5>✓ Graphic designers</h5>
                    <h5>✓ Illustrators</h5>
                    <h5>✓ UX designers</h5>
                    <h5>✓ 3D artists</h5>
                </Col>

                <Col style={{marginLeft:200,marginTop:50}}>
                    <h5>✓ Interior designers</h5>
                    <h5>✓ Logo designers</h5>
                    <h5>✓ Product designers</h5>
                    <h5> ✓ Photographers</h5>
                    <h5>✓ Typographers</h5>
                    <h5>✓ ...and more!</h5>
                </Col>

        </Row>
            <Button className="start-btn"  style={{marginTop:26,fontSize:20,height:55,boxShadow:5}}>TRY IT FOR FREE</Button>
        </div>

          <br/>


        <div>
        <Row  justify="center" align="middle">
            <Col className="c4">
                <p className="MadeBy">
                    Made by
                </p>
                <p className="NP">NEWS Planet
                    from Morocco</p>
                <img src={flag}  className="flag"/>
            </Col>
            <Col className="c5">
                <p className="MadeBy">
                   About Us
                </p>
                <Link to="/aboutUs" className="NP" onClick={handleLinkClick}>
                   The company NEWS PLanet
                </Link>
            </Col>
            <Col className="c6">
                <p className="MadeBy">
                    Talk to us
                </p>
                <p className="NP" onClick={openModal} style={{ cursor: 'pointer' }}>via Email</p>
                <EmailModal isVisible={isModalVisible} closeModal={closeModal} />
            </Col>
        </Row>
            <br/>
            <br/>
            <br/>
            <br/>
        </div>
    </div>
  );
};

export default HomePageComponent;
