
function Chatbot() {
  const [messages, setMessages] = useState([]);
  const [input, setInput] = useState("");

  const handleSend = async () => {
    if (!input.trim()) return;

    const userMessage = { sender: "user", text: input };
    setMessages([...messages, userMessage]);

    try {
      const response = await fetch("http://localhost:8080/api/chat", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ message: input }),
      });

      const data = await response.text();

      const botMessage = { sender: "bot", text: data };
      setMessages((prev) => [...prev, botMessage]);
    } catch (error) {
      console.error("Error fetching bot reply:", error);
    }

    setInput("");
  };

  return (
    <div className="flex flex-col items-center min-h-screen bg-gray-100 p-4">
      <div className="w-full max-w-md bg-white shadow-lg rounded-lg p-4">
        <h1 className="text-2xl font-bold mb-4 text-center text-blue-600">
          💬 SupportBot
        </h1>

        <div className="h-80 overflow-y-auto border p-3 mb-3 rounded-md bg-gray-50">
          {messages.map((msg, index) => (
            <div
              key={index}
              className={`my-2 p-2 rounded-lg ${
                msg.sender === "user"
                  ? "bg-blue-100 text-right"
                  : "bg-gray-200 text-left"
              }`}
            >
              {msg.text}
            </div>
          ))}
        </div>

        <div className="flex">
          <input
            type="text"
            className="flex-1 border rounded-l-md p-2 focus:outline-none"
            placeholder="Type a message..."
            value={input}
            onChange={(e) => setInput(e.target.value)}
            onKeyDown={(e) => e.key === "Enter" && handleSend()}
          />
          <button
            className="bg-blue-600 text-white px-4 rounded-r-md"
            onClick={handleSend}
          >
            Send
          </button>
        </div>
      </div>
    </div>
  );
}

export default Chatbot;
