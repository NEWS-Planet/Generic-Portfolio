import "./registerComponent.css";
import React from "react";
import {
    EyeInvisibleOutlined,
    EyeTwoTone,
    LeftOutlined,
    LockFilled,
    MailOutlined,
    UserOutlined
} from "@ant-design/icons";
import {Link} from "react-router-dom";
import {Button, Input} from "antd";

function registerComponent() {
    const handleReturn = () => {
        window.scrollTo({ top: 0, behavior: 'smooth' });
    };

    const handleRegister=() =>{
        console.log("connnected the account with the email and password")
    }
  return (
    <div id="register-component">
            <Link to="/home" onClick={handleReturn} className="return-container"><LeftOutlined style={{ fontSize: 30, marginRight: 7,color:"#0062BD" }} />
            Return
            </Link>

        <div className='title_card'>
            <h2>Generic PortFolio</h2>
            <p>The best plateform to showcase your work and skills</p>
        </div>

        <div className='ellipse_component'>
            <div className='login_form'>
                <div className="st" >
                    <h3 >Register</h3>
                    <div className="signUp"><strong>Already have an account? </strong>
                        <Link to="/login" style={{marginLeft:10 , color:'#2090F8',textDecoration: "none"}}>Login here </Link>
                    </div>
                    <br/>
                    <br/>

                </div>
                <Input size="middle"
                       placeholder="   Your full name"
                       bordered={false}
                       prefix={<UserOutlined />}
                       style={{width:400,height:35,
                           borderBottom: '1px solid black'}}
                       className="c-input"
                />

                <br/>
                <Input size="middle"
                            placeholder="   Your mail address"
                            bordered={false}
                            prefix={<MailOutlined />}
                            style={{width:400,height:35,
                                borderBottom: '1px solid black'}}
                            className="c-input"
                />
                <br/>
                <Input.Password
                    size="large"
                    bordered={false}
                    placeholder="   Your password"
                    prefix={<LockFilled />}
                    iconRender={(visible) => (visible ? <EyeTwoTone /> : <EyeInvisibleOutlined />)}
                    style={{
                        borderBottom: '1px solid black',
                        width:400,height:35}}
                    className="c-input"
                />
                <br/>
                <Input.Password
                    size="large"
                    bordered={false}
                    placeholder="   confirm your password"
                    prefix={<LockFilled />}
                    iconRender={(visible) => (visible ? <EyeTwoTone /> : <EyeInvisibleOutlined />)}
                    style={{
                        borderBottom: '1px solid black',
                        width:400,height:35}}
                    className="c-input"
                />
                <br/>
                <br/>
                <Button type="primary" block
                        style={{width:400,height:38,fontSize:20,fontFamily:"Montserrat"}}
                        className="btn-l"
                        onClick={handleRegister}
                > Register</Button>
                <br/>
                <br/>
            </div>
        </div>
    </div>
  );
};

export default registerComponent;