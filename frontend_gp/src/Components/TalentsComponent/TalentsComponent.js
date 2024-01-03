import "./TalentsComponent.css";
import React from "react";
import HeaderComponent from "../HeaderComponent/HeaderComponent";
import {Button, Col, Input, Row} from "antd";
import LOGO from "../../assets/images/LOGO.jpg";
import { SearchOutlined } from '@ant-design/icons';
import {useNavigate} from "react-router-dom";


function TalentsComponent() {
    const navigate = useNavigate();
    const handlePortfolio=() => {
        navigate("/portfolio-creation");
        window.scrollTo({ top: 0, behavior: 'smooth' });
    }
  return (
    <div className="talents-component">
        <HeaderComponent defaultSelectedKeys={['3']}/>

        <img src={LOGO} className="p6"/>

        <div className="ta">
            <Row>
                <Col style={{width:450,marginLeft:200,marginTop:35}}>
                    <h4 style={{fontSize:30}}><span className="hl">Find talent.</span> Over 1 000 000 portfolios and  5 million projects.</h4>
                    <br/>
                    <br/>

                </Col>

                <Button className="start-btn" style={{marginTop:100,fontSize:30,height:60,width:350,boxShadow:5,fontFamily:"Josefin Sans"}}
                        onClick={handlePortfolio}>
                    Create your portfolio</Button>
            </Row>
            <div style={{ display: 'flex',alignItems: 'center'  }}>
            <Input
                placeholder="Search..."
                bordered={false}
                style={{
                       borderBottom: '1px solid white', // Add an underline
                       color: 'white',
                       width: 900,
                       marginLeft:110,
                       marginTop:50,
                       fontSize:30
                   }}
                className="custom-input"

            />
            <SearchOutlined style={{ color: 'white' ,marginLeft:-40,fontSize: '30px',marginTop:30}} />
            </div>
        </div>
    </div>
  );
};

export default TalentsComponent;
