//sends user question to AI
function sendQuestion() {
    const question = document.getElementById('question').value; //get question from user form.
    const aiResponseElement = document.getElementById('aiResponse'); //get ai response element.

    aiResponseElement.textContent = "Venter på svar..."; //set ai response

    //get ai response from backend.
    fetch('localhost:8080/villain?question=' + question)//fetch ai response from backend url.
        .then(response => {
            if (response.ok){
                response.json();//convert response to json.
            }else{
                console.log("response not ok");
            }
        })
        .then(data => {
            aiResponseElement.textContent = data.choices[0].message.content; //set ai response text: first message in Response.choices.
            console.log("set ai response text");

        })
        .catch(error => { //error handling.
            console.log('Fejl: ' + error);
            aiResponseElement.textContent = "Noget gik galt, prøv igen.";
        }); //end of fetch.
}