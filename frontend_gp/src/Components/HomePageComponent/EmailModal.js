// EmailModal.js
import React from 'react';
import {Modal, Button, Typography} from 'antd';
import NP_black from "../../assets/images/NP_black.png";

const { Title, Text } = Typography;
const EmailModal = ({ isVisible, closeModal }) => {
    const emailAddresses = [
        { email: 'manouha251@gmail.com', text: 'Nouhaila OHAPOUNE' },
        { email: 'email2@example.com', text: 'Winny Baraka MADERISHA' },
        { email: 'email3@example.com', text: 'Steve YANYARA DESIRE' },
        { email: 'email4@example.com', text: 'Emmanuel BABILE TSHIMOMBO' },
        { email: 'email5@example.com', text: 'Nouhaila ZAHRAOUI' },
        { email: 'email6@example.com', text: 'Saad MARJANI' }
    ];

    return (
        <Modal
            title={<div style={{ textAlign: 'center' }}>Email Addresses of the team NEWS Planet</div>}
            visible={isVisible}
            onCancel={closeModal}
            footer={[
                <Button key="ok" type="primary" onClick={closeModal}>
                    OK
                </Button>,
            ]}
            width={500} // Set the width of the modal
        >
            <ul style={{ listStyle: 'none', padding: 0,marginTop:30,textAlign:"center",fontSize:17 }}>
                {emailAddresses.map((item, index) => (
                    <li key={index} style={{ marginBottom: 10 }}>
                        <Text strong>
                            <a href={`mailto:${item.email}`}>{item.text}</a>
                        </Text> : {item.email}
                    </li>
                ))}
                <img src={NP_black} className="hg"/>
            </ul>

        </Modal>
    );
};

export default EmailModal;
