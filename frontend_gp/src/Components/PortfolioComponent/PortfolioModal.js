// PortfolioModal.jsx
import React, { useState } from "react";
import { Modal, Button, Form, Input } from "antd";

const PortfolioModal = ({ visible, title, onCancel, onSave, currentStep, steps }) => {
    const [formData, setFormData] = useState([]);

    const handleInputChange = (index, value) => {
        const updatedData = [...formData];
        updatedData[index] = value;
        setFormData(updatedData);
    };

    const handleAddInput = () => {
        setFormData((prevData) => [...prevData, ""]);
    };

    const handleSave = () => {
        // Call your API to save data here
        // You can use the formData array to send data to the API
        onSave(formData);

        // Reset the form data after saving
        setFormData([]);
    };

    return (
        <Modal
            visible={visible}
            title={title || "Default Title"}
            onCancel={onCancel}
            footer={[
                <Button key="back" onClick={onCancel}>
                    Back
                </Button>,
                currentStep <= steps.length - 1 && (
                    <Button key="addInput" onClick={handleAddInput}>
                        Add
                    </Button>
                ),
                <Button key="save" type="primary" htmlType="submit" onClick={handleSave}>
                    Save
                </Button>,
            ]}
        >
            <Form>
                {formData.map((value, index) => (
                    <Form.Item key={index} label={`${index + 1}`}>
                        <Input
                            value={value}
                            onChange={(e) => handleInputChange(index, e.target.value)}
                        />
                    </Form.Item>
                ))}
            </Form>
        </Modal>
    );
};

export default PortfolioModal;
