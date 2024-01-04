
import React, { useState } from "react";
import {Button, Steps, Modal, notification} from "antd";
import "./portfolio.css";
import PortfolioModal from "./PortfolioModal.js";
import { useNavigate} from "react-router-dom";
import LOGO from "../../assets/images/LOGO.jpg";
import {LeftOutlined} from "@ant-design/icons";

const { Step } = Steps;

const steps = [
    { title: "your full name", key: "fullName" },
    { title: "your headline", key: "headline" },
    { title: "your skills", key: "skills" },
    { title: "Education", key: "education" },
    { title: "Projects", key: "projects" },
    { title: "Experience", key: "experience" },
];

function PortfolioCreation() {
    const [currentStep, setCurrentStep] = useState(0);
    const [modalVisible, setModalVisible] = useState(false);
    const navigate = useNavigate();
    const [formData, setFormData] = useState({});
    const [allData, setAllData] = useState({
        fullName: "",
        headline: "",
        skills: "",
        education: "",
        projects: "",
        experience: "",
    });


    const handleOpenModal = () => {
        setModalVisible(true);
    };

    const handleCloseModal = () => {
        setModalVisible(false);
    };

    const handleSaveData = (data) => {
        // Check if there is any data.json entered
        const hasData = data.some((value) => value.trim() !== '');

        if (hasData) {
            // Handle saving data.json to the API or any other logic
            console.log("Data to be sent to API:", data);

            // Save data.json to API using axios
            // axios.post("/api/endpoint", data.json)
            //     .then((response) => {
            //         console.log("Data saved successfully:", response.data.json);
            //
            //         // Accumulate data.json from all steps
            //         setAllData((prevData) => ({ ...prevData, [steps[currentStep].key]: data.json[steps[currentStep].key] }));
            //
            //         // Reset formData to an empty object
            //         setFormData({});
            //
            //         setCurrentStep((prevStep) => prevStep + 1);
            //         handleCloseModal();
            //     })
            //     .catch((error) => {
            //         console.error("Error saving data.json:", error);
            //         // Handle the error accordingly
            //     });

            const currentStepKey = steps[currentStep].key;
            const newData = { [currentStepKey]: data };

            console.log("Data to be sent to API:", newData);

            // Save data to localStorage with the corresponding step.key
            localStorage.setItem(currentStepKey, JSON.stringify(newData));

            // Accumulate data from all steps
            setAllData((prevData) => {
                const updatedData = { ...prevData, ...newData };
                console.log("All Data:", updatedData);
                return updatedData;
            });

            // Reset formData to an empty array
            setFormData([]);

            setCurrentStep((prevStep) => prevStep + 1);
            handleCloseModal();

        } else {
            // Show an alert or any other indication that data.json is required
            alert("Please enter data before proceeding to the next step.");
        }
    };

    const handleBack = () => {
        setCurrentStep((prevStep) => prevStep - 1);
    };

    const showCongratulationsNotification = () => {
        notification.success({
            message: "Congratulations!",
            description: "You have successfully created your portfolio.",
            placement: "topRight",
            duration: 5, // Set duration to 0 for the notification to stay until manually closed
            onClose: (e) => {
                if (e && e.target && e.target.getAttribute("data-clicked") !== "true") {
                    // Close the page only if the notification is closed and the button is not clicked
                    window.close();
                }
            },
            btn: (
                <Button type="primary" onClick={() => redirectToPortfolioPage()} data-clicked="true">
                    Show your Portfolio
                </Button>
            ),
        });
    };


    const redirectToPortfolioPage = () => {
        navigate("/your-portfolio");
        window.scrollTo({ top: 0, behavior: 'smooth' });

    };
    const handleReturn = () => {
        navigate("/home");
        window.scrollTo({ top: 0, behavior: 'smooth' });
    };


    return (
        <div className="stepper-component">
            <div className="return-container" onClick={handleReturn}>
                <LeftOutlined style={{ fontSize: 30, marginRight: 7,color:"#0062BD" }} />
                Return
            </div>
            <img className="logo" src={LOGO} />
            <h3>Follows the steps to create your portfolio </h3>
            <div className="app-container">
                <Steps current={currentStep} style={{ marginBottom: "20px"}}>
                    {steps.map((step, index) => (
                        <Step key={index} title={step.title} />
                    ))}
                </Steps>

                <div className="center">
                    <Button onClick={handleOpenModal}>Enter Data</Button>

                    <PortfolioModal
                        visible={modalVisible}
                        title={currentStep < steps.length ? `Add your ${steps[currentStep]?.title}` : ""}
                        onCancel={handleCloseModal}
                        onSave={handleSaveData}
                        currentStep={currentStep}
                        steps={steps}
                    />

                    <Button
                        disabled={currentStep === 0}
                        style={{ marginRight: 10,marginLeft:20 }}
                        onClick={handleBack}
                    >
                        Back
                    </Button>
                    <Button
                        type="primary"
                        onClick={showCongratulationsNotification}
                        disabled={currentStep < steps.findIndex(step => step.key === "experience")+1}
                        style={{ marginLeft: 55 }}
                    >
                        Submit
                    </Button>

                </div>
            </div>
        </div>
    );
}
export default PortfolioCreation;