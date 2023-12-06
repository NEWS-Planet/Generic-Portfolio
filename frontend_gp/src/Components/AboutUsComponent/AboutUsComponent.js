import "./AboutUsComponent.css";
import React from "react";
import HeaderComponent from "../HeaderComponent/HeaderComponent";
import NP_black from "../../assets/images/NP_black.png";
import logo1 from "../../assets/images/logo1.png";
import {Col, Row} from "antd";
import nouhaila_OH from "../../assets/Team/nouhaila_OH.jpg";
import nouhaila_Z from "../../assets/Team/nouhaila_Z.jpg";
import emmanuel from "../../assets/Team/emmanuel.jpg";
import saad from "../../assets/Team/saad.jpg";
import steve from "../../assets/Team/steve.jpg";
import winny from "../../assets/Team/winny.jpg";

function AboutUsComponent() {
  return (
    <div className="about-us-component">
        <HeaderComponent defaultSelectedKeys={['2']}/>
        <div>
            <img src={NP_black} className="black"/>
            <h4 className="tx1">
                At  <span className="highlight1">NEWS Planet</span>, we are passionate about redefining the way people interact
                with news and information.
                Our mission is to create products and interfaces that are exceptionally easy to use and require
                minimal training. We believe that staying informed should be a seamless and enjoyable experience for everyone, regardless of their technological proficiency.
            </h4>
        </div>

        <div className="team">
            <h3 className="tx2">Meet the <span className="highlight2">team</span></h3>
           <br/>
           <br/>
            <div className="test">
            <Row justify="center" align="middle">
                <Col>
                    <img src={nouhaila_OH} className="t1"/>
                </Col>
                <Col>
                    <img src={winny} className="t1" style={{marginLeft:250}}/>
                </Col>
                <Col>
                    <img src={steve} className="t1" style={{marginLeft:250}}/>
                </Col>
            </Row>

                <Row justify="center" align="middle">
                    <Col>
                        <h4 style={{marginLeft:5,marginTop:20}}>Nouhaila OHAPOUNE</h4>
                        <h5 style={{marginLeft:40 ,width:200}}>Company’s leader
                                                               Software engineer</h5>
                    </Col>
                    <Col>
                        <h4 style={{marginLeft:200,marginTop:20}}>Winny Baraka MADERISHA</h4>
                        <h5 style={{marginLeft:280 ,width:180}}>   Product owner
                                                                 Software engineer</h5>
                    </Col>
                    <Col>
                        <h4 style={{marginLeft:210,marginTop:20}}>Steve YANYARA DESIRE</h4>
                        <h5 style={{marginLeft:280 ,width:180}}>         Security Analyst
                                                                       Software engineer</h5>
                    </Col>
                </Row>

                <Row style={{marginTop:150}} justify="center" align="middle">
                    <Col>
                        <img src={emmanuel} className="t1"/>
                    </Col>
                    <Col>
                        <img src={nouhaila_Z} className="t1" style={{marginLeft:250}}/>
                    </Col>
                    <Col>
                        <img src={saad} className="t1" style={{marginLeft:250}}/>
                    </Col>
                </Row>

                <Row justify="center" align="middle">
                    <Col>
                        <h4 style={{marginTop:20}}>Emmanuel BABILE TSHIMOMBO</h4>
                        <h5 style={{marginLeft:50 ,width:200}}>Frontend developer
                            Software engineer</h5>
                    </Col>
                    <Col>
                        <h4 style={{marginLeft:130,marginTop:20}}>Nouhaila ZAHRAOUI</h4>
                        <h5 style={{marginLeft:150,width:200}}>Backend developer
                            Software engineer</h5>
                    </Col>
                    <Col>
                        <h4 style={{marginLeft:260,marginTop:20}}>Saad MARJANI</h4>
                        <h5 style={{marginLeft:260 ,width:200}}>Frontend developer
                            Software engineer</h5>
                    </Col>
                </Row>
        </div>
        </div>

        <div>
            <h4 className="t">Join Us on Our Journey</h4><br/>
            <h4 className="tx1">
                At <span className="highlight3">NEWS Planet</span> , we invite you to join us on our mission to make news and information accessible to all. Whether you are a user, partner, or part of our team,
                we welcome you to be a part of our journey towards a world where staying informed is effortless and enjoyable. Thank you for choosing NEWS Planet,
                where news meets simplicity.
            </h4>
            <img src={logo1} style={{marginTop:120}}/>
            <br/>
            <br/>
            <br/>
            <br/>
        </div>

    </div>
  );
};

export default AboutUsComponent;
