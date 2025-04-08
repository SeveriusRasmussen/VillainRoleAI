console.log("javascript virker fint ");
const url = "/villians";

function fetchReponse() {
    fetch(`${url}/charecterSheet/all`)
        .then(response => {
            if (!response.ok) {
                throw new Error("FEJL NUMBNUTS");
            }
            return response.json();
        })
        .then(characterSheets => {

        })
        .catch(err => {
            console.error("Der opstod en fejl:", err);
        });
}

function display() {
    const textbox = document.createElement("div");
    textbox.classList.add("textbox");

    textbox.innerHTML = `
    <input type="text" id="AInput" placeholder="Ask me anything..."<input>
    <button type="button" id="askButton">Ask</button>
    `;
    document.body.appendChild(textbox);
    const askButton = document.getElementById("askButton");
    const input = document.getElementById("AInput");
    askButton.addEventListener("click", () => {
        const questionData = document.querySelector("#AInput").value;

        //post ticket object from html form.
        fetch(`${url}/send question`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept':'application/json'
            },
            body: JSON.stringify(questionData) //create json file form movieData.
        })
            .then(response => response.json())
            .then(result => {
                console.log('Response Success:', result);
            })
            .catch(error => {
                console.error('Error:', error);
            });

    });

}
display();