import "./HeaderComponent.css";
import React, { useState } from 'react';
import logo1 from "../../assets/images/logo1.png";
import {Button, Menu} from 'antd';

import privateRoutes from "../../privateRoutes";
import {useNavigate} from "react-router-dom";

function getItem(label, key, path) {
    return {
        key,
        label,
        path
    };
}
const MenuItems = [
    getItem('Home', '1',privateRoutes.home.path),
    getItem('About us','2',privateRoutes.aboutUs.path),
    getItem('Talent Pool','3',privateRoutes.talentPool.path)
];

function HeaderComponent({ defaultSelectedKeys }) {
    const [selectedKeys, setSelectedKeys] = useState(defaultSelectedKeys);
    const navigate = useNavigate();
    const signInPage=() => {
        navigate("/login");
        window.scrollTo({ top: 0, behavior: 'smooth' });
    }

    const handleMenuClick = ({ key }) => {
        setSelectedKeys([key]);
    };

    return (
        <div className="header-container">
            <img src={logo1} alt="Logo" className="logo_gp"/>

            <Menu mode="horizontal" className="menu_items"
                  selectedKeys={selectedKeys}
                  onClick={handleMenuClick}
            >
                {MenuItems.map(item => (
                    <Menu.Item key={item.key}>
                        <a href={item.path} className="menu-link">{item.label}</a>
                    </Menu.Item>
                ))}
            </Menu>
            <div className="ms-5 mt-4 mx-3">
                <Button  onClick={signInPage} className="sign-in-button">Sign in</Button>
            </div>

        </div>
    );
};

export default HeaderComponent;
