import React from 'react'
import './Login.css'
import { Button , Input } from 'antd';
import { UserOutlined } from '@ant-design/icons';
import { EyeInvisibleOutlined, EyeTwoTone , LockFilled} from '@ant-design/icons';

export default function LoginComponent() {
  return (
    <div id='sign_in'>
        <div className='title_card'>
            <h2>PortFolio</h2>
            <p>The best plateform to manage your entreprise</p>
        </div>

        <div className='ellipse_component'>
            <div className='login_form'>
                <label htmlFor="username">Username</label>
                <Input size="large" placeholder="Your username" prefix={<UserOutlined />} />

                <label htmlFor="password">Password</label>
                <Input.Password
                    size="large"
                    placeholder="Your password"
                    prefix={<LockFilled />}
                    iconRender={(visible) => (visible ? <EyeTwoTone /> : <EyeInvisibleOutlined />)}
                />
                <br/>
                <Button type="primary" block> Login</Button>

                <div className='group_line'>
                    <div className="line"></div>or<div className="line"></div>
                </div>

                <Button className='other_login' size="large" ghost> Connect with Google</Button> <br />
                <Button className='other_login' size="large" ghost> Connect with Github</Button>
            </div>
        </div>
    </div>
  )
}
