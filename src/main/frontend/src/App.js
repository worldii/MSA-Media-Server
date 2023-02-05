// src/main/frontend/src/App.js
import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const [media, setMedia] = useState(null);

  const mediaUpload = (e) => {
    console.log(e.target.files[0]);

    const formData = new FormData();
    formData.append("file", e.target.files[0]);

    axios.post("/media", formData).then((response) => {
      console.log(response);
    });
    setMedia({
      url: URL.createObjectURL(e.target.files[0]),
    });
  };

  return (
    <div>
      <div>
        <input type="file" onChange={mediaUpload} />
        {media && <img src={media.url} alt="Preview" />}
      </div>
    </div>
  );
}

export default App;
