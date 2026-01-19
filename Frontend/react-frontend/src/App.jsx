import { useState, useEffect } from "react";
function App() {
  const [text, setText] = useState("");
  const [data, setData] = useState([]);

  const saveData = async () => {
    await fetch("http://localhost:8080/api/save", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ text }),
    });
    setText("");
  };

  const fetchData = async () => {
    const response = await fetch("http://localhost:8080/api/data");
    const result = await response.json();
    setData(result);
  };

  return (
    <div style={{ padding: "20px" }}>
      <input
        value={text}
        onChange={(e) => setText(e.target.value)}
        placeholder="Enter Text"
      />
      <button onClick={saveData}>Save</button>
      <button onClick={fetchData}>Fetch All</button>

      <ul>
        {data.map((item) => (
          <li key={item.id}>{item.text}</li>
        ))}
      </ul>
    </div>
  );
}
export default App;
