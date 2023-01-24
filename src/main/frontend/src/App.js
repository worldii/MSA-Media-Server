// src/main/frontend/src/App.js

import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const [image, setImage] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(e);
    let body = {
      description: e,
    };
    // handle image upload here
    axios.post("/media", body).then((response) => {
      console.log(response);
    });
  };
  const imageUpload = (e) => {
    const imageTpye = e.target.files[0].type.includes("image");
    const videoTpye = e.target.files[0].type.includes("video");
    console.log(e.target.files[0]);
    let body = {
      description: e.target.files[0],
    };
    axios.post("/media", body).then((response) => {
      console.log(response);
    });
    // setFile({
    //   url: URL.createObjectURL(e.target.files[0]),
    //   image: imageTpye,
    //   video: videoTpye,
    // });
    // console.log(imageTpye);
  };

  return (
    <div>
      <div>
        <input type="file" onChange={imageUpload} />
      </div>
    </div>
  );
}

export default App;
