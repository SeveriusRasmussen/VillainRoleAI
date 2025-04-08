console.log("javascript virker fint ")

function display() {
    const textbox = document.createElement("div");
    textbox.classList.add("textbox");

    textbox.innerHTML = `
    <input type="text" id="AInput" placeholder="Ask me anything..."<input>
    <button id="AButton">Ask</button>
    <div id="AResponse"></div> 
    
    `;
    document.body.appendChild(textbox);

}
display();