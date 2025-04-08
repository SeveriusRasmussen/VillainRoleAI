//sends user question to AI
function sendQuestion() {
    const question = document.getElementById('question').value; //get question from user form.
    const aiResponseElement = document.getElementById('aiResponse'); //get ai response element.

    aiResponseElement.textContent = "Venter på svar..."; //set ai response

    //get ai response from backend.
    fetch('/villain?question=' + encodeURIComponent(question))//fetch ai response from backend url.
        .then(response => response.json())  //convert response to json.
        .then(data => aiResponseElement.textContent = data.choices[0].message.content) //set ai response text: first message in Response.choices.
        .catch(error => { //error handling.
            console.error('Fejl:', error);
            aiResponseElement.textContent = "Noget gik galt, prøv igen.";
        }); //end of fetch.
}