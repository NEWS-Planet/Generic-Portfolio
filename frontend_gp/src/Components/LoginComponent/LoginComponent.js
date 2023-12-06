import "./LoginComponent.css";
import React from "react";
import {Button, Input} from 'antd';
import {
    EyeInvisibleOutlined,
    EyeTwoTone,
    GithubFilled,
    GoogleOutlined, LeftOutlined,
    LockFilled,
    UserOutlined
} from "@ant-design/icons";
import {Link, useNavigate} from "react-router-dom";



function LoginComponent() {
    const navigate = useNavigate();
    const handleReturn = () => {
        navigate("/home");
        window.scrollTo({ top: 0, behavior: 'smooth' });
    };

    const handleLogin=() =>{
        console.log("connnected the account with the email and password")
    }
    const handleGoogleConnect = () => {
        // Handle Google connect logic here
        console.log("Connecting with Google");
    };

    const handleGithubConnect = () => {
        // Handle Github connect logic here
        console.log("Connecting with Github");
    };
  return (
        <div id='sign-in-component'>
            <div className="return-container" onClick={handleReturn}>
                <LeftOutlined style={{ fontSize: 30, marginRight: 7,color:"#0062BD" }} />
                Return
            </div>
            <div className='title_card'>
                <h2>Generic PortFolio</h2>
                <p>The best plateform to showcase your work and skills</p>
            </div>

            <div className='ellipse_component'>
                <div className='login_form'>
                    <div className="st" >
                    <h3 >SIGN IN</h3>
                        <div className="signUp"><strong>New user? </strong>
                            <Link to="/register" style={{marginLeft:10 , color:'#2090F8',textDecoration: "none"}}>Create an account</Link>
                        </div>
                        <br/>
                        <br/>

                </div>
                    <Input size="middle"
                           placeholder="   Your username"
                           bordered={false}
                           prefix={<UserOutlined />}
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
                    <Button type="primary" block
                            style={{width:400,height:38,fontSize:20,fontFamily:"Montserrat"}}
                            className="btn-l"
                            onClick={handleLogin}
                    > Login</Button>
                    <br/>
                    <br/>

                    <div className='group_line'>
                        <div className="line"></div>or<div className="line"></div>
                    </div>
                    <br/>

                    <Button
                        className='other-login'
                        size="large"
                        ghost
                        style={{ border: '1px solid black', width: 250 , display: "flex", transition: 'background-color 0.3s',   }}
                        onClick={handleGoogleConnect}
                    >
                        <GoogleOutlined style={{ fontSize: 24, color: 'black', marginRight: 10 }} />
                        Connect with Google
                    </Button>
                    <br/>

                    <Button
                        className='other-login'
                        size="large"
                        ghost
                        style={{ border: '1px solid black', width: 250, display: "flex" ,transition: 'background-color 0.3s',}}
                        onClick={handleGithubConnect}
                    >
                        <GithubFilled style={{ fontSize: 24, marginRight: 10, color: 'black' }} />
                        Connect with Github
                    </Button>
                </div>
            </div>
        </div>
  );
};

export default LoginComponent;
