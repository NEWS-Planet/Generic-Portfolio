import React, {useState} from 'react';
import './ProfilePage.css';
import {EditOutlined, FileOutlined, LeftOutlined, PlusOutlined} from "@ant-design/icons";
import {useNavigate} from "react-router-dom";

const ProfilePage = () => {
    const [profileImage, setProfileImage] = useState(null);
    const navigate = useNavigate();
    const [resume, setResume]=useState(null);
    const [userInfo, setUserInfo] = useState({
        name: '',
        bio: '',
        // Add more user information as needed
    });


    const handleProfileImageChange = (e) => {
        const file = e.target.files[0];
        setProfileImage(URL.createObjectURL(file));
    };



    const handleUserInfoChange = (e) => {
        const { name, value } = e.target;
        setUserInfo((prevUserInfo) => ({
            ...prevUserInfo,
            [name]: value,
        }));
    };

    const handleReturn = () => {
        navigate("/home");
        window.scrollTo({ top: 0, behavior: 'smooth' });
    };

    const handleLoadResumeClick = () => {
        document.getElementById("file-input").click();
    };

    const handleFileInputChange = (e) => {
        // Handle the selected file
        const cv = e.target.files[0];
        console.log('Selected file:', cv);
        setResume(cv);
        // Log the entire resume object
        console.log('Resume:', resume);
    };


    return (
        <div className="profile-page">
            <div className="return-container" onClick={handleReturn}>
                <LeftOutlined style={{ fontSize: 30,marginRight: 7,color:"#0062BD" }} />
                Return
            </div>
            <br/>
            <br/>
            <br/>
            <br/>
            <div className="fbox">
            <div className="profile-header">
                <div className="profile-image-container">
                    {profileImage ? <img src={profileImage} alt="Profile" className="profile-image" /> : <div className="default-profile-image">No Photo</div>}
                    <label htmlFor="profile-image" className="upload-button">
                        <input type="file" id="profile-image" style={{display:"none"}} accept="image/*" onChange={handleProfileImageChange} />
                        <span className="upload-icon"><EditOutlined /></span>
                    </label>
                </div>


                <div className="user-info">
                    <h2>{userInfo.name || 'John Doe'}</h2>
                    <p style={{color:"white"}}>{userInfo.bio || 'Bio not available'}</p>
                </div>


            </div>
        </div>
            {/* New buttons for CV and Portfolio */}
            <div className="b-container">
                <div className="cv-container">
                    <button className="cv-b" onClick={handleLoadResumeClick}>
                        <PlusOutlined style={{ fontSize: 22, marginRight: 10 }} /> Load your resume
                    </button>
                    <label htmlFor="file-input">
                        <input
                            type="file"
                            id="file-input"
                            style={{ display: "none" }}
                            onChange={handleFileInputChange}
                        />
                    </label>
                    {resume && (
                        <div className="file-preview">
                            <p style={{fontSize:20, marginLeft:-80}}>Selected File: {resume.name}</p>
                        </div>
                    )}
                </div>
                <div className="portfolio-container">
                    <button className="portfolio-b" onClick={() => console.log('View Portfolio')}>
                        <FileOutlined style={{ fontSize: 22, marginRight: 10 }} /> View your portfolio
                    </button>
                </div>
            </div>
            <br />
        </div>
    );
};

export default ProfilePage;